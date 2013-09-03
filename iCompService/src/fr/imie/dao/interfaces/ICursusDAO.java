package fr.imie.dao.interfaces;

import java.util.List;

import fr.imie.dto.Cursus;
import fr.imie.dto.Utilisateur;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * interface de DAO de la table cursus
 * 
 * @author imie
 * 
 */
public interface ICursusDAO extends ITransactional {

	/**
	 * rechercher un cursus par son Id
	 * 
	 * @param id
	 * @return
	 * @throws TransactionalConnectionException
	 */
	public abstract Cursus findCursus(int id) throws TransactionalConnectionException;

	/**
	 * rechercher le cursus d'un utilisateur
	 * 
	 * @param userDTO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract Cursus findCursusByUser(Utilisateur userDTO) throws TransactionalConnectionException;

	/**
	 * recherche de tous les cursus
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract List<Cursus> findAllCursus() throws TransactionalConnectionException;

}