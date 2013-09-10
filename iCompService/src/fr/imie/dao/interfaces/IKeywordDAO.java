package fr.imie.dao.interfaces;

import java.util.List;

import fr.imie.dto.Competence;
import fr.imie.dto.Keyword;
import fr.imie.transactionalFramework.TransactionalConnectionException;

public interface IKeywordDAO {

	public List<Keyword> getKeyword() throws TransactionalConnectionException;
	
	
		
	public Keyword insertKeyword(Keyword keyword)
			throws TransactionalConnectionException;

	public Keyword updateKeyword(Keyword keyword)
			throws TransactionalConnectionException;

	public void deleteKeyword(Keyword keyword) throws TransactionalConnectionException;



	public List<Keyword> getKeywordBycompetence(Competence competence)
			throws TransactionalConnectionException;

}
