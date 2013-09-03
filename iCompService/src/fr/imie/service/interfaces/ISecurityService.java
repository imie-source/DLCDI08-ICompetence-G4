package fr.imie.service.interfaces;

import java.util.List;

import fr.imie.dto.Droit;
import fr.imie.dto.Fenetre;
import fr.imie.dto.Fonction;
import fr.imie.dto.Nature;
import fr.imie.dto.Profil;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.transactionalFramework.TransactionalConnectionException;

public interface ISecurityService extends ITransactional {

	// ---------------------- FENETRE
	void deleteFenetre(Fenetre fenetre) throws TransactionalConnectionException;
	Fenetre updateFenetre(Fenetre fenetre) throws TransactionalConnectionException;
	Fenetre insertFenetre(Fenetre fenetre) throws TransactionalConnectionException;
	List<Fenetre> getFenetres() throws TransactionalConnectionException;

	// ---------------------- FONCTION
	List<Fonction> getFonctions() throws TransactionalConnectionException;
	Fonction insertFonction(Fonction fonction) throws TransactionalConnectionException;
	Fonction updateFonction(Fonction fonction) throws TransactionalConnectionException;
	void deleteFonction(Fonction fonction) throws TransactionalConnectionException;

	// ---------------------- PROFIL
	List<Profil> getProfils() throws TransactionalConnectionException;
	Profil insertProfil(Profil profil) throws TransactionalConnectionException;
	Profil updateProfil(Profil profil) throws TransactionalConnectionException;
	void deleteProfil(Profil profil) throws TransactionalConnectionException;

	// ---------------------- NATURE
	List<Nature> getNatures() throws TransactionalConnectionException;
	Nature insertProfil(Nature nature) throws TransactionalConnectionException;
	Nature updateProfil(Nature nature) throws TransactionalConnectionException;
	void deleteNature(Nature nature) throws TransactionalConnectionException;
	
	// ---------------------- DROIT
	List<Droit> getDroits() throws TransactionalConnectionException;
	Profil insertDroit(Droit droit) throws TransactionalConnectionException;
	Droit updateDroit(Droit droit) throws TransactionalConnectionException;
	void deleteDroit(Droit droit) throws TransactionalConnectionException;


}