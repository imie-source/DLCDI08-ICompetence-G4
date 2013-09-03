package fr.imie.dto;

/**
 * Fonction Object
 * 
 * @author imie
 * @version 1.0
 * 
 */
public class Fonction {

	private int id;
	private String libelle;
	private int action;
	private Fenetre fenetre;
	
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
	public int getAction() {
		return action;
	}
	/**
	 * 
	 * @param action
	 */
	public void setAction(int action) {
		this.action = action;
	}
	public Fenetre getFenetre() {
		return fenetre;
	}
	public void setFenetre(Fenetre fenetre) {
		this.fenetre = fenetre;
	}


}
