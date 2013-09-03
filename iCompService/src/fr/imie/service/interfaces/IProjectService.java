package fr.imie.service.interfaces;

import java.util.List;


import fr.imie.dto.Groupe;
import fr.imie.dto.Utilisateur;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

public interface IProjectService extends ITransactional {

	public abstract List<Groupe> getGroupes() throws TransactionalConnectionException;
	
	public abstract Groupe insertGroupe(Groupe groupeToInsert) throws TransactionalConnectionException;

	public abstract Groupe updateGroupe(Groupe groupeToUpdate) throws TransactionalConnectionException;
	
	public abstract void deleteGroupe(Groupe groupeToDelete) throws TransactionalConnectionException;
	
	public abstract List<Groupe> getGroupesByUser(Utilisateur user) throws TransactionalConnectionException;
}