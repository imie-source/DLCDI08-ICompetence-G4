package fr.imie.service;

import java.util.List;

import fr.imie.dao.interfaces.IAdresseDAO;
import fr.imie.dao.interfaces.ICompetenceDAO;
import fr.imie.dao.interfaces.ICursusDAO;
import fr.imie.dao.interfaces.IKeywordDAO;
import fr.imie.dao.interfaces.IUtilisateurDAO;
import fr.imie.dto.Adresse;
import fr.imie.dto.Competence;
import fr.imie.dto.Cursus;
import fr.imie.dto.Keyword;
import fr.imie.dto.Utilisateur;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IUserService;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

public class UserService extends ATransactional implements IUserService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.service.IUserService#getUsers()
	 */
	@Override
	public List<Utilisateur> getUsers() throws TransactionalConnectionException {
		IUtilisateurDAO userDAO = Factory.getInstance().createUserDAO(this);
		return userDAO.getUsers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.service.IUserService#getUsers()
	 */
	@Override
	public List<Utilisateur> getUsersbyGrpId(int id) throws TransactionalConnectionException {
	    IUtilisateurDAO userDAO = Factory.getInstance().createUserDAO(this);
	    return userDAO.getUsersbyGrpId(id);
    }
	
	@Override
	public Utilisateur getChefProjetbyGrpid(int id) throws TransactionalConnectionException {
	    IUtilisateurDAO userDAO = Factory.getInstance().createUserDAO(this);
	    return userDAO.getChefProjetbyGrpid(id);
    }
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.service.IUserService#insertUser(org.imie.DTO.UserDTO)
	 */
	@Override
	public Utilisateur insertUser(Utilisateur userToInsert)
			throws TransactionalConnectionException {
		IUtilisateurDAO userDAO = Factory.getInstance().createUserDAO(this);
		return userDAO.insertUser(userToInsert);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.service.IUserService#updateUser(org.imie.DTO.UserDTO)
	 */
	@Override
	public Utilisateur updateUser(Utilisateur userToUpdate)
			throws TransactionalConnectionException {
		IUtilisateurDAO userDAO = Factory.getInstance().createUserDAO(this);
		return userDAO.updateUser(userToUpdate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.service.IUserService#deleteUser(org.imie.DTO.UserDTO)
	 */
	@Override
	public void deleteUser(Utilisateur userToDelete)
			throws TransactionalConnectionException {
		IUtilisateurDAO userDAO = Factory.getInstance().createUserDAO(this);
		userDAO.deleteUser(userToDelete);
	}

	@Override
	public List<Utilisateur> getUsersByCompetence(Competence comp)
			throws TransactionalConnectionException {
		IUtilisateurDAO userDAO = Factory.getInstance().createUserDAO(this);
		return userDAO.getUsersByCompetence(comp);
	}

	@Override
	public Utilisateur findUserByLogin(String login)
			throws TransactionalConnectionException {
		IUtilisateurDAO userDAO = Factory.getInstance().createUserDAO(this);
		return userDAO.findUserByLogin(login);
	}

	@Override
	public Utilisateur findUser(Utilisateur user)
			throws TransactionalConnectionException {
		IUtilisateurDAO userDAO = Factory.getInstance().createUserDAO(this);
		return userDAO.findUser(user);
	}

	// CURSUS

	public Cursus findCursus(int id) throws TransactionalConnectionException {
		ICursusDAO cursusDAO = Factory.getInstance().createCursusDAO(this);
		return cursusDAO.findCursus(id);
	}

	@Override
	public List<Cursus> findAllCursus() throws TransactionalConnectionException {
		ICursusDAO cursusDAO = Factory.getInstance().createCursusDAO(this);
		return cursusDAO.findAllCursus();
	}

	@Override
	public Cursus findCursusByUser(Utilisateur user)
			throws TransactionalConnectionException {
		ICursusDAO cursusDAO = Factory.getInstance().createCursusDAO(this);
		return cursusDAO.findCursusByUser(user);
	}

	// COMPETENCE

	@Override
	public List<Competence> getCompetenceByUser(Utilisateur user)
			throws TransactionalConnectionException {
		ICompetenceDAO competenceDAO = Factory.getInstance()
				.createCompetenceDAO(this);
		return competenceDAO.getCompetenceByUser(user);
	}

	@Override
	public List<Competence> getCompetences()
			throws TransactionalConnectionException {
		ICompetenceDAO competenceDAO = Factory.getInstance()
				.createCompetenceDAO(this);
		return competenceDAO.getCompetences();

	}

	public List<Competence> getCompetenceByKeyword(Keyword keyword)
			throws TransactionalConnectionException {
		ICompetenceDAO competenceDAO = Factory.getInstance()
				.createCompetenceDAO(this);
		return competenceDAO.findCompetenceByKeyword(keyword);

	}

	// KEYWORD

	@Override
	public List<Keyword> getKeyword() throws TransactionalConnectionException {
		IKeywordDAO KeywordDAO = Factory.getInstance().createKeywordDAO(this);
		return KeywordDAO.getKeyword();

	}

	@Override
	public Keyword insertKeyword(Keyword keyword)
			throws TransactionalConnectionException {
		IKeywordDAO KeywordDAO = Factory.getInstance().createKeywordDAO(this);
		return KeywordDAO.insertKeyword(keyword);

	}

	@Override
	public Keyword updateKeyword(Keyword keyword)
			throws TransactionalConnectionException {
		IKeywordDAO KeywordDAO = Factory.getInstance().createKeywordDAO(this);
		return KeywordDAO.updateKeyword(keyword);

	}

	@Override
	public void deleteKeyword(Keyword keyword)
			throws TransactionalConnectionException {
		IKeywordDAO KeywordDAO = Factory.getInstance().createKeywordDAO(this);
		KeywordDAO.deleteKeyword(keyword);
	}

	@Override
	public List<Competence> findCompetenceByKeyword(Keyword keyword) throws TransactionalConnectionException{
		ICompetenceDAO competenceDAO = Factory.getInstance().createCompetenceDAO(this);
		return competenceDAO.findCompetenceByKeyword(keyword);
	}
	
	@Override
	public Utilisateur IsAuthorized(Utilisateur user)
			throws TransactionalConnectionException {
		IUtilisateurDAO userDAO = Factory.getInstance().createUserDAO(this);
		return userDAO.IsAuthorized(user);
	}

	@Override
	public Adresse getAdresseByUser(Utilisateur user) throws
	TransactionalConnectionException {
		IAdresseDAO adresseDAO = Factory.getInstance().createAdresseDAO(this);
		return adresseDAO.getAdresseByUser(user);
		
	}
	

}
