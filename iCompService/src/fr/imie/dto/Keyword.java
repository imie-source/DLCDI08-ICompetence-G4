package fr.imie.dto;

import java.util.List;

/**
 * Keyword Object
 * 
 * @author imie
 * @version 1.0
 *
 */
public class Keyword {

	private int id;
	private String libelle;
	private List<Competence> competences;
	
	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the keyId to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 *            the keyLibelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void addCompetences(List<Competence> competences) {
		this.competences = competences;
	}
	
	public void removeCompetences(List<Competence> competences) {
		this.competences = competences;
	}


}

