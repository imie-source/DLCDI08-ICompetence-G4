package fr.imie.transactionalFramework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.transaction.TransactionRequiredException;

import fr.imie.exceptionManager.ExceptionManager;


public abstract class ATransactional implements ITransactional {
	private static String URL = jdbc.getString("jdbc.url"); //$NON-NLS-1$
	private static String USER = jdbc.getString("jdbc.user"); //$NON-NLS-1$
	private static String PASSWD = jdbc.getString("jdbc.password"); //$NON-NLS-1$

	private Connection connection;
	
	private Boolean transactionalInitiator = null;

	/* (non-Javadoc)
	 * @see org.imie.connectionFramework.IService#getConnection()
	 */
	@Override
	public Connection getConnection() {
		return connection;
	}

	/* (non-Javadoc)
	 * @see org.imie.connectionFramework.IService#setConnection(java.sql.Connection)
	 */
	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	/* (non-Javadoc)
	 * @see org.imie.DAO.IAbstractDAO#putInTransaction(org.imie.DAO.AbstractDAO)
	 */
	@Override
	public void putInTransaction(ITransactional transactional) throws TransactionRequiredException {
		if (transactionalInitiator != null) {
			throw new TransactionRequiredException();
		}
		this.connection = transactional.getConnection();
		this.transactionalInitiator = false;
	}

	/* (non-Javadoc)
	 * @see org.imie.DAO.IAbstractDAO#putOffTransaction()
	 */
	@Override
	public void putOffTransaction() {
		this.connection = null;
		this.transactionalInitiator = null;
	}

	@Override
	public void beginTransactionalConnexion() throws ClassNotFoundException, TransactionalConnectionException {
		System.out.println("$$$$$$$$$$$$ debut transaction "+this.getClass().getName());
		if (transactionalInitiator != null) {
			if (transactionalInitiator == true) {
				throw new TransactionalConnectionException("en cours de connexion");
			} else if (transactionalInitiator == false) {
				System.out.println("$$$$$$$$$$$$ transaction exclave "+this.getClass().getName());
				// rien à faire
			}
		} else {
			System.out.println("$$$$$$$$$$$$ creation transaction");
			transactionalInitiator = true;
			initConnection();
			try {
				connection.setAutoCommit(false);
			} catch (SQLException e) {
				ExceptionManager.getInstance().manageException(e);
			}
		}
	}
	
	@Override
	public void endTransactionalConnexion() {
		System.out.println("$$$$$$$$$$$$ fin transaction "+this.getClass().getName());
		if (transactionalInitiator == true) {
			// libération des ressources
			try {
				if (connection != null) {
					System.out.println("$$$$$$$$$$$$ commit "+this.getClass().getName());
					connection.commit();
				}
			} catch (SQLException e) {
				if (connection != null) {
					try {
						System.out.println("$$$$$$$$$$$$ rollback "+this.getClass().getName());
						connection.rollback();
					} catch (SQLException e1) {
						ExceptionManager.getInstance().manageException(e1);
					}
				}
				ExceptionManager.getInstance().manageException(e);
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						ExceptionManager.getInstance().manageException(e);
					}
				}
				transactionalInitiator = null;
			}

		}
	}

	private void initConnection() {
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWD);
		} catch (SQLException e) {
			ExceptionManager.getInstance().manageException(e);
		}
	}

	
}
