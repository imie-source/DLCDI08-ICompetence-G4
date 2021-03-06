package fr.imie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.dao.interfaces.IKeywordDAO;
import fr.imie.dto.Competence;
import fr.imie.dto.Keyword;
import fr.imie.exceptionManager.ExceptionManager;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * Keyword DAO
 * 
 * @author imie
 * @version 1.0
 */

public class KeywordDAO extends ATransactional implements IKeywordDAO {
	public static final String key_id = "key_id";
	public static final String key_libelle = "key_libelle";

	@Override
	public List<Keyword> getKeyword() throws TransactionalConnectionException {

		List<Keyword> keywordDTOs = new ArrayList<Keyword>();

		Statement stmt = null;

		ResultSet rs = null;
		String query = "SELECT * FROM Keyword ORDER BY key_id";

		try {

			stmt = getConnection().createStatement();

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Keyword keywordDTO = buildDTO(rs);

				keywordDTOs.add(keywordDTO);
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
		return keywordDTOs;

	}

	private Keyword buildDTO(ResultSet rs) throws SQLException,
			TransactionalConnectionException {

		// création d'un nouveau UserDTO
		Keyword keyword = new Keyword();
		// affectation des attribut du UserDTO à partir des valeurs du
		// resultset sur l'enregistrement courant
		keyword.setLibelle(rs.getString(key_libelle));
		keyword.setId(rs.getInt(key_id));

		// récupération des compétences du user grâce au competenceDAO
		// la connection passée en paramètre permet de partager la
		// connection entre cette methode et celle appelée

		return keyword;

	}

	@Override
	public Keyword insertKeyword(Keyword keyword)
			throws TransactionalConnectionException {

		PreparedStatement pstmt = null;
		// déclaration de la variable de resultset
		ResultSet rs = null;
		Keyword keywordDTOinserted = null;

		String query = "INSERT INTO Keyword (key_id, key_libelle) VALUES (?, ?)";

		try {

			// execution d'une requête SQL et récupération du result dans le
			// resultset
			pstmt = getConnection().prepareStatement(query);

			pstmt.setInt(1, keyword.getId());
			pstmt.setString(2, keyword.getLibelle());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				keywordDTOinserted = buildDTO(rs);
			}

		} catch (SQLException e) {
			ExceptionManager.getInstance().manageException(e);
		} finally {

			// libération des ressources
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
		return keywordDTOinserted;

	}

	@Override
	public Keyword updateKeyword(Keyword keywordTOupdate)
			throws TransactionalConnectionException {
		Keyword KeywordDTORetour = null;
		PreparedStatement pstmt = null;
		// déclaration de la variable de resultset
		ResultSet rs = null;
		try {
			// execution d'une requête SQL et récupération du result
			String query = "update Keyword set  key_libelle=? where key_id=?";
			pstmt = getConnection().prepareStatement(query);
			pstmt.setString(1, keywordTOupdate.getLibelle());

			pstmt.setInt(10, keywordTOupdate.getId());
			System.out.println(pstmt.toString());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			ExceptionManager.getInstance().manageException(e);
		} finally {

			// libération des ressources
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
		return KeywordDTORetour;

	}

	@Override
	public void deleteKeyword(Keyword keyword)
			throws TransactionalConnectionException {

	}
	
	@Override
	public List<Keyword> getKeywordBycompetence(Competence competence)
			throws TransactionalConnectionException {

		List<Keyword> keyList = new ArrayList<Keyword>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM keyword K INNER JOIN com_key Ck ON K.key_id = CK.key_id "
				+ "INNER JOIN competence C ON C.com_id = CK.com_id "
				+ "WHERE C.com_id = ? ORDER BY K.key_id";

		try {
			pstmt = getConnection().prepareStatement(query);

			pstmt.setInt(1, competence.getId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Keyword keyword = new Keyword();

				keyword.setId(rs.getInt(key_id));
				keyword.setLibelle(rs.getString(key_libelle));

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
		return keyList;
	}



	
	@Override
	public Keyword findCompetenceByKeyword(Keyword keyword2) throws TransactionalConnectionException {
		String query = "SELECT key_libelle FROM Keyword  WHERE key_libelle = ?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			pstmt = getConnection().prepareStatement(query);

			pstmt.setString(1, keyword2.getLibelle());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Keyword keyword = new Keyword();
				
				keyword.setLibelle(rs.getString(key_libelle));
				

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

		return keyword2;
	}




}
