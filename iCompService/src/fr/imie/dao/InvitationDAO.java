package fr.imie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.dao.interfaces.IInvitationDAO;
import fr.imie.dto.Groupe;
import fr.imie.dto.Invitation;
import fr.imie.dto.Utilisateur;
import fr.imie.exceptionManager.ExceptionManager;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * Invitation DAO
 * 
 * @author imie
 * @version 1.0
 */
public class InvitationDAO  extends ATransactional implements IInvitationDAO {
	
	private static final String INV_ID = "INV_ID";
	private static final String INV_REPONSE = "INV_REPONSE";
	private static final String INV_DATE = "INV_DATE";
	
	public List<Invitation> findInvitationById(String invid) throws TransactionalConnectionException {
		List<Invitation> invitations = new ArrayList<Invitation>();

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM INVITATION WHERE INV_ID = ? ";

		try {
			pstmt = getConnection().prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Invitation inv = buildDTO(rs);
				invitations.add(inv);
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
		return invitations;
	}
	
	private Invitation buildDTO(ResultSet rs) throws SQLException,
		TransactionalConnectionException {
		// IUtilisateurDAO utilisateurDAO =
		// Factory.getInstance().createUserDAO(this);
		// IStatutDAO StatutDAO = Factory.getInstance().createStatutDAO(this);

		// création d'un nouveau groupe
		Invitation invitation = new Invitation();
		invitation.setId(rs.getInt(INV_ID));
		invitation.setReponse(rs.getBoolean(INV_REPONSE));
		invitation.setDate(rs.getDate(INV_DATE));
		

		// // récupération des utilisateurs d'un groupe
		// List<Utilisateur> utilisateurs = UtilisateurDAO.getUser(groupe);
		// // parcours des users du groupe
		// for (Utilisateur utilisateur : utilisateurs) {
		// groupe.addUtilisateur(utilisateur);
		// }
		return invitation;
		}
	

	@Override
	public List<Groupe> getInvitations() throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Invitation insertInvitation(Invitation InvitationToInsert) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Invitation updateInvitation(Invitation InvitationToUpdate) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInvitation(Invitation InvitationToDelete) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Invitation> getInvitationsByUser(Utilisateur user) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
