package fr.eni.jee.tpnotes.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {
	
	private static DataSource dataSource; //attribut de la classe (static) qui correspond à notre POOL DE CONNEXIONS
	
	
	/* INITIALISATION DU DATASOURCE*/
	// static : bloc de code qui est executé UNE fois pour la classe (on veut s'assurer qu'on ne cherche pas à récupérer plusieurs fois le Datasource)
	static {
		try {
			Context context = new InitialContext();
			
			// on n'utilise pas this.datasource car datasource est un attribut de la classe (static), il faut donc utiliser le nom de la classe à la place de this
			ConnectionProvider.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}



	
	/*
	 * getConnection() : méthode qui va être utilisée par les DAOImpl pour récupérer une connexion du pool 
	 */
	public static Connection getPoolConnection() throws SQLException {
		return ConnectionProvider.dataSource.getConnection();
	}
	
	

}
