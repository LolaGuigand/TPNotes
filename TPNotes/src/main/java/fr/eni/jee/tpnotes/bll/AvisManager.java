package fr.eni.jee.tpnotes.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.tpnotes.bo.Avis;
import fr.eni.jee.tpnotes.dal.AvisDAO;
import fr.eni.jee.tpnotes.dal.DAOFactory;

/**
 * La couche BLL a pour but de 
 * -faire de la validation sur les données qu'elle reçoit
 * appeler les bonnes méthodes/classes de la couche DAL
 * instancier les objets BO à partir de ces données
 */
public class AvisManager {
	
	private AvisDAO avisDAO;
	
	
	public AvisManager() {
		super();
		// TODO Auto-generated constructor stub
		this.avisDAO=DAOFactory.getAvisDAO();
	}

	public void creerAvis(int note, String description) throws BusinessException {
		//TODO
		// 1- créer un objet Avis à partir des données transmises par le servlet
		
		Avis avis = new Avis (note,description);
		
		//2- on valide les données
	
			this.valider(avis);
			
			//Si validation n'a pas levé d'exception, on redirige le traitement à la couche DAL
			this.avisDAO.createAvis(avis);
	
	}
	

	public List<Avis> listerChaqueAvis() throws BusinessException {
		
		return this.avisDAO.listerAvis();
	
	}
	
	
private void valider(Avis avis) throws BusinessException {
	if (avis.getNote() <1 || avis.getNote()>5) {
		throw new BusinessException("la note doit être comprise entre 1 et 5");
	}
}
}
