package fr.imie.dto;

/**
 * Profil Object
 * 
 * @author imie
 * @version 1.0
 * 
 */
public class Profil {

	private int id;
	private String nom;
	private String description;
	private Profil profil;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


}
