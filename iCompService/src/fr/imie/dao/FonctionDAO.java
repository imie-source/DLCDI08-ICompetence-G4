/**
 * 
 */
package fr.imie.dao;

import java.util.List;

import fr.imie.dao.interfaces.IFonctionDAO;
import fr.imie.dto.Fonction;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * DAO de gestion de la table Fonction
 * @author imie
 *
 */
public class FonctionDAO extends ATransactional implements IFonctionDAO {

	@Override
	public List<Fonction> getFonctions() throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fonction insertFonction(Fonction fonction) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fonction updateFonction(Fonction fonction) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFonction(Fonction fonction) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		
	}

}
