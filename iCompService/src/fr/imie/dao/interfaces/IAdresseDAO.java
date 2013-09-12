package fr.imie.dao.interfaces;

import fr.imie.dto.Adresse;
import fr.imie.dto.Utilisateur;
import fr.imie.transactionalFramework.TransactionalConnectionException;

public interface IAdresseDAO {
	public abstract Adresse getAdresseByUser(Utilisateur userDTO) throws
	TransactionalConnectionException;
}
