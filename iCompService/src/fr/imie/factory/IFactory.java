package fr.imie.factory;


import fr.imie.dao.interfaces.ICompetenceDAO;
import fr.imie.dao.interfaces.ICursusDAO;
import fr.imie.dao.interfaces.IDomaineDAO;
import fr.imie.dao.interfaces.IDroitDAO;
import fr.imie.dao.interfaces.IFenetreDAO;
import fr.imie.dao.interfaces.IFonctionDAO;
import fr.imie.dao.interfaces.IGroupeDAO;
import fr.imie.dao.interfaces.IKeywordDAO;
import fr.imie.dao.interfaces.INatureDAO;
import fr.imie.dao.interfaces.INiveauxDAO;
import fr.imie.dao.interfaces.IProfilDAO;
import fr.imie.dao.interfaces.IStatutDAO;
import fr.imie.dao.interfaces.IUtilisateurDAO;
import fr.imie.service.interfaces.IProjectService;
import fr.imie.service.interfaces.ISecurityService;
import fr.imie.service.interfaces.IUserService;
import fr.imie.transactionalFramework.ITransactional;

/**
 * Interface de la factory de l'application
 * @author imie
 *
 */
public interface IFactory {
	/**
	 * créer un service transactionel (un proxy de service) gérant les Users
	 * 
	 * @param caller
	 *            objet transactionel appelant ce service. null si début de
	 *            transaction
	 * @return
	 */
	public abstract IUserService createUserService(ITransactional caller);

	/**
	 * créer un dao transactionel dédié à la table utilisateur (un proxy de dao)
	 * 
	 * @param caller
	 *            objet transactionel appelant ce service. null si début de
	 *            transaction
	 * @return
	 */
	public abstract IUtilisateurDAO createUserDAO(ITransactional caller);

	/**
	 * créer un dao transactionel dédié à la table cursus (un proxy de dao)
	 * 
	 * @param caller
	 *            objet transactionel appelant ce service. null si début de
	 *            transaction
	 * @return
	 */
	public abstract ICursusDAO createCursusDAO(ITransactional caller);

	/**
	 * créer un dao transactionel dédié à la table competence (un proxy de dao)
	 * 
	 * @param caller
	 *            objet transactionel appelant ce service. null si début de
	 *            transaction
	 * @return
	 */
	public abstract ICompetenceDAO createCompetenceDAO(ITransactional caller);

	public abstract INiveauxDAO createNiveauDAO(ITransactional caller);

	public abstract IProfilDAO createProfilDAO(ITransactional caller);

	public abstract IGroupeDAO createGroupeDAO(ITransactional caller);

	public abstract IFenetreDAO createFenetreDAO(ITransactional caller);

	public abstract IFonctionDAO createFonctionDAO(ITransactional caller);

	public abstract INatureDAO createNatureDAO(ITransactional caller);

	public abstract IDroitDAO createDroitDAO(ITransactional caller);

	public abstract ISecurityService createSecurityService(ITransactional caller);

	public abstract IProjectService createProjectService(ITransactional caller);

	public abstract IDomaineDAO createDomaineDAO(ITransactional caller);

	public abstract IKeywordDAO createKeywordDAO(ITransactional caller);

	public abstract IStatutDAO createStatutDAO(ITransactional caller);
	
}