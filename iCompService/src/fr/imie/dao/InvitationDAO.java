package fr.imie.dao;

import java.util.List;

import fr.imie.dao.interfaces.IInvitationDAO;
import fr.imie.dto.Groupe;
import fr.imie.dto.Invitation;
import fr.imie.dto.Utilisateur;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * Invitation DAO
 * 
 * @author imie
 * @version 1.0
 */
public class InvitationDAO  extends ATransactional implements IInvitationDAO {

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
