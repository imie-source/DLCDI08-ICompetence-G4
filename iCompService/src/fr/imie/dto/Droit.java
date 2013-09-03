package fr.imie.dto;

import java.util.List;

/**
 * Profil Object
 * 
 * @author imie
 * @version 1.0
 * 
 */
public class Droit {

	private List<Fonction> fonction;
	private Nature nature;
	private Profil profil;
	
	public List<Fonction> getFonction() {
		return fonction;
	}
	public void setFonction(List<Fonction> fonction) {
		this.fonction = fonction;
	}
	public Nature getNature() {
		return nature;
	}
	public void setNature(Nature nature) {
		this.nature = nature;
	}
	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}

}
