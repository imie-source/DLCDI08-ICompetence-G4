package fr.imie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.dao.interfaces.IProfilDAO;
import fr.imie.dto.Profil;
import fr.imie.dto.Utilisateur;
import fr.imie.exceptionManager.ExceptionManager;
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
		List<Profil> profils = new ArrayList<Profil>();

		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM PROFIL ORDER BY PRO_NOM";

		try {
			stmt = getConnection().createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Profil profil = buildDTO(rs);
				profils.add(profil);
			}
		} catch (SQLException e) {
			ExceptionManager.getInstance().manageException(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				ExceptionManager.getInstance().manageException(e);
			}
		}
		return profils;
	}

	@Override
	public List<Profil> getProfilsByUser(Utilisateur user) throws TransactionalConnectionException {
		List<Profil> profils = new ArrayList<Profil>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM PROFIL P inner join pro_user PU on P.pro_id=P.pro_id inner join utilisateur u on u.usr_id=PU.usr_id where U.usr_id = ? order by P.pro_nom";

		try {
			pstmt = getConnection().prepareStatement(query);
			pstmt.setInt(1, user.getId());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Profil profil = new Profil();
				profil.setId(rs.getInt("PRO_ID"));
				profil.setNom(rs.getString("PRO_NOM"));
				profils.add(profil);
			}
		} catch (SQLException e) {
			ExceptionManager.getInstance().manageException(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				ExceptionManager.getInstance().manageException(e);
			}
		}
		return profils;
	}

	private Profil buildDTO(ResultSet rs) throws SQLException, TransactionalConnectionException {
		//TODO : à implémenter
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
