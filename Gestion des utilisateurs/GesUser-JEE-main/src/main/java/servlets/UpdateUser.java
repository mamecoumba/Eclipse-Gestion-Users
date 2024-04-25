package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UtilisateurDao;

/**
 * Servlet implementation class UpdateUser
 */
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPDATE_USER_VIEW = "/WEB-INF/modifierUtilisateur.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		if (id.matches("[0-9]+")) {
			Utilisateur utilisateur = UtilisateurDao.get(Integer.parseInt(id));

			if (utilisateur != null) {

				request.setAttribute("utilisateur", utilisateur);
				getServletContext().getRequestDispatcher(UPDATE_USER_VIEW).forward(request, response);
				return;
			}
		}
		response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		Utilisateur utilisateur = new Utilisateur(Integer.parseInt(id), nom, prenom, login, password);

		if (UtilisateurDao.modifier(utilisateur)) {
			response.sendRedirect("list");
		} else {
			response.sendRedirect("update?id=" + id);
		}
	}

}
