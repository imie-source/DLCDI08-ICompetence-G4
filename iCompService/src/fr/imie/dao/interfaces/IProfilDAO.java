package fr.imie.dao.interfaces;

import java.util.List;

import fr.imie.dto.Profil;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * interface de DAO de gestion des profils utilisateur
 * 
 * @author imie
 * 
 */
public interface IProfilDAO extends ITransactional {


	public abstract List<Profil> getProfils() throws TransactionalConnectionException;

	public abstract Profil insertProfil(Profil profil) throws TransactionalConnectionException;

	public abstract Profil updateProfil(Profil profil) throws TransactionalConnectionException;

	public abstract void deleteProfil(Profil profil) throws TransactionalConnectionException;

}
