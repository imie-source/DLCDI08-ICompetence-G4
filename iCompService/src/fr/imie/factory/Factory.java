package fr.imie.factory;


import fr.imie.dao.CompetenceDAO;
import fr.imie.dao.CursusDAO;
import fr.imie.dao.DomaineDAO;
import fr.imie.dao.DroitDAO;
import fr.imie.dao.FenetreDAO;
import fr.imie.dao.FonctionDAO;
import fr.imie.dao.GroupeDAO;
import fr.imie.dao.KeywordDAO;
import fr.imie.dao.NatureDAO;
import fr.imie.dao.NiveauDAO;
import fr.imie.dao.ProfilDAO;
import fr.imie.dao.StatutDAO;
import fr.imie.dao.UtilisateurDAO;
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
import fr.imie.service.ProjectService;
import fr.imie.service.SecurityService;
import fr.imie.service.UserService;
import fr.imie.service.interfaces.IProjectService;
import fr.imie.service.interfaces.ISecurityService;
import fr.imie.service.interfaces.IUserService;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.transactionalFramework.TransactionalFactory;

/**
 * factory de base de l'application
 * 
 * @author imie
 * 
 */
public class Factory implements IFactory {

	/**
	 * attribut stockant l'instance du singleton
	 */
	private static Factory instance;

	/**
	 * modification de la portée du constructeur pour ne pas pouvoir faire new
	 * BaseFActory hors de la classe
	 */
	private Factory() {
		super();
	};

	/**
	 * methode qui retourne toujours la même instance de BaseConcreteFactory
	 * @return le singleton instancié
	 */
	public static synchronized Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}

	@Override
	public IUserService createUserService(ITransactional caller) {
		TransactionalFactory<UserService> fact = (TransactionalFactory<UserService>) TransactionalFactory.getInstance();
		return fact.createTransactionalService(new UserService(), caller);
	}

	@Override
	public ISecurityService createSecurityService(ITransactional caller) {
		TransactionalFactory<SecurityService> fact = (TransactionalFactory<SecurityService>) TransactionalFactory.getInstance();
		return fact.createTransactionalService(new SecurityService(), caller);
	}

	@Override
	public IProjectService createProjectService(ITransactional caller) {
		TransactionalFactory<ProjectService> fact = (TransactionalFactory<ProjectService>) TransactionalFactory.getInstance();
		return fact.createTransactionalService(new ProjectService(), caller);
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.factory.IFactory#createUserDAO()
	 */
	@Override
	public IUtilisateurDAO createUserDAO(ITransactional caller) {
		TransactionalFactory<UtilisateurDAO> fact = (TransactionalFactory<UtilisateurDAO>) TransactionalFactory.getInstance();
		return fact.createTransactionalService(new UtilisateurDAO(), caller);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.factory.IFactory#createCursusDAO()
	 */
	@Override
	public ICursusDAO createCursusDAO(ITransactional caller) {
		TransactionalFactory<CursusDAO> fact = (TransactionalFactory<CursusDAO>) TransactionalFactory.getInstance();
		return fact.createTransactionalService(new CursusDAO(), caller);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.factory.IFactory#createCompetenceDAO()
	 */
	@Override
	public ICompetenceDAO createCompetenceDAO(ITransactional caller) {
		TransactionalFactory<CompetenceDAO> fact = (TransactionalFactory<CompetenceDAO>) TransactionalFactory
				.getInstance();
		return fact.createTransactionalService(new CompetenceDAO(), caller);
	}

	@Override
	public INiveauxDAO createNiveauDAO(ITransactional caller) {
		TransactionalFactory<NiveauDAO> fact = (TransactionalFactory<NiveauDAO>) TransactionalFactory.getInstance();
		return fact.createTransactionalService(new NiveauDAO(), caller);
	}
	
	@Override
	public IProfilDAO createProfilDAO(ITransactional caller) {
		TransactionalFactory<ProfilDAO> fact = (TransactionalFactory<ProfilDAO>) TransactionalFactory.getInstance();
		return fact.createTransactionalService(new ProfilDAO(), caller);
	}
	
	@Override
	public IGroupeDAO createGroupeDAO(ITransactional caller) {
		TransactionalFactory<GroupeDAO> fact = (TransactionalFactory<GroupeDAO>) TransactionalFactory.getInstance();
		return fact.createTransactionalService(new GroupeDAO(), caller);
	}

	@Override
	public IFenetreDAO createFenetreDAO(ITransactional caller) {
		TransactionalFactory<FenetreDAO> fact = (TransactionalFactory<FenetreDAO>) TransactionalFactory.getInstance();
		return fact.createTransactionalService(new FenetreDAO(), caller);
	}

	@Override
	public IFonctionDAO createFonctionDAO(ITransactional caller) {
		TransactionalFactory<FonctionDAO> fact = (TransactionalFactory<FonctionDAO>) TransactionalFactory.getInstance();
		return fact.createTransactionalService(new FonctionDAO(), caller);
	}

	@Override
	public INatureDAO createNatureDAO(ITransactional caller) {
		TransactionalFactory<NatureDAO> fact = (TransactionalFactory<NatureDAO>) TransactionalFactory.getInstance();
		return fact.createTransactionalService(new NatureDAO(), caller);
	}

	@Override
	public IDroitDAO createDroitDAO(ITransactional caller) {
		TransactionalFactory<DroitDAO> fact = (TransactionalFactory<DroitDAO>) TransactionalFactory.getInstance();
		return fact.createTransactionalService(new DroitDAO(), caller);
	}

	@Override
	public IDomaineDAO createDomaineDAO(ITransactional caller) {
		TransactionalFactory<DomaineDAO> fact = (TransactionalFactory<DomaineDAO>) TransactionalFactory.getInstance();
		return fact.createTransactionalService(new DomaineDAO(), caller);
	}
	
	@Override
	public IKeywordDAO createKeywordDAO(ITransactional caller) {
		TransactionalFactory<KeywordDAO> fact = (TransactionalFactory<KeywordDAO>) TransactionalFactory.getInstance();
		return fact.createTransactionalService(new KeywordDAO(), caller);
	}

	@Override
	public IStatutDAO createStatutDAO(ITransactional caller) {
		TransactionalFactory<StatutDAO> fact = (TransactionalFactory<StatutDAO>) TransactionalFactory.getInstance();
		return fact.createTransactionalService(new StatutDAO(), caller);
	}

}
