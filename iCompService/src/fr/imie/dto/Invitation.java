package fr.imie.dto;

import java.sql.Date;

/**
 * Invitation Object
 * 
 * @author imie
 * @version 1.0
 * 
 */
public class Invitation {

	private int id;
	private boolean reponse;
	private Date date;
	private Utilisateur utilisateur;
	private Groupe groupe;

	/**
	 * @return the invNum
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the invNum to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the invReponse
	 */
	public boolean getReponse() {
		return reponse;
	}

	/**
	 * @param reponse
	 *            the invReponse to set
	 */
	public void setReponse(boolean reponse) {
		this.reponse = reponse;
	}

	/**
	 * @return the invDate
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the invDate to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

}
