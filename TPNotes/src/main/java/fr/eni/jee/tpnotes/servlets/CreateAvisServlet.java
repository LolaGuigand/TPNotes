package fr.eni.jee.tpnotes.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.tpnotes.bll.AvisManager;
import fr.eni.jee.tpnotes.bll.BusinessException;

/**
 * Servlet lié à la fonctionnalité de création d'avis
 */
@WebServlet("/CreerAvis")
public class CreateAvisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AvisManager avisManager;
	
	public CreateAvisServlet() {
		super();
		this.avisManager= new AvisManager();
	}
       
   /**
    * doGet() : redirige vers la JSP qui content le formulaire de création d'avis
    */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/createAvis.jsp").forward(request, response);
	}

	/**
	 * @see récupère les informations envoyées par le formulaire, délègue la création à la couche BLL et renvoie le résultat à la JSP
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {	
					// TODO 1  récupère les informations envoyées par le formulaire
			int note = Integer.parseInt(request.getParameter("note"));
			String description = request.getParameter("description");
			
			// 2 on appelle la couche BLL avec ces paramètres
			this.avisManager.creerAvis(note,description);
			
			//3 ajouter un attribut pour dire que tout s'est bien passé
			request.setAttribute("succes",true);
			
		//si jamais l'exception levée n'est pas de type Business	
		}catch (BusinessException e) {
			request.setAttribute("erreur",e.getMessage());
			
		}catch(Exception e) {
			request.setAttribute ("erreur", "une erreur s'est produite pendant la création");
			e.printStackTrace();
			
		}
		request.getRequestDispatcher("/WEB-INF/createAvis.jsp").forward(request, response);
		// ou this.doGet(request, response); puisque le doGet redirige sur la JSP lui aussi

	 }

}
