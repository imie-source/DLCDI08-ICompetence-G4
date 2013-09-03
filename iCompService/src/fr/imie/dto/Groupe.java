
package fr.imie.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Groupe Object
 * 
 * @author imie
 * @version 1.0
 * 
 */
public class Groupe {

	private int id;
	private int avancement;
	private String nom;
	private String description;
	private int staNum;
	private int usrNum;
	private List<Utilisateur> utilisateurs;
	private List<Invitation> invitations;
	private Statut statut;

	public Groupe() {
		super();
		utilisateurs = new ArrayList<Utilisateur>();
		invitations = new ArrayList<Invitation>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAvancement() {
		return avancement;
	}
	public void setAvancement(int avancement) {
		this.avancement = avancement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStaNum() {
		return staNum;
	}
	public void setStaNum(int staNum) {
		this.staNum = staNum;
	}
	public int getUsrNum() {
		return usrNum;
	}
	public void setUsrNum(int usrNum) {
		this.usrNum = usrNum;
	}

	// remplacement du setUtilisateur par les methodes de l'API List
	public void addUtilisateur(Utilisateur utilisateur) {
		this.utilisateurs.add(utilisateur);
	}

	// remplacement du setUtilisateur par les methodes de l'API List
	public void removeUtilisateur(Utilisateur utilisateur) {
		this.utilisateurs.remove(utilisateur);
	}

	// remplacement du setUtilisateur par les methodes de l'API List
	public void addInvitation(Invitation invitation) {
		this.invitations.add(invitation);
	}

	// remplacement du setUtilisateur par les methodes de l'API List
	public void removeInvitation(Invitation invitation) {
		this.invitations.remove(invitation);
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

}
