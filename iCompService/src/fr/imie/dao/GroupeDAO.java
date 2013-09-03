package fr.imie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.TransactionRequiredException;

import fr.imie.dao.interfaces.IGroupeDAO;
import fr.imie.dto.Groupe;
import fr.imie.dto.Utilisateur;
import fr.imie.exceptionManager.ExceptionManager;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

public class GroupeDAO extends ATransactional implements IGroupeDAO {
	// SQL Fields
	private static final String GRP_ID = "GRP_ID";

	@Override
	public List<Groupe> getGroupes() throws TransactionalConnectionException {
		List<Groupe> groupes = new ArrayList<Groupe>();

		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM groupe";

		try {
			stmt = getConnection().createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Groupe grp = buildDTO(rs);
				groupes.add(grp);
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
		return groupes;
	}

	@Override
	public Groupe insertGroupe(Groupe groupeToInsert) throws TransactionalConnectionException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Groupe groupe = null;
		String query = "INSERT INTO GROUPES (GRP_Avancement , GRP_Nom_Projet , GRP_Description , STA_ID , USR_ID ) VALUES (? , ? , ? , ? , ?)";

		try {
			pstmt = getConnection().prepareStatement(query);
			pstmt.setString(1, groupeToInsert.getNom());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				groupe = buildDTO(rs);
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
		return groupe;
	}

	@Override
	public Groupe updateGroupe(Groupe groupeToUpdate) throws TransactionalConnectionException {
		Groupe groupeRetour = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String query = "update groupe set grp_nom_projet=?, grp_avancement=?, grp_description=?, sta_ID=? where grp_ID=?";
			pstmt = getConnection().prepareStatement(query);

			pstmt.setString(1, groupeToUpdate.getNom());

			if (groupeToUpdate.getStatut() != null) {
				pstmt.setInt(4,groupeToUpdate.getStatut().getId());
			} else {
				pstmt.setNull(4, Types.INTEGER);
			}

			pstmt.executeUpdate();

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
		return groupeRetour;
	}

	@Override
	public void deleteGroupe(Groupe groupeToDelete) throws TransactionalConnectionException {
		// Batch Delete User
		String QUERY_DELETE_FROM_GRP_USER = "DELETE FROM GRP_USER WHERE GRP_ID = ";
		String QUERY_DELETE_FROM_INVITATION = "DELETE FROM INVITATION WHERE GRP_ID = ";
		String QUERY_UPDATE_GROUPE = "DELETE GROUPE SET GRP_ID = null WHERE GRP_ID = ";

		// déclaration de la variable de statement
		Statement stmt = null;
		// déclaration de la variable de resultset
		ResultSet rs = null;
		try {
			stmt = getConnection().createStatement();

			stmt.addBatch(QUERY_DELETE_FROM_GRP_USER + groupeToDelete.getId());
			stmt.addBatch(QUERY_DELETE_FROM_INVITATION + groupeToDelete.getId());
			stmt.addBatch(QUERY_UPDATE_GROUPE + groupeToDelete.getId());
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

	@Override
	public List<Groupe> getGroupesByUser(Utilisateur user) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
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
	private Groupe buildDTO(ResultSet rs) throws SQLException, TransactionalConnectionException {
		//IUtilisateurDAO utilisateurDAO = Factory.getInstance().createUserDAO(this);
		//IStatutDAO StatutDAO = Factory.getInstance().createStatutDAO(this);

		// création d'un nouveau groupe
		Groupe groupe = new Groupe();
		groupe.setId(rs.getInt(GRP_ID));

//		// récupération des utilisateurs d'un groupe
//		List<Utilisateur> utilisateurs = UtilisateurDAO.getUser(groupe);
//		// parcours des users du groupe
//		for (Utilisateur utilisateur : utilisateurs) {
//			groupe.addUtilisateur(utilisateur);
//		}
		return groupe;
	}
}
