package fr.imie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.imie.dao.interfaces.IAdresseDAO;
import fr.imie.dto.Adresse;
import fr.imie.dto.Utilisateur;
import fr.imie.exceptionManager.ExceptionManager;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * Adresse DAO
 * 
 * @author imie
 * @version 1.0
 */
public class AdresseDAO extends ATransactional implements IAdresseDAO {

	@Override
	public Adresse getAdresseByUser(Utilisateur userDTO)
			throws TransactionalConnectionException {
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			Adresse address = new Adresse();
			String query = "SELECT * FROM ADRESSE A INNER JOIN UTILISATEUR U ON U.ADR_Id = A.ADR_Id WHERE U.USR_Id = ? ORDER BY A.ADR_Id";
	
			try {
				pstmt = getConnection().prepareStatement(query);
				pstmt.setInt(1, userDTO.getId());
	
				rs = pstmt.executeQuery();
				
				while (rs.next()) {

					address.setId(rs.getInt("ADR_ID"));
					address.setRue(rs.getString("ADR_RUE"));
					address.setComplement("ADR_COMPLEMENT");
					address.setCodePostal("ADR_CP");
					address.setVille("ADR_VILLE");
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

			return address;

	}
	

}
