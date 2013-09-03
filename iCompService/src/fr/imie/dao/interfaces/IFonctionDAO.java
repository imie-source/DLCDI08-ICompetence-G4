package fr.imie.dao.interfaces;

import java.util.List;

import fr.imie.dto.Fonction;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * interface de DAO de gestion des fonctions (sécurité)
 * 
 * @author imie
 * 
 */
public interface IFonctionDAO extends ITransactional {

	public abstract List<Fonction> getFonctions() throws TransactionalConnectionException;

	public abstract Fonction insertFonction(Fonction fonction) throws TransactionalConnectionException;

	public abstract Fonction updateFonction(Fonction fonction) throws TransactionalConnectionException;

	public abstract void deleteFonction(Fonction fonction) throws TransactionalConnectionException;

}
