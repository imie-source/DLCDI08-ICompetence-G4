package fr.imie.dto;

import java.util.List;

/**
 * DTO représentant une copétence. Ce DTO est concu en fonction des besoins de
 * l'interface Il ne peut pas être utilisé pour afficher les niveaux des Users à
 * partir d'une compétence par ex.
 * 
 * @author imie
 * 
 */
public class Competence {

	private int id;
	private String libelle;
	private List<Niveau> listNiveau;
	private List<Utilisateur> listUtilisateur;
	private Niveau niveau;
	private Domaine domaine;
	private List<Keyword> listKeyword;


	/**
	 * @return the list of Utilisateur
	 */
	public List<Utilisateur> getUtilisateur() {
		return listUtilisateur;
	}

	/**
	 * @param utilisateur
	 *            the list of Utilisateur to set
	 */
	public void setUtilisateur(List<Utilisateur> utilisateur) {
		this.listUtilisateur = utilisateur;
	}

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * 
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * 
	 * @return
	 */
	public List<Niveau> getListNiveau() {
		return listNiveau;
	}

	/**
	 * 
	 * @param listNiveau
	 */
	public void setListNiveau(List<Niveau> listNiveau) {
		this.listNiveau = listNiveau;
	}

	/**
	 * 
	 * @return
	 */
	public Niveau getNiveau() {
		return niveau;
	}

	/**
	 * 
	 * @param niveau
	 */
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public List<Keyword> getListKeyword() {
		return listKeyword;
	}

	public void addListKeyword(List<Keyword> listKeyword) {
		this.listKeyword = listKeyword;
	}
	
	public void removeListKeyword(List<Keyword> listKeyword) {
		this.listKeyword = listKeyword;
	}
}
