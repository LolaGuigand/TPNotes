package fr.eni.jee.tpnotes.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import fr.eni.jee.tpnotes.bll.BusinessException;
import fr.eni.jee.tpnotes.bo.Avis;

public class AvisDAOJdbcImpl implements AvisDAO{

	private static String SQL_INSERT_AVIS = "INSERT INTO AVIS (note, description) VALUES (?,?);";
	private static String  SQL_SELECT_AVIS = "SELECT note, description FROM AVIS";

	@Override
	public void createAvis(Avis avis) throws BusinessException {
		try (Connection connection = ConnectionProvider.getPoolConnection()){

			//On préremplit notre requêtre SQL
			PreparedStatement pSt = connection.prepareStatement(SQL_INSERT_AVIS);

			// On remplace la valeur des ? par les données entrées par l'utilisateur
			pSt.setInt(1, avis.getNote());
			pSt.setString(2,  avis.getDescription());

			//On envoie la requêtre SQL
			pSt.executeUpdate();


		}  catch ( SQLException e) {
			e.printStackTrace();
			throw new BusinessException ("une erreur SQL est apparue lors de la communication avec la base de données");

		}
	}

	public List<Avis> listerAvis() throws BusinessException {
		List<Avis>listeAvis = new ArrayList<Avis>();

		try (Connection connection = ConnectionProvider.getPoolConnection()){
			PreparedStatement pSt = connection.prepareStatement(SQL_SELECT_AVIS);

			//On envoie la requêtre SQL
		

			ResultSet rs = 	pSt.executeQuery();
			//pour chaque ligne de mon résultat, je remplis la liste
			while(rs.next()) {
				Avis avis = new Avis(rs.getInt("note"), rs.getString("Description"));
				listeAvis.add(avis);
			}

		
		}catch ( SQLException e) {
			e.printStackTrace();
			throw new BusinessException ("une erreur SQL est apparue lors de la communication avec la base de données");
		}
		return listeAvis;

	}
}
