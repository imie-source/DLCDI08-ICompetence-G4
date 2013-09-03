package fr.imie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import fr.imie.dao.interfaces.ICompetenceDAO;
import fr.imie.dao.interfaces.INiveauxDAO;
import fr.imie.dao.interfaces.IUtilisateurDAO;
import fr.imie.dto.Competence;
import fr.imie.dto.Niveau;
import fr.imie.dto.Utilisateur;
import fr.imie.exceptionManager.ExceptionManager;
import fr.imie.factory.Factory;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * DAO de la table compétences
 * 
 * @author imie
 * 
 */
public class CompetenceDAO extends ATransactional implements ICompetenceDAO {
	// SQL Fields
	private static final String COM_ID = "COM_ID";
	private static final String COM_LIBELLE = "COM_Libelle";


	/* (non-Javadoc)
	 * @see org.imie.DAO.ICompetenceDAO#getCompetenceByUser(org.imie.DTO.UserDTO, java.sql.Connection)
	 */
	@Override
	public List<Competence> getCompetenceByUser(Utilisateur user) throws TransactionalConnectionException {
		INiveauxDAO niveauxDAO = Factory.getInstance().createNiveauDAO(this);
		List<Competence> comList = new ArrayList<Competence>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM COMPETENCE C INNER JOIN COM_USER CU ON C.COM_ID = CU.COM_ID INNER JOIN UTILISATEUR U ON U.USR_ID = CU.USR_ID WHERE U.USR_ID = ? ORDER BY C.COM_ID";

		try {
			pstmt = getConnection().prepareStatement(query);
			pstmt.setInt(1, user.getId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Competence comp = new Competence();
				comp.setId(rs.getInt(COM_ID));
				comp.setLibelle(rs.getString(COM_LIBELLE));
				Niveau niveau = niveauxDAO.getNiveau(user, comp);
				comp.setNiveau(niveau);
				comList.add(comp);
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
		return comList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.dlcdi.idao.ICompetenceDAO#listCompetences()
	 */
	@Override
	public List<Competence> getCompetences()  throws TransactionalConnectionException {
		IUtilisateurDAO userDAO = Factory.getInstance().createUserDAO(this);

		List<Competence> comList = new ArrayList<Competence>();
		ResultSet rs = null;
		Statement stmt = null;
		List<Utilisateur> user = null;
		String query = "SELECT * FROM COMPETENCE C ORDER BY C.COM_ID";

		try {
			stmt = getConnection().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Competence com = new Competence();
				com.setId(rs.getInt(COM_ID));
				com.setLibelle(rs.getString(COM_LIBELLE));
				try {
					user = userDAO.getUsersByCompetence(com);
					com.setUtilisateur(user);
					comList.add(com);
				} catch (TransactionalConnectionException e) {
					ExceptionManager.getInstance().manageException(e);
				}
			}
		} catch (SQLException e) {
			ExceptionManager.getInstance().manageException(e);

		} finally {
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
		return comList;
	}
}
