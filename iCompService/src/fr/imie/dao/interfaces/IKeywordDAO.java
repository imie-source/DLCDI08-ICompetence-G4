package fr.imie.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.imie.dto.Keyword;
import fr.imie.transactionalFramework.TransactionalConnectionException;

public interface IKeywordDAO {

	public List<Keyword> getKeyword() throws TransactionalConnectionException;
	
	
		
	public Keyword insertKeyword(Keyword keyword)
			throws TransactionalConnectionException;

	public Keyword updateKeyword(Keyword keyword)
			throws TransactionalConnectionException;

	public void deleteKeyword(Keyword keyword) throws TransactionalConnectionException;

}
