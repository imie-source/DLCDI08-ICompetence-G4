package fr.imie.dao.interfaces;

import java.util.List;

import fr.imie.dto.Fenetre;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * interface de DAO de gestion des fenetres (sécurité)
 * 
 * @author imie
 * 
 */
public interface IFenetreDAO extends ITransactional {


	public abstract List<Fenetre> getFenetres() throws TransactionalConnectionException;

	public abstract Fenetre insertFenetre(Fenetre fenetre) throws TransactionalConnectionException;

	public abstract Fenetre updateFenetre(Fenetre fenetre) throws TransactionalConnectionException;

	public abstract void deleteFenetre(Fenetre fenetre) throws TransactionalConnectionException;

}
