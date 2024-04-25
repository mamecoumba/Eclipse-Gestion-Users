package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UtilisateurDao;

/**
 * Servlet implementation class ListUser
 */
@WebServlet("/list")
public class ListUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String LIST_USER_VIEW = "/WEB-INF/listerUtilisateur.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Utilisateur> utilisateurs = UtilisateurDao.lister();
		request.setAttribute("utilisateurs", utilisateurs);

		getServletContext().getRequestDispatcher(LIST_USER_VIEW).forward(request, response);
	}

}
