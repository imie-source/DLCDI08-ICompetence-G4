package fr.imie.dto;

/**
 * Niveau Object
 * 
 * @author imie
 * @version 1.0
 *
 */
public class Niveau {

	private int id;
	private int evaluation;
	private String description;

	/**
	 * @return the nivNum
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the nivNum to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nivEvaluation
	 */
	public int getEvaluation() {
		return evaluation;
	}

	/**
	 * @param evaluation
	 *            the nivEvaluation to set
	 */
	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}
	
	/**
	 * @return the nivDescription
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the nivDescription to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
