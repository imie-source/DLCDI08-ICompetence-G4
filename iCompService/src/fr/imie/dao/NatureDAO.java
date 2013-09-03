/**
 * 
 */
package fr.imie.dao;

import java.util.List;

import fr.imie.dao.interfaces.INatureDAO;
import fr.imie.dto.Nature;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * DAO de gestion de la table Nature
 * @author imie
 *
 */
public class NatureDAO extends ATransactional implements INatureDAO {

	@Override
	public List<Nature> getNatures() throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Nature insertProfil(Nature nature) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Nature updateProfil(Nature nature) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteNature(Nature nature) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		
	}

}
