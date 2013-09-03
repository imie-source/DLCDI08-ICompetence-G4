/**
 * 
 */
package fr.imie.dao;

import java.util.List;

import fr.imie.dao.interfaces.IFenetreDAO;
import fr.imie.dto.Fenetre;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * DAO de gestion de la table Fenetre
 * @author imie
 *
 */
public class FenetreDAO extends ATransactional implements IFenetreDAO {

	@Override
	public List<Fenetre> getFenetres() throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fenetre insertFenetre(Fenetre fenetre) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fenetre updateFenetre(Fenetre fenetre) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFenetre(Fenetre fenetre) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		
	}

}
