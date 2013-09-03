package fr.imie.dto;

/**
 * Adresse Object
 * 
 * @author imie
 * @version 1.0
 *
 */
public class Adresse {

	private Integer id;
	private String rue;
	private String complement;
	private String codePostal;
	private String ville;
	

	public String getRue() {
		return rue;
	}
	/**
	 * 
	 * @param rue
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	/**
	 * 
	 * @return
	 */
	public String getComplement() {
		return complement;
	}
	/**
	 * 
	 * @param complement
	 */
	public void setComplement(String complement) {
		this.complement = complement;
	}
	/**
	 * 
	 * @return
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * 
	 * @param codePostal
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	/**
	 * 
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
