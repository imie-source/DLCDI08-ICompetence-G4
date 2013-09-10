package fr.imie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.dao.interfaces.IDomaineDAO;
import fr.imie.dto.Domaine;
import fr.imie.exceptionManager.ExceptionManager;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * Cursus DAO
 * 
 * @author imie
 * @version 1.0
 */

public class DomaineDAO extends ATransactional implements IDomaineDAO {

	@Override
	public List<Domaine> getDomaines() throws TransactionalConnectionException {
		List<Domaine> domaineDTOs = new ArrayList<Domaine>();
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM domaine ORDER BY dom_ID";

		try {
			stmt = getConnection().createStatement();
			rs = stmt.executeQuery(query);
			// parcours du resultset
			while (rs.next()) {
				Domaine domaineDTO = buildDTO(rs);
				// ajout du DTO dans la liste de retour
				domaineDTOs.add(domaineDTO);
			}

		} catch (SQLException e) {
			ExceptionManager.getInstance().manageException(e);
		} finally {

			// libération des ressources

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
		return domaineDTOs;
	}

	private Domaine buildDTO(ResultSet rs) throws SQLException, TransactionalConnectionException {
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
	public Domaine insertDomaine(Domaine domaine) throws TransactionalConnectionException {
	

	
		// déclaration de la variable de statement
		
		PreparedStatement pstmt = null;
		
		// déclaration de la variable de resultset
		ResultSet rs = null;
		Domaine domaineDTOinserted = null;

		String query = "INSERT INTO Domaine (Dom_nom, Dom_id1) VALUES (? , ?)";

		try {

			// execution d'une requête SQL et récupération du result dans le
			// resultset
			pstmt = getConnection().prepareStatement(query);

			pstmt.setString(1, domaine.getNom());
			pstmt.setInt(2, domaine.getId());

			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				domaineDTOinserted = buildDTO(rs);
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
		return domaineDTOinserted;
	}
	

@Override
	public Domaine updateDomaine(Domaine domaine) throws TransactionalConnectionException {
		
	Domaine domaineRetour = null;
	PreparedStatement pstmt = null;
	// déclaration de la variable de resultset
	ResultSet rs = null;
	try {
		// execution d'une requête SQL et récupération du result
		String query = "update domaine set dom_nom=?, dom_ID1=? where dom_ID=?";
		pstmt = getConnection().prepareStatement(query);
		
		pstmt.setString(1, domaine.getNom());
		pstmt.setInt(2, domaine.getId());
		
		
		//pstmt.setDomaine(3, domaineRetour.getDomaine());
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
	return domaineRetour;
	
	

	}

@Override
	public void deleteDomaine(Domaine domaine) throws TransactionalConnectionException {


	}

}
