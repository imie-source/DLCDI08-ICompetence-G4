/**
 * 
 */
package fr.imie.dao;

import java.util.List;

import fr.imie.dao.interfaces.IDroitDAO;
import fr.imie.dto.Droit;
import fr.imie.dto.Profil;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * DAO de gestion de la table Droit
 * @author imie
 *
 */
public class DroitDAO extends ATransactional implements IDroitDAO{

	@Override
	public List<Droit> getDroits() throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profil insertDroit(Droit droit) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Droit updateDroit(Droit droit) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDroit(Droit droit) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		
	}

}
