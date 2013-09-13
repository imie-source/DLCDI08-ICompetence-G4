package fr.imie.dao.interfaces;

import java.util.List;


import fr.imie.dto.Groupe;
import fr.imie.dto.Utilisateur;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * interface de DAO de gestion des groupes
 * 
 * @author imie
 * 
 */
public interface IGroupeDAO extends ITransactional {

	/**
	 * rechercher tous les groupes
	 * 
	 * @return liste des groupes
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract List<Groupe> getGroupes() throws TransactionalConnectionException;

	/**
	 * rechercher un groupe
	 * 
	 * 
	 * 
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	
	public abstract Groupe findGroupById(String grpid)  throws TransactionalConnectionException;

	/**
	 * rechercher les informations d'un groupe
	 * 
	 * 
	 * 
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	
	public abstract Groupe insertGroupe(Groupe groupeToInsert) throws TransactionalConnectionException;

	/**
	 * mettre à jour un groupe
	 * 
	 * @param groupeToUpdate
	 * @return le groupe mis à jour
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract Groupe updateGroupe(Groupe groupeToUpdate) throws TransactionalConnectionException;

	/**
	 * supprimer un groupe
	 * 
	 * @param groupeToDelete
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract void deleteGroupe(Groupe groupeToDelete) throws TransactionalConnectionException;

	/**
	 * 
	 * @param user
	 * @return
	 * @throws TransactionalConnectionException
	 */
	public abstract List<Groupe> getGroupesByUser(Utilisateur user) throws TransactionalConnectionException;

	public abstract List<Groupe> findGroupByStatut(int id)
			throws TransactionalConnectionException;


}