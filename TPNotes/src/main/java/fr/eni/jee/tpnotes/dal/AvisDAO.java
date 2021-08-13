package fr.eni.jee.tpnotes.dal;

import java.sql.ResultSet;
import java.util.List;

import fr.eni.jee.tpnotes.bll.BusinessException;
import fr.eni.jee.tpnotes.bo.Avis;

public interface AvisDAO {
	public void createAvis(Avis avis) throws BusinessException ;
	public List<Avis> listerAvis() throws BusinessException ;
}
