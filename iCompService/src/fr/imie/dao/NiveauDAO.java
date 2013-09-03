package fr.imie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import fr.imie.dao.interfaces.INiveauxDAO;
import fr.imie.dto.Competence;
import fr.imie.dto.Niveau;
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
public class NiveauDAO extends ATransactional implements INiveauxDAO {
	// SQL Fields
	private static final String NIV_ID = "NIV_ID";
	private static final String NIV_DESCRIPTION = "NIV_Description";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.DAO.IUserDAO#findByUser(org.imie.DTO.UserDTO)
	 */
	@Override
	public List<Niveau> getNiveauByUsrAndComp(Utilisateur user, Competence comp) throws TransactionalConnectionException {

		List<Niveau> nivList = new ArrayList<Niveau>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM NIVEAU N INNER JOIN COM_USER CU ON N.NIV_ID =  CU.NIV_ID INNER JOIN UTILISATEUR U ON U.USR_ID = CU.USR_ID INNER JOIN COMPETENCE C ON C.COM_ID = CU.COM_ID WHERE U.USR_ID = ? AND C.COM_ID = ? ORDER BY N.NIV_ID";

		try {
			pstmt = getConnection().prepareStatement(query);

			pstmt.setInt(1, user.getId());
			pstmt.setInt(2, comp.getId());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Niveau niv = new Niveau();
				niv.setId(rs.getInt(NIV_ID));
				niv.setDescription(rs.getString(NIV_DESCRIPTION));
				nivList.add(niv);

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

		return nivList;
	}

	@Override
	public Niveau getNiveau(Utilisateur user, Competence competence) throws TransactionalConnectionException {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT N.niv_id, N.niv_evaluation, N.niv_description FROM NIVEAU N" +
				" INNER JOIN COM_USER CU ON N.NIV_ID =  CU.NIV_ID" +
				" INNER JOIN COMPETENCE C ON C.COM_ID = CU.COM_ID" +
				" WHERE CU.USR_ID = ? AND C.COM_ID = ? ORDER BY N.NIV_ID";
//		String query = "SELECT * FROM niveau";
		Niveau niv = null;

		try {
			pstmt = getConnection().prepareStatement(query);

			pstmt.setInt(1, user.getId());
			pstmt.setInt(2, competence.getId());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				niv = new Niveau();
				niv.setId(rs.getInt(NIV_ID));
				niv.setDescription(rs.getString(NIV_DESCRIPTION));
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
		return niv;
	}
}
