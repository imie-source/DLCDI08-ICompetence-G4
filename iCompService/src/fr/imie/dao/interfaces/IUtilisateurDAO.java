package fr.imie.dao.interfaces;

import java.util.List;


import fr.imie.dto.Competence;
import fr.imie.dto.Utilisateur;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * interface de DAO de gestion des utlisateurs
 * 
 * @author imie
 * 
 */
public interface IUtilisateurDAO extends ITransactional {

	/**
	 * rechercher tous les utlisateurs
	 * 
	 * @return liste des users avec alimentation des compétences sans filtre
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract List<Utilisateur> getUsers() throws TransactionalConnectionException;

	/**
	 * insérer un utilisateur
	 * 
	 * @param userToInsert
	 * @return l'utilisateur indéré
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract Utilisateur insertUser(Utilisateur userToInsert) throws TransactionalConnectionException;

	/**
	 * mettre à jour un utlisateur
	 * 
	 * @param userToUpdate
	 * @return l'utilisateur mis à jour
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract Utilisateur updateUser(Utilisateur userToUpdate) throws TransactionalConnectionException;

	/**
	 * supprimer un utilisateur
	 * 
	 * @param userToDelete
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract void deleteUser(Utilisateur userToDelete) throws TransactionalConnectionException;

	/**
	 * 
	 * @param comp
	 * @return
	 * @throws TransactionalConnectionException
	 */
	public abstract List<Utilisateur> getUsersByCompetence(Competence comp) throws TransactionalConnectionException;

	/**
	 * 
	 * @param login
	 * @return
	 * @throws TransactionalConnectionException 
	 */
	public abstract Utilisateur findUserByLogin(String login) throws TransactionalConnectionException;

	public abstract Utilisateur findUser(Utilisateur user2) throws TransactionalConnectionException;

}