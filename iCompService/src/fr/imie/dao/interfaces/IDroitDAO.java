package fr.imie.dao.interfaces;

import java.util.List;

import fr.imie.dto.Droit;
import fr.imie.dto.Profil;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * interface de DAO de gestion des utlisateurs
 * 
 * @author imie
 * 
 */
public interface IDroitDAO extends ITransactional {

	List<Droit> getDroits() throws TransactionalConnectionException;

	Profil insertDroit(Droit droit) throws TransactionalConnectionException;

	Droit updateDroit(Droit droit) throws TransactionalConnectionException;

	void deleteDroit(Droit droit) throws TransactionalConnectionException;


}
