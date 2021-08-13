package fr.eni.jee.tpnotes.dal;

public class DAOFactory {
	public static AvisDAOJdbcImpl getAvisDAO() {
		return new AvisDAOJdbcImpl();
	}
}
