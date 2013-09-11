package fr.imie.service.interfaces;

import java.util.List;

import fr.imie.dto.Competence;
import fr.imie.dto.Cursus;
import fr.imie.dto.Domaine;
import fr.imie.dto.Keyword;
import fr.imie.dto.Utilisateur;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

public interface IUserService extends ITransactional {

	/**
	 * @return liste des users avec alimentation des compétences sans filtre
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException 
	 */
	public abstract List<Utilisateur> getUsers() throws TransactionalConnectionException;

	public abstract Utilisateur insertUser(Utilisateur userToInsert) throws TransactionalConnectionException;

	public abstract Utilisateur updateUser(Utilisateur userToUpdate) throws TransactionalConnectionException;

	public abstract void deleteUser(Utilisateur userToDelete) throws TransactionalConnectionException;

	public abstract List<Utilisateur> getUsersByCompetence(Competence comp) throws TransactionalConnectionException;
	
	public abstract Utilisateur findUserByLogin(String login) throws TransactionalConnectionException;
	
	public abstract Utilisateur findUser(Utilisateur user) throws TransactionalConnectionException;	
	
	// CURSUS
	public Cursus findCursus(int id) throws TransactionalConnectionException;
	
	public abstract List<Cursus> findAllCursus() throws TransactionalConnectionException;
	
	public abstract Cursus findCursusByUser(Utilisateur userDTO) throws TransactionalConnectionException;

	// COMPETENCE
	public abstract List<Competence> getCompetenceByUser(Utilisateur user) throws TransactionalConnectionException;
	
	public abstract List<Competence> getCompetences() throws TransactionalConnectionException;

	public abstract List<Competence> getCompetenceByKeyword(Keyword keyword)
			throws TransactionalConnectionException;

	// DOMAINE
	public abstract List<Domaine> getDomaines() throws TransactionalConnectionException;

	public abstract Domaine insertDomaine(Domaine domaine)
			throws TransactionalConnectionException;

	public abstract Domaine updateDomaine(Domaine domaine)
			throws TransactionalConnectionException;

	public abstract void deleteDomaine(Domaine domaine) throws TransactionalConnectionException;
	
	// KEYWORD
	
	public abstract List<Keyword> getKeyword() throws TransactionalConnectionException;

	public abstract Keyword insertKeyword(Keyword keyword)
			throws TransactionalConnectionException;

	public abstract Keyword updateKeyword(Keyword keyword)
			throws TransactionalConnectionException;


	public abstract void deleteKeyword(Keyword keyword) throws TransactionalConnectionException;

public abstract Keyword findCompetenceByKeyword(Keyword keyword2) throws TransactionalConnectionException;

public abstract Utilisateur IsAuthorized(Utilisateur user)
			throws TransactionalConnectionException;



}