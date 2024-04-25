package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtilisateurDao;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/delete")
public class DeleteUser extends javax.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		if (id.matches("[0-9]+")) {
			UtilisateurDao.supprimer(Integer.parseInt(id));
		}

		response.sendRedirect("list");

	}

}
