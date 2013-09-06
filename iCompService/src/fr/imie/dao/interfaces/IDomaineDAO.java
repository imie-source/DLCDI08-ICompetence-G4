/**
 * 
 */
package fr.imie.dao.interfaces;

import java.util.List;

import fr.imie.dto.Domaine;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * @author imie
 *
 */
public interface IDomaineDAO {

	List<Domaine> getDomaines() throws TransactionalConnectionException;

	Domaine insertDomaine(Domaine domaine)
			throws TransactionalConnectionException;

	Domaine updateDomaine(Domaine domaine)
			throws TransactionalConnectionException;

	void deleteDomaine(Domaine domaine) throws TransactionalConnectionException;

}
