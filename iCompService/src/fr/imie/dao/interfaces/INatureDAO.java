package fr.imie.dao.interfaces;

import java.util.List;

import fr.imie.dto.Nature;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * interface de DAO de gestion des nature (Création, modification, suppression)
 * 
 * @author imie
 * 
 */
public interface INatureDAO extends ITransactional {

	public abstract List<Nature> getNatures() throws TransactionalConnectionException;

	public abstract Nature insertProfil(Nature nature) throws TransactionalConnectionException;

	public abstract Nature updateProfil(Nature nature) throws TransactionalConnectionException;

	public abstract void deleteNature(Nature nature) throws TransactionalConnectionException;

}
