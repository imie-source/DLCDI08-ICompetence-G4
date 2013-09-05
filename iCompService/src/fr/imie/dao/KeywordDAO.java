package fr.imie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.dao.interfaces.IKeywordDAO;
import fr.imie.dao.interfaces.INiveauxDAO;
import fr.imie.dto.Competence;
import fr.imie.dto.Keyword;
import fr.imie.dto.Niveau;
import fr.imie.dto.Utilisateur;
import fr.imie.exceptionManager.ExceptionManager;
import fr.imie.factory.Factory;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * Keyword DAO
 * 
 * @author imie
 * @version 1.0
 */
public class KeywordDAO extends ATransactional implements IKeywordDAO {
	public static final String key_id ="key_id";
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
				Keyword keywordDTO= buildDTO(rs);
				
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
	
	
	
	private Keyword buildDTO(ResultSet rs) throws SQLException, TransactionalConnectionException {
		/*	ICompetenceDAO competenceDAO = Factory.getInstance().createCompetenceDAO(this);
			ICursusDAO cursusDAO = Factory.getInstance().createCursusDAO(this);
			// création d'un nouveau UserDTO
					Domaine domaine = new Domaine();
					// affectation des attribut du UserDTO à partir des valeurs du
					// resultset sur l'enregistrement courant
					domaine.setNom(rs.getString(nom));
					domaine.setId(rs.getInt(id));
					domaine.setId(rs.getInt(id1));

					// récupération des compétences du user grâce au competenceDAO
					// la connection passée en paramètre permet de partager la
					// connection entre cette methode et celle appelée

					List<Competence> competenceDTOs = competenceDAO.getCompetenceByUser(domaine);
					// parcours des compétences du user
					for (Competence competenceDTO : competenceDTOs) {
						// ajout des compétences sur le UserDTO à partir de celles
						// fournies par le CompetenceDAO
						domaine.addCompetence(competenceDTO);
					}

					
			return domaine;*/
			return null;

		}

	
	@Override
	public Keyword insertKeyword(Keyword keyword) throws TransactionalConnectionException {
		return null;
	}

	@Override
	public Keyword updateKeyword(Keyword keyword) throws TransactionalConnectionException {
		return null;
	}

	@Override
	public void deleteKeyword(Keyword keyword) throws TransactionalConnectionException {


	}
	
	
	public List<Keyword> getKeywordBycompetence(Competence competence) throws TransactionalConnectionException {
		
		List<Keyword> keyList = new ArrayList<Keyword>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM keyword K INNER JOIN com_key Ck ON K.key_id = CK.key_id " +
					"INNER JOIN competence C ON C.com_id = CK.com_id " +
					"WHERE C.com_id = ? ORDER BY K.key_id";
				
				
				
				
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

}

