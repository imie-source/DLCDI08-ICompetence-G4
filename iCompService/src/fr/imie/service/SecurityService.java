package fr.imie.service;

import java.util.List;

import fr.imie.dao.interfaces.IDroitDAO;
import fr.imie.dao.interfaces.IFenetreDAO;
import fr.imie.dao.interfaces.IFonctionDAO;
import fr.imie.dao.interfaces.INatureDAO;
import fr.imie.dao.interfaces.IProfilDAO;
import fr.imie.dto.Droit;
import fr.imie.dto.Fenetre;
import fr.imie.dto.Fonction;
import fr.imie.dto.Nature;
import fr.imie.dto.Profil;
import fr.imie.dto.Utilisateur;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.ISecurityService;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

public class SecurityService extends ATransactional implements ISecurityService {

	@Override
	public List<Fenetre> getFenetres() throws TransactionalConnectionException {
		IFenetreDAO fenetereDAO = Factory.getInstance().createFenetreDAO(this);
		return fenetereDAO.getFenetres();
	}

	@Override
	public Fenetre insertFenetre(Fenetre fenetre) throws TransactionalConnectionException {
		IFenetreDAO fenetreDAO = Factory.getInstance().createFenetreDAO(this);
		return fenetreDAO.insertFenetre(fenetre);
	}

	@Override
	public Fenetre updateFenetre(Fenetre fenetre) throws TransactionalConnectionException {
		IFenetreDAO fenetreDAO = Factory.getInstance().createFenetreDAO(this);
		return fenetreDAO.updateFenetre(fenetre);
	}

	@Override
	public void deleteFenetre(Fenetre fenetre) throws TransactionalConnectionException {
		IFenetreDAO fenetreDAO = Factory.getInstance().createFenetreDAO(this);
		fenetreDAO.deleteFenetre(fenetre);
	}

	@Override
	public List<Fonction> getFonctions() throws TransactionalConnectionException {
		IFonctionDAO fonctionDAO = Factory.getInstance().createFonctionDAO(this);
		return fonctionDAO.getFonctions();
	}

	@Override
	public Fonction insertFonction(Fonction fonction) throws TransactionalConnectionException {
		IFonctionDAO fonctionDAO = Factory.getInstance().createFonctionDAO(this);
		return fonctionDAO.insertFonction(fonction);
	}

	@Override
	public Fonction updateFonction(Fonction fonction) throws TransactionalConnectionException {
		IFonctionDAO fonctionDAO = Factory.getInstance().createFonctionDAO(this);
		return fonctionDAO.updateFonction(fonction);
	}

	@Override
	public void deleteFonction(Fonction fonction) throws TransactionalConnectionException {
		IFonctionDAO fonctionDAO = Factory.getInstance().createFonctionDAO(this);
		fonctionDAO.deleteFonction(fonction);
	}

	@Override
	public List<Nature> getNatures() throws TransactionalConnectionException {
		INatureDAO natureDAO = Factory.getInstance().createNatureDAO(this);
		return natureDAO.getNatures();
	}

	@Override
	public Nature insertProfil(Nature nature) throws TransactionalConnectionException {
		INatureDAO natureDAO = Factory.getInstance().createNatureDAO(this);
		return natureDAO.insertProfil(nature);
	}

	@Override
	public Nature updateProfil(Nature nature) throws TransactionalConnectionException {
		INatureDAO natureDAO = Factory.getInstance().createNatureDAO(this);
		return natureDAO.updateProfil(nature);
	}

	@Override
	public void deleteNature(Nature nature) throws TransactionalConnectionException {
		INatureDAO natureDAO = Factory.getInstance().createNatureDAO(this);
		natureDAO.deleteNature(nature);
	}
	
	@Override
	public List<Profil> getProfils() throws TransactionalConnectionException {
		IProfilDAO profilDAO = Factory.getInstance().createProfilDAO(this);
		return profilDAO.getProfils();
	}

	@Override
	public Profil insertProfil(Profil profil) throws TransactionalConnectionException {
		IProfilDAO profilDAO = Factory.getInstance().createProfilDAO(this);
		return profilDAO.insertProfil(profil);
	}

	@Override
	public Profil updateProfil(Profil profil) throws TransactionalConnectionException {
		IProfilDAO profilDAO = Factory.getInstance().createProfilDAO(this);
		return profilDAO.updateProfil(profil);
	}

	@Override
	public void deleteProfil(Profil profil) throws TransactionalConnectionException {
		IProfilDAO profilDAO = Factory.getInstance().createProfilDAO(this);
		profilDAO.deleteProfil(profil);
	}	
	
	@Override
	public List<Droit> getDroits() throws TransactionalConnectionException {
		IDroitDAO droitDAO = Factory.getInstance().createDroitDAO(this);
		return droitDAO.getDroits();
	}

	@Override
	public Profil insertDroit(Droit droit) throws TransactionalConnectionException {
		IDroitDAO droitDAO = Factory.getInstance().createDroitDAO(this);
		return droitDAO.insertDroit(droit);
	}

	@Override
	public Droit updateDroit(Droit droit) throws TransactionalConnectionException {
		IDroitDAO droitDAO = Factory.getInstance().createDroitDAO(this);
		return droitDAO.updateDroit(droit);
	}

	@Override
	public void deleteDroit(Droit droit) throws TransactionalConnectionException {
		IDroitDAO droitDAO = Factory.getInstance().createDroitDAO(this);
		droitDAO.deleteDroit(droit);
	}	
	
	@Override
	public List<Profil> getProfilsByUser(Utilisateur user)
			throws TransactionalConnectionException {
		IProfilDAO profilDAO = Factory.getInstance().createProfilDAO(this);
		return profilDAO.getProfilsByUser(user);
	}
}
