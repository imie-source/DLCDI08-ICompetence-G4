package fr.imie.dao.interfaces;

import java.util.List;

import fr.imie.dto.Groupe;
import fr.imie.dto.Statut;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
* interface de DAO de gestion des statuts
* 
* @author imie
* 
*/

public interface IStatutDAO extends ITransactional {
	
	/**
	 * rechercher tous les statuts
	 * 
	 * @return liste des statuts
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract List<Statut> findallStatuts() throws TransactionalConnectionException;

	/**
	 * insérer un statut
	 * 
	 * @param statutToInsert
	 * @return le statut inséré
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	
	public abstract Statut findStatutById(String staId)  throws TransactionalConnectionException;
	
	/**
	 * Recherche du libelle d'un statut
	 * 
	 * @param statut_Num
	 * @return le libellé statut
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	
	
	public abstract Statut insertStatut(Statut statutToInsert) throws TransactionalConnectionException;

	/**
	 * mettre à jour un statut
	 * 
	 * @param statutToUpdate
	 * @return le statut mis à jour
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract Statut updateStatut(Statut statutToUpdate) throws TransactionalConnectionException;

	/**
	 * supprimer un statut
	 * 
	 * @param statutToDelete
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException
	 */
	public abstract void deleteStatut(Statut statutToDelete) throws TransactionalConnectionException;

	/**
	 * 
	 * @param user
	 * @return
	 * @throws TransactionalConnectionException
	 */
	public abstract List<Statut> getStatutsByGRP(Groupe groupe) throws TransactionalConnectionException;


}
