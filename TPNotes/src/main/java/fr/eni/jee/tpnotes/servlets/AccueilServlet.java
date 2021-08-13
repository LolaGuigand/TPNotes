package fr.eni.jee.tpnotes.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccueilServlet
 */


@WebServlet("/")
public class AccueilServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
      
   /**
    * doGet() : redirige sur la JSP d'accueil
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
   }



}
