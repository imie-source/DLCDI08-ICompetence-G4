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
import fr.imie.dao.interfaces.IUtilisateurDAO;
import fr.imie.dto.Groupe;
import fr.imie.dto.Statut;
import fr.imie.dto.Utilisateur;
import fr.imie.exceptionManager.ExceptionManager;
import fr.imie.factory.Factory;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

public class GroupeDAO extends ATransactional implements IGroupeDAO {
	// SQL Fields
	private static final String GRP_ID = "GRP_ID";
	private static final String GRP_AVANCEMENT = "GRP_AVANCEMENT";
	private static final String GRP_DESCRIPTION = "GRP_DESCRIPTION";
	private static final String GRP_RESUME = "GRP_RESUME";
	private static final String GRP_NOM = "GRP_NOM";
	private static final String STA_ID = "STA_ID";
	private static final String STA_LIBELLE = "STA_LIBELLE";


	@Override
	public List<Groupe> getGroupes() throws TransactionalConnectionException {
		List<Groupe> groupes = new ArrayList<Groupe>();

		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM groupe ORDER BY GRP_NOM";

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
	public Groupe findGroupById(int id)  throws TransactionalConnectionException {
		
		Groupe groupe = new Groupe();
		Statut statut = new Statut();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * from statut sta, groupe grp where (grp_id = ?)" +
				       "and (sta.sta_id = grp.sta_id)";
		try {
			pstmt = getConnection().prepareStatement(query);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
								
				groupe.setId(rs.getInt(GRP_ID));
				groupe.setAvancement(rs.getInt(GRP_AVANCEMENT));
				groupe.setDescription(rs.getString(GRP_DESCRIPTION));
				groupe.setResume(rs.getString(GRP_RESUME));
				groupe.setNom(rs.getString(GRP_NOM));
							
				statut.setId(rs.getInt(STA_ID));
				statut.setLibelle(rs.getString(STA_LIBELLE));
				
				groupe.setStatut(statut);
				
				//IGroupeDAO groupeDAO = Factory.getInstance().createGroupeDAO(this);

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
	public Groupe insertGroupe(Groupe groupeToInsert)
			throws TransactionalConnectionException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Groupe groupe = null;
		String query = "INSERT INTO GROUPES (GRP_Avancement , GRP_Nom_Projet , GRP_Description , GRP_Resume, STA_ID , USR_ID ) VALUES (? , ? , ? , ? , ?, ?)";

		try {
			pstmt = getConnection().prepareStatement(query);
			
			pstmt.setInt(1, groupeToInsert.getAvancement());
			
		
			if (groupeToInsert.getNom() == null) {
				pstmt.setNull(2, Types.CHAR);
			} else {
				pstmt.setString(2, groupeToInsert.getNom());
			};
	
			if (groupeToInsert.getDescription() == null) {
				pstmt.setNull(3, Types.CHAR);
			} else {
				pstmt.setString(3, groupeToInsert.getDescription());
			}

			if (groupeToInsert.getResume() == null) {
				pstmt.setNull(4, Types.CHAR);
			} else {
				pstmt.setString(4, groupeToInsert.getResume());
			}

			if (groupeToInsert.getStatut() == null) {
				pstmt.setNull(5, Types.CHAR);
			} else {
				pstmt.setInt(5, groupeToInsert.getStatut().getId());
			}
					
			
			if (groupeToInsert.getChefProjet() == null) {
				pstmt.setNull(6, Types.CHAR);
			} else {
				pstmt.setInt(6, groupeToInsert.getChefProjet().getId());
			}

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
	public Groupe updateGroupe(Groupe groupeToUpdate)
			throws TransactionalConnectionException {
		Groupe groupeRetour = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String query = "update groupe set GRP_Avancement=?, GRP_Nom_Projet=?, GRP_Description=?, GRP_Resume=?, STA_ID=?, USR_ID=? where grp_ID=?";
			pstmt = getConnection().prepareStatement(query);

			pstmt.setInt(1, groupeToUpdate.getAvancement());
			pstmt.setString(2, groupeToUpdate.getNom());
			pstmt.setString(3, groupeToUpdate.getDescription());
			pstmt.setString(4, groupeToUpdate.getResume());
			
			
			if (groupeToUpdate.getStatut() != null) {
				pstmt.setInt(5, groupeToUpdate.getStatut().getId());
			} else {
				pstmt.setNull(5, Types.INTEGER);
			}

			if (groupeToUpdate.getChefProjet() != null) {
			pstmt.setInt(6, groupeToUpdate.getChefProjet().getId());
			} else {
				pstmt.setNull(6, Types.INTEGER);
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
	public void deleteGroupe(Groupe groupeToDelete)
			throws TransactionalConnectionException {
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
	public List<Groupe> getGroupesByUser(Utilisateur user)
			throws TransactionalConnectionException {
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
	private Groupe buildDTO(ResultSet rs) throws SQLException,
			TransactionalConnectionException {
		// IUtilisateurDAO utilisateurDAO =
		// Factory.getInstance().createUserDAO(this);
		// IStatutDAO StatutDAO = Factory.getInstance().createStatutDAO(this);

		// création d'un nouveau groupe
		Groupe groupe = new Groupe();
		groupe.setId(rs.getInt(GRP_ID));
		groupe.setAvancement(rs.getInt(GRP_AVANCEMENT));
		groupe.setDescription(rs.getString(GRP_DESCRIPTION));
		groupe.setNom(rs.getString(GRP_NOM));

		// // récupération des utilisateurs d'un groupe
		// List<Utilisateur> utilisateurs = UtilisateurDAO.getUser(groupe);
		// // parcours des users du groupe
		// for (Utilisateur utilisateur : utilisateurs) {
		// groupe.addUtilisateur(utilisateur);
		// }
		return groupe;
	}

	@Override
	public List<Groupe> findGroupByStatut(int id)  throws TransactionalConnectionException {
		List<Groupe> groupes = new ArrayList<Groupe>();
		List<Utilisateur> users  = new ArrayList<Utilisateur>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM GROUPE WHERE STA_ID = ?";
		IUtilisateurDAO userDAO = Factory.getInstance().createUserDAO(this);


		try {
			pstmt = getConnection().prepareStatement(query);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Groupe groupe = new Groupe();
				groupe.setId(rs.getInt(GRP_ID));
				groupe.setAvancement(rs.getInt(GRP_AVANCEMENT));
				groupe.setDescription(rs.getString(GRP_DESCRIPTION));
				groupe.setNom(rs.getString(GRP_NOM));
				for (Utilisateur utilisateur : users) {
					groupe.addUtilisateur(utilisateur);	
				}
				
				Utilisateur chefProjet = new Utilisateur();
				chefProjet = userDAO.findUserByProject(groupe);
				groupe.setChefProjet(chefProjet);
				
				groupes.add(groupe);
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
		return groupes;
	}
}
