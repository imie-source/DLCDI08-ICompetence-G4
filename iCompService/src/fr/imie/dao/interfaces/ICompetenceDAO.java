package fr.imie.dao.interfaces;

import java.util.List;


import fr.imie.dto.Competence;
import fr.imie.dto.Utilisateur;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * interface de DAO de la table compétence
 * @author imie
 *
 */
public interface ICompetenceDAO extends ITransactional {

	/**
	 * @param userDTO
	 * @return liste des compétences par utilisateur
	 * @throws ClassNotFoundException
	 * @throws TransactionalConnectionException 
	 */
	public abstract List<Competence> getCompetenceByUser(Utilisateur userDTO) throws
			TransactionalConnectionException;

	public abstract List<Competence> getCompetences() throws TransactionalConnectionException;


}