package fr.imie.dao.interfaces;

import java.util.List;


import fr.imie.dto.Competence;
import fr.imie.dto.Niveau;
import fr.imie.dto.Utilisateur;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;
/**
 * interface de DAO de la table cursus
 * @author imie
 *
 */
public interface INiveauxDAO extends ITransactional{

	/**
	 * rechercher le cursus d'un utilisateur
	 * @param userDTO
	 * @param comp TODO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract List<Niveau> getNiveauByUsrAndComp(Utilisateur user, Competence comp) throws 
			TransactionalConnectionException;

	/**
	 * recherche de tous les cursus
	 * @param user TODO
	 * @param competence TODO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract Niveau getNiveau(Utilisateur user, Competence competence) throws TransactionalConnectionException;

}