package fr.imie.dao.interfaces;

import java.util.List;


import fr.imie.dto.Groupe;
import fr.imie.dto.Invitation;
import fr.imie.dto.Utilisateur;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * interface de DAO de gestion des invitations
 * 
 * @author imie
 * 
 */
public interface IInvitationDAO extends ITransactional {

	/**
	 * rechercher tous les invitations
	 * 
	 * @return liste des invitations
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract List<Groupe> getInvitations() throws TransactionalConnectionException;

	/**
	 * insérer un groupe
	 * 
	 * @param invitationToInsert
	 * @return le invitation inséré
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract Invitation insertInvitation(Invitation InvitationToInsert) throws TransactionalConnectionException;

	/**
	 * mettre à jour un Invitation
	 * 
	 * @param InvitationToUpdate
	 * @return le Invitation mis à jour
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract Invitation updateInvitation(Invitation InvitationToUpdate) throws TransactionalConnectionException;

	/**
	 * supprimer un Invitation
	 * 
	 * @param InvitationToDelete
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract void deleteInvitation(Invitation InvitationToDelete) throws TransactionalConnectionException;

	/**
	 * 
	 * @param user
	 * @return
	 * @throws TransactionalConnectionException
	 */
	public abstract List<Invitation> getInvitationsByUser(Utilisateur user) throws TransactionalConnectionException;


}