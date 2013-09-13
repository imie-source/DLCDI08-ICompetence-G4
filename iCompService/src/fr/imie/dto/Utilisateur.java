package fr.imie.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.imie.utils.Utilitaire;

/**
 * DTO représantant un utilisateur
 * 
 * @author imie
 * 
 */
public class Utilisateur {

	// attributs de classe
	private int id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String mail;
	private String tel;
	private String fax;
	private int estEnFormation;
	private int estDisponible;
	private String login;
	private String pass;
	//private int curNum;
	//private int adrNum;	
	private List<Competence> competences;
	private Cursus cursus;
	private Adresse adresse;
	private List<Profil> profils;

	// constructeur
	// Ce constructeur par défaut est necessaire pour initialiser la liste des
	// compétence pour être sur que cette liste ne soit pas vide lors de
	// l'instanciation d'un nouvel objet
	public Utilisateur() {
		super();
		// initialisation de la liste des compétences
		competences = new ArrayList<Competence>();

		profils = new ArrayList<Profil>();
}

	// remplacement du setCompetence par les methodes de l'API List
	public void addCompetence(Competence competenceDTO) {
		this.competences.add(competenceDTO);
	}

	// remplacement du setCompetence par les methodes de l'API List
	public void removeCompetence(Competence competenceDTO) {
		this.competences.remove(competenceDTO);
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void addProfil(Profil profil) {
		this.profils.add(profil);
	}

	// remplacement du setCompetence par les methodes de l'API List
	public void removeProfil(Profil profil) {
		this.profils.remove(profil);
	}

	public List<Profil> getProfils() {
		return profils;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Cursus getCursus() {
		return cursus;
	}

	public void setCursus(Cursus cursus) {
		this.cursus = cursus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public int getEstEnFormation() {
		return estEnFormation;
	}

	public void setEstEnFormation(int estEnFormation) {
		this.estEnFormation = estEnFormation;
	}

	public int getEstDisponible() {
		return estDisponible;
	}

	public void setEstDisponible(int estDisponible) {
		this.estDisponible = estDisponible;
	}

	public int getAge() {
		// Se sert du pattern Singleton
		int age = Utilitaire.getInstance().getAge(dateNaissance);
		return age;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
