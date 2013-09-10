package fr.imie.service;

import java.util.List;

import fr.imie.dao.interfaces.IGroupeDAO;
import fr.imie.dao.interfaces.IStatutDAO;
import fr.imie.dto.Groupe;
import fr.imie.dto.Statut;
import fr.imie.dto.Utilisateur;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IProjectService;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

public class ProjectService extends ATransactional implements IProjectService {

	@Override
	public List<Groupe> getGroupes() throws TransactionalConnectionException {
		IGroupeDAO groupeDAO = Factory.getInstance().createGroupeDAO(this);
		return groupeDAO.getGroupes();
	}

	@Override
	public Groupe updateGroupe(Groupe groupeToUpdate) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteGroupe(Groupe groupeToDelete) throws TransactionalConnectionException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Groupe> getGroupesByUser(Utilisateur user) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Groupe insertGroupe(Groupe groupeToInsert) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Statut> getStatuts() throws TransactionalConnectionException {
		IStatutDAO statutDAO = Factory.getInstance().createStatutDAO(this);
		return statutDAO.getStatuts();
	}

	@Override
	public Statut updateStatut(Statut statutToUpdate) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStatut(Statut statutToDelete) throws TransactionalConnectionException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Statut> getStatutsByGRP(Groupe groupe) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statut insertStatut(Statut statutToInsert) throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

}
