package fr.imie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import fr.imie.dao.interfaces.ICursusDAO;
import fr.imie.dto.Cursus;
import fr.imie.dto.Utilisateur;
import fr.imie.exceptionManager.ExceptionManager;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * DAO de la table cursus
 * 
 * @author imie
 * 
 */
public class CursusDAO extends ATransactional implements ICursusDAO {
	// SQL Fields
	private static final String CUR_ID = "CUR_ID";
	private static final String CUR_LIBELLE = "CUR_Libelle";
	
	public Cursus findCursus(int id) throws TransactionalConnectionException {
		
		// initialisation de la liste qui servira au retour
		Cursus cursusDTO = new Cursus();
		// déclaration de la variable de resultset
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		String query = "SELECT * FROM CURSUS WHERE CUR_ID = ?";
		
		try {
			
			pstmt = getConnection().prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				cursusDTO.setLibelle(rs.getString(CUR_LIBELLE));
				cursusDTO.setId(rs.getInt(CUR_ID));
			}
			
		} catch (SQLException e) {
			ExceptionManager.getInstance().manageException(e);
		} finally {
			// libération des ressources

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				ExceptionManager.getInstance().manageException(e);
			}
		}
		return cursusDTO;
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.DAO.IUserDAO#findByUser(org.imie.DTO.UserDTO)
	 */
	@Override
	public Cursus findCursusByUser(Utilisateur userDTO) throws TransactionalConnectionException {

		// initialisation de la liste qui servira au retour
		Cursus cursusDTO = new Cursus();
		// déclaration de la variable de resultset
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM CURSUS C INNER JOIN UTILISATEUR U ON U.CUR_ID = C.CUR_ID WHERE U.USR_ID = ? ORDER BY C.CUR_ID";
		try {
			pstmt = getConnection().prepareStatement(query);
			pstmt.setInt(1, userDTO.getId());
			rs = pstmt.executeQuery();
			// parcours du resultset

			if (rs.next()) {
				cursusDTO.setLibelle(rs.getString(CUR_LIBELLE));
				cursusDTO.setId(rs.getInt(CUR_ID));
			}

		} catch (SQLException e) {
			ExceptionManager.getInstance().manageException(e);
		} finally {
			// libération des ressources

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				ExceptionManager.getInstance().manageException(e);
			}
		}
		return cursusDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.DAO.IUserDAO#findAll()
	 */
	@Override
	public List<Cursus> findAllCursus() throws TransactionalConnectionException {

		// initialisation de la liste qui servira au retour
		List<Cursus> cursusDTOs = new ArrayList<Cursus>();
		// déclaration de la variable de resultset
		ResultSet rs = null;
		String query = "SELECT * FROM CURSUS C ORDER BY C.CUR_ID";
		PreparedStatement pstmt = null;
		try {
			// création du statement à partir de la connection
			pstmt = getConnection().prepareStatement(query);
			rs = pstmt.executeQuery();
			// parcours du resultset
			while (rs.next()) {
				Cursus cursusDTO = new Cursus();
				cursusDTO.setLibelle(rs.getString(CUR_LIBELLE));
				cursusDTO.setId(rs.getInt(CUR_ID));
				cursusDTOs.add(cursusDTO);
			}

		} catch (SQLException e) {
			ExceptionManager.getInstance().manageException(e);
		} finally {

			// libération des ressources
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				ExceptionManager.getInstance().manageException(e);
			}
		}
		return cursusDTOs;
	}
}
