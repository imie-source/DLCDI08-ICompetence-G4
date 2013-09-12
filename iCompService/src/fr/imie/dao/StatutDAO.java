package fr.imie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.TransactionRequiredException;

import fr.imie.dao.interfaces.IGroupeDAO;
import fr.imie.dao.interfaces.IStatutDAO;
import fr.imie.dto.Groupe;
import fr.imie.dto.Statut;
import fr.imie.exceptionManager.ExceptionManager;
import fr.imie.factory.Factory;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;


public class StatutDAO extends ATransactional implements IStatutDAO {
	// SQL Fields
	
	private static final String STA_ID = "STA_ID";
	private static final String STA_LIBELLE = "STA_LIBELLE";
	
	@Override
	public List<Statut> findallStatuts() throws TransactionalConnectionException {
		List<Statut> statuts = new ArrayList<Statut>();

		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM statut";

		try {
			stmt = getConnection().createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Statut sta = buildDTO(rs);
				statuts.add(sta);
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
		return statuts;
	}
	
	@Override
	public Statut findStatutById(String staId)  throws TransactionalConnectionException {
		
		Statut statut = new Statut();
		int k = Integer.valueOf(staId).intValue();   
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT STA_LIBELLE FROM STATUT WHERE STA_ID = ? ";

		try {
			pstmt = getConnection().prepareStatement(query);
			pstmt.setInt(1, k);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				statut.setId(rs.getInt(STA_ID));
				statut.setLibelle(rs.getString(STA_LIBELLE));
				
				//IStatutDAO statutDAO = Factory.getInstance().createStatutDAO(this);

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

		return statut;

	}
	
	
	

	@Override
	public Statut insertStatut(Statut statutToInsert)
			throws TransactionalConnectionException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Statut statut = null;
		String query = "INSERT INTO STATUT (STA_Id , STA_Libelle ) VALUES (? , ?)";

		try {
			pstmt = getConnection().prepareStatement(query);
			
			pstmt.setInt(1, statutToInsert.getId());
			
			pstmt.setString(2, statutToInsert.getLibelle());
		
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				statut = buildDTO(rs);
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
		return statut;
	}

	@Override
	public Statut updateStatut(Statut statutToUpdate)
			throws TransactionalConnectionException {
		Statut statutRetour = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {                                           
			String query = "update statut set STA_Id=?, STA_Libelle=? where sta_ID=?";
			pstmt = getConnection().prepareStatement(query);

			pstmt.setInt(1, statutToUpdate.getId());
			pstmt.setString(2, statutToUpdate.getLibelle());
						
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
		return statutRetour;
	}

	@Override
	public void deleteStatut(Statut statutToDelete)
			throws TransactionalConnectionException {
		// Batch Delete User
		String QUERY_DELETE_FROM_STA_ID = "DELETE FROM STATUT WHERE STA_ID = ";


		// déclaration de la variable de statement
		Statement stmt = null;
		// déclaration de la variable de resultset
		ResultSet rs = null;
		try {
			stmt = getConnection().createStatement();
			stmt.addBatch(QUERY_DELETE_FROM_STA_ID + statutToDelete.getId());
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
	public List<Statut> getStatutsByGRP(Groupe groupe)
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
	private Statut buildDTO(ResultSet rs) throws SQLException,
			TransactionalConnectionException {
		// IUtilisateurDAO utilisateurDAO =
		// Factory.getInstance().createUserDAO(this);
		// IStatutDAO StatutDAO = Factory.getInstance().createStatutDAO(this);

		// création d'un nouveau groupe
		Statut statut = new Statut();
		statut.setId(rs.getInt("STA_ID"));
		statut.setLibelle(rs.getString("STA_LIBELLE"));

		// // récupération des utilisateurs d'un groupe
		// List<Utilisateur> utilisateurs = UtilisateurDAO.getUser(groupe);
		// // parcours des users du groupe
		// for (Utilisateur utilisateur : utilisateurs) {
		// groupe.addUtilisateur(utilisateur);
		// }
		return statut;
	}
}
