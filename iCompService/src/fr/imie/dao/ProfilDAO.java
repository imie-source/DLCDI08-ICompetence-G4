package fr.imie.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.imie.dao.interfaces.IProfilDAO;
import fr.imie.dto.Profil;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * DAO de gestion de la table Profil
 * 
 * @author imie
 * 
 */
public class ProfilDAO extends ATransactional implements IProfilDAO {

	@Override
	public List<Profil> getProfils() throws TransactionalConnectionException {
		return null;
	}

	private Profil buildDTO(ResultSet rs) throws SQLException, TransactionalConnectionException {
		return null;
	}

	@Override
	public Profil insertProfil(Profil profil) throws TransactionalConnectionException {
		return null;
	}

	@Override
	public Profil updateProfil(Profil profil) throws TransactionalConnectionException {
		return null;
	}

	@Override
	public void deleteProfil(Profil profil) throws TransactionalConnectionException {

	}




}
