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
	private int grpNum;
	private int usrNum;

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

	/**
	 * @return the grpNum
	 */
	public int getGrpNum() {
		return grpNum;
	}

	/**
	 * @param grpNum
	 *            the grpNum to set
	 */
	public void setGrpNum(int grpNum) {
		this.grpNum = grpNum;
	}

	/**
	 * @return the usrNum
	 */
	public int getUsrNum() {
		return usrNum;
	}

	/**
	 * @param usrNum
	 *            the usrNum to set
	 */
	public void setUsrNum(int usrNum) {
		this.usrNum = usrNum;
	}

}
