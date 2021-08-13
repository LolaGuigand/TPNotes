package fr.eni.jee.tpnotes.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.tpnotes.bll.AvisManager;
import fr.eni.jee.tpnotes.bll.BusinessException;
import fr.eni.jee.tpnotes.bo.Avis;
import fr.eni.jee.tpnotes.dal.AvisDAOJdbcImpl;

/**
 * Servlet implementation class ListerAvisServlet
 */
@WebServlet("/ListerAvis")
public class ListerAvisServlet extends HttpServlet {
	
	private AvisManager avisManager;
	 List<Avis> listeAvis= new ArrayList<Avis>();
	
	public ListerAvisServlet() {
		super();
		this.avisManager = new AvisManager();
	}

	private static final long serialVersionUID = 1L;
	      
	   /**
	    * doGet() : redirige sur la JSP d'accueil
	    */
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       // 1- récupérer avis depuis couche BLL (BDD)
		   try {
		  
		   listeAvis = this.avisManager.listerChaqueAvis();
			} catch (BusinessException e) {
			
				request.setAttribute("erreur", e.getMessage());
			}
		   //2- ajouter liste en attribut de requête
	      
			request.setAttribute("listeAvis", listeAvis);
		
	   
			
			request.getRequestDispatcher("/WEB-INF/listerAvis.jsp").forward(request, response);
			
	   }

}
