package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListBooks;
/**
 * @author cyrusbrucker - cbrucker19
 * CIS175 - Spring 2022
 * Feb 17, 2022
 */
/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/EditItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			ListBookHelper dao = new ListBookHelper();
			String course = request.getParameter("course");
			String book = request.getParameter("book");
			Integer tempId = Integer.parseInt(request.getParameter("id"));
		
			ListBooks itemToUpdate = dao.searchForListBookById(tempId);
			itemToUpdate.setBook(book);
			itemToUpdate.setCourse(course);
		
			dao.updateListBooks(itemToUpdate);
		
			getServletContext().getRequestDispatcher("/ViewAllItemsServlet").forward(request, response);
		
	}

}
