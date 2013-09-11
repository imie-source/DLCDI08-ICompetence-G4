package fr.imie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.TransactionRequiredException;

import fr.imie.dao.interfaces.ICompetenceDAO;
import fr.imie.dao.interfaces.ICursusDAO;
import fr.imie.dao.interfaces.IUtilisateurDAO;
import fr.imie.dto.Competence;
import fr.imie.dto.Cursus;
import fr.imie.dto.Utilisateur;
import fr.imie.exceptionManager.ExceptionManager;
import fr.imie.factory.Factory;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * DAO de gestion de la table Utilisateur
 * 
 * @author imie
 * 
 */
public class UtilisateurDAO extends ATransactional implements IUtilisateurDAO {
	private static final String USR_EST_EN_FORMATION = "USR_estEnFormation";
	private static final String USR_EST_DISPONIBLE = "USR_estDisponible";
	// SQL Fields
	private static final String USR_ID = "USR_ID";
	private static final String USR_NOM = "USR_Nom";
	private static final String USR_PRENOM = "USR_Prenom";
	private static final String USR_LOGIN = "USR_login";
	private static final String USR_DATE_N = "USR_DateN";
	private static final String USR_MAIL = "USR_mail";
	private static final String USR_TEL = "USR_Tel";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.DAO.IuserDAO#getUsers()
	 */
	@Override
	public List<Utilisateur> getUsers() throws TransactionalConnectionException {

		// initialisation de la liste qui servira au retour
		List<Utilisateur> userDTOs = new ArrayList<Utilisateur>();

		// déclaration de la variable de statement
		Statement stmt = null;
		// déclaration de la variable de resultset
		ResultSet rs = null;
		String query = "SELECT * FROM UTILISATEUR ORDER BY USR_ID";

		try {
			// création du statement à partir de la connection
			stmt = getConnection().createStatement();
			// execution d'une requête SQL et récupération du result dans le
			// resultset
			rs = stmt.executeQuery(query);
			// parcours du resultset
			while (rs.next()) {
				Utilisateur userDTO = buildDTO(rs);
				// ajout du DTO dans la liste de retour
				userDTOs.add(userDTO);
			}

		} catch (SQLException e) {
			ExceptionManager.getInstance().manageException(e);
		} finally {

			// libération des ressources

			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}

			} catch (SQLException e) {
				ExceptionManager.getInstance().manageException(e);
			}
		}
		return userDTOs;
	}

	/**
	 * construction d'un DTO à partir d'un resultset
	 * 
	 * @param cn
	 *            la connection avec laquel le resulset
	 * @param rs
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 * @throws TransactionRequiredException
	 */
	private Utilisateur buildDTO(ResultSet rs) throws SQLException, TransactionalConnectionException {
		// initialisation du DAO de gestion des compétences
		ICompetenceDAO competenceDAO = Factory.getInstance().createCompetenceDAO(this);
		ICursusDAO cursusDAO = Factory.getInstance().createCursusDAO(this);

		// création d'un nouveau UserDTO
		Utilisateur user = new Utilisateur();
		// affectation des attribut du UserDTO à partir des valeurs du
		// resultset sur l'enregistrement courant
		user.setNom(rs.getString(USR_NOM));
		user.setPrenom(rs.getString(USR_PRENOM));
		user.setLogin(rs.getString(USR_LOGIN));
		user.setId(rs.getInt(USR_ID));
		user.setDateNaissance(rs.getDate(USR_DATE_N));

		// récupération des compétences du user grâce au competenceDAO
		// la connection passée en paramètre permet de partager la
		// connection entre cette methode et celle appelée

		List<Competence> competenceDTOs = competenceDAO.getCompetenceByUser(user);
		// parcours des compétences du user
		for (Competence competenceDTO : competenceDTOs) {
			// ajout des compétences sur le UserDTO à partir de celles
			// fournies par le CompetenceDAO
			user.addCompetence(competenceDTO);
		}

		Cursus cursusDTO = cursusDAO.findCursusByUser(user);

		user.setCursus(cursusDTO);
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.DAO.IuserDAO#insertUser(org.imie.DTO.UserDTO)
	 */
	@Override
	public Utilisateur insertUser(Utilisateur user) throws TransactionalConnectionException {
		// déclaration de la variable de statement
		PreparedStatement pstmt = null;
		// déclaration de la variable de resultset
		ResultSet rs = null;
		Utilisateur userDTOinserted = null;

		String query = "INSERT INTO UTILISATEUR (USR_Nom , USR_Prenom , USR_DateN , USR_Mail , USR_Tel , USR_Fax , USR_Login , USR_Pass , CUR_ID , ADR_ID) VALUES (? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

		try {

			// execution d'une requête SQL et récupération du result dans le
			// resultset
			pstmt = getConnection().prepareStatement(query);

			pstmt.setString(1, user.getNom());
			pstmt.setString(2, user.getPrenom());
			if (user.getDateNaissance() == null){
				pstmt.setNull(3, Types.DATE);
			} else {
				pstmt.setDate(3, new java.sql.Date(user.getDateNaissance().getTime()));
			}
			pstmt.setString(4, user.getMail());
			pstmt.setString(5, user.getTel());
			pstmt.setString(6, user.getFax());
			pstmt.setString(7, user.getLogin());
			pstmt.setString(8, user.getPass());
			if (user.getCursus() == null) {
				pstmt.setNull(9, Types.INTEGER);
			} else {
				pstmt.setInt(9, user.getCursus().getId());
			}
			if (user.getAdresse() == null) {
				pstmt.setNull(10, Types.INTEGER);
			} else {
				pstmt.setInt(10, user.getAdresse().getId());
			}

			rs = pstmt.executeQuery();

			if (rs.next()) {
				userDTOinserted = buildDTO(rs);
			}

		} catch (SQLException e) {
			ExceptionManager.getInstance().manageException(e);
		} finally {

			// libération des ressources
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (SQLException e) {
				ExceptionManager.getInstance().manageException(e);
			}
		}
		return userDTOinserted;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.DAO.IuserDAO#updateUser(org.imie.DTO.UserDTO)
	 */
	@Override
	public Utilisateur updateUser(Utilisateur userToUpdate) throws TransactionalConnectionException {
		Utilisateur userDTORetour = null;
		PreparedStatement pstmt = null;
		// déclaration de la variable de resultset
		ResultSet rs = null;
		try {
			// execution d'une requête SQL et récupération du result
			String query = "update utilisateur set usr_nom=?, usr_prenom=?, usr_daten=?, usr_mail=?, usr_tel=?, usr_fax=?, usr_estenformation=?, usr_estdisponible=?, cur_ID=? where usr_Login=?";
			pstmt = getConnection().prepareStatement(query);
			pstmt.setString(1, userToUpdate.getNom());
			pstmt.setString(2, userToUpdate.getPrenom());
			if (userToUpdate.getDateNaissance() != null) {
				pstmt.setDate(3, new java.sql.Date(userToUpdate.getDateNaissance().getTime()));
			} else {
				pstmt.setNull(3, Types.DATE);
			}
			
			if (userToUpdate.getMail() != null && userToUpdate.getMail() != "") {
				pstmt.setString(4, userToUpdate.getMail());
			} else {
				pstmt.setString(4, "");
			}
			
			if (userToUpdate.getTel() != null && userToUpdate.getTel() != "") {
				pstmt.setString(5, userToUpdate.getTel());
			} else {
				pstmt.setString(5, "");
			}
			
			if (userToUpdate.getFax() != null && userToUpdate.getFax() != "") {
				pstmt.setString(6, userToUpdate.getFax());
			} else {
				pstmt.setString(6, "");
			}
			
			if (userToUpdate.getEstEnFormation() == 0 || userToUpdate.getEstEnFormation() == 1) {
				pstmt.setInt(7, userToUpdate.getEstEnFormation());
			} else {
				pstmt.setNull(7, Types.INTEGER);
			}
			
			if (userToUpdate.getEstDisponible() == 0 || userToUpdate.getEstDisponible() == 1) {
				pstmt.setInt(8, userToUpdate.getEstDisponible());
			} else {
				pstmt.setNull(8, Types.INTEGER);
			}
			
			if (userToUpdate.getCursus() != null) {
				pstmt.setInt(9, userToUpdate.getCursus().getId());
			} else {
				pstmt.setNull(9, Types.INTEGER);
			}

			pstmt.setString(10, userToUpdate.getLogin());
			System.out.println(pstmt.toString());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			ExceptionManager.getInstance().manageException(e);
		} finally {

			// libération des ressources
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (SQLException e) {
				ExceptionManager.getInstance().manageException(e);
			}
		}
		return userDTORetour;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.DAO.IuserDAO#deleteUser(org.imie.DTO.UserDTO)
	 */
	@Override
	public void deleteUser(Utilisateur user) throws TransactionalConnectionException {
		// Batch Delete User
		String QUERY_DELETE_FROM_GRP_USER = "DELETE FROM GRP_USER WHERE USR_ID = ";
		String QUERY_DELETE_FROM_COM_USER = "DELETE FROM COM_USER WHERE USR_ID = ";
		String QUERY_DELETE_FROM_INVITATION = "DELETE FROM INVITATION WHERE USR_ID = ";
		String QUERY_UPDATE_GROUPE = "UPDATE GROUPE SET USR_ID = null WHERE USR_ID = ";
		String QUERY_DELETE_FROM_UTILISATEUR = "DELETE FROM UTILISATEUR WHERE USR_ID = ";

		// déclaration de la variable de statement
		Statement stmt = null;
		// déclaration de la variable de resultset
		ResultSet rs = null;
		try {
			stmt = getConnection().createStatement();

			stmt.addBatch(QUERY_DELETE_FROM_GRP_USER + user.getId());
			stmt.addBatch(QUERY_DELETE_FROM_COM_USER + user.getId());
			stmt.addBatch(QUERY_DELETE_FROM_INVITATION + user.getId());
			stmt.addBatch(QUERY_UPDATE_GROUPE + user.getId());
			stmt.addBatch(QUERY_DELETE_FROM_UTILISATEUR + user.getId());

			stmt.executeBatch();

			System.out.println(user.getId());
		} catch (SQLException e) {
			ExceptionManager.getInstance().manageException(e);
		} finally {
			// libération des ressources
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				ExceptionManager.getInstance().manageException(e);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.imie.dlcdi.dao.IUtilisateurDAO#getUsersByCompetence(fr.imie.dlcdi.
	 * dto.Competence)
	 */
	@Override
	public List<Utilisateur> getUsersByCompetence(Competence comp) throws TransactionalConnectionException {

		List<Utilisateur> usrList = new ArrayList<Utilisateur>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String instruction = "SELECT * FROM COMPETENCE C INNER JOIN COM_USER CU ON C.COM_ID = CU.COM_ID INNER JOIN UTILISATEUR U ON U.USR_ID = CU.USR_ID WHERE C.COM_ID = ? ORDER BY C.COM_ID";

		try {
			pstmt = getConnection().prepareStatement(instruction);

			pstmt.setInt(1, comp.getId());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Utilisateur usr = new Utilisateur();
				usr.setId(rs.getInt(USR_ID));
				usr.setNom(rs.getString(USR_NOM));
				usr.setPrenom(rs.getString(USR_PRENOM));
				usr.setDateNaissance(rs.getDate(USR_DATE_N));
				usrList.add(usr);

			}

		} catch (SQLException e) {
			ExceptionManager.getInstance().manageException(e);
		} finally {
			// libération des ressources
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (SQLException e) {
				ExceptionManager.getInstance().manageException(e);
			}
		}
		return usrList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.dlcdi.dao.IUtilisateurDAO#findUserByLogin(String)
	 */
	@Override
	public Utilisateur findUserByLogin(String login) throws TransactionalConnectionException {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Utilisateur user = new Utilisateur();
		String query = "SELECT * FROM UTILISATEUR U WHERE U.USR_Login = ? ORDER BY U.USR_Nom";

		try {
			pstmt = getConnection().prepareStatement(query);
			pstmt.setString(1, login);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				user.setId(rs.getInt(USR_ID));
				user.setNom(rs.getString(USR_NOM));
				user.setPrenom(rs.getString(USR_PRENOM));
				user.setMail(rs.getString(USR_MAIL));
				user.setTel(rs.getString(USR_TEL));
				user.setLogin(rs.getString(USR_LOGIN));
				// user.setAge(ConvertUtils.getInstance().dateNToAge(rs.getDate(USR_DATE_N)));
				user.setDateNaissance(rs.getDate(USR_DATE_N));
				user.setEstDisponible(rs.getInt(USR_EST_DISPONIBLE));
				user.setEstEnFormation(rs.getInt(USR_EST_EN_FORMATION));
				
				ICursusDAO cursusDAO = Factory.getInstance().createCursusDAO(this);
				Cursus cursusDTO = cursusDAO.findCursusByUser(user);

				user.setCursus(cursusDTO);
			}
		} catch (SQLException e) {
			ExceptionManager.getInstance().manageException(e);
		} finally {
			// libération des ressources
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (SQLException e) {
				ExceptionManager.getInstance().manageException(e);
			}
		}

		return user;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.imie.dlcdi.dao.IUtilisateurDAO#findUser(fr.imie.dlcdi.dto.Utilisateur)
	 */
	@Override
	public Utilisateur findUser(Utilisateur user2) throws TransactionalConnectionException {
		String query = "SELECT * FROM UTILISATEUR U WHERE U.USR_ID = ? ORDER BY U.USR_ID";
		Utilisateur user = new Utilisateur();
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			pstmt = getConnection().prepareStatement(query);

			pstmt.setInt(1, user2.getId());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				user.setId(rs.getInt(USR_ID));
				user.setNom(rs.getString(USR_NOM));
				user.setPrenom(rs.getString(USR_PRENOM));
				user.setDateNaissance(rs.getDate(USR_DATE_N));

			}
		} catch (SQLException e) {
			ExceptionManager.getInstance().manageException(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				ExceptionManager.getInstance().manageException(e);
			}
		}

		return user;
	}
	
	
}