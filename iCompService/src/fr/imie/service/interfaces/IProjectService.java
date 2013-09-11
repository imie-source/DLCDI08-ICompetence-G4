package fr.imie.service.interfaces;

import java.util.List;

import fr.imie.dto.Groupe;
import fr.imie.dto.Statut;
import fr.imie.dto.Utilisateur;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

public interface IProjectService extends ITransactional {

	public abstract List<Groupe> getGroupes() throws TransactionalConnectionException;
	
	public Groupe findGroupById(String grpid) throws TransactionalConnectionException;
	
	public abstract Groupe insertGroupe(Groupe groupeToInsert) throws TransactionalConnectionException;

	public abstract Groupe updateGroupe(Groupe groupeToUpdate) throws TransactionalConnectionException;
	
	public abstract void deleteGroupe(Groupe groupeToDelete) throws TransactionalConnectionException;
	
	public abstract List<Groupe> getGroupesByUser(Utilisateur user) throws TransactionalConnectionException;
	
    public abstract List<Statut> findallStatuts() throws TransactionalConnectionException;
	
	public abstract Statut insertStatut(Statut statutToInsert) throws TransactionalConnectionException;

	public abstract Statut updateStatut(Statut statutToUpdate) throws TransactionalConnectionException;
	
	public abstract void deleteStatut(Statut statutToDelete) throws TransactionalConnectionException;
	
	public abstract List<Statut> getStatutsByGRP(Groupe groupe) throws TransactionalConnectionException;
}