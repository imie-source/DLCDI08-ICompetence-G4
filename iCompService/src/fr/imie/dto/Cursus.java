package fr.imie.dto;

/**
 * DTO représentant un cursus. Un cursus est une formation de l'école.
 * @author imie
 *
 */
public class Cursus {
	private Integer id ;
	private String libelle;
	
	/**
	 * 
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
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
	

}
