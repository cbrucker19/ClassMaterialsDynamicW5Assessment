package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListBooks;
import model.ListDetails;
import model.Student;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/EditListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
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
		ListDetailsHelper dao = new ListDetailsHelper();
		ListBookHelper lih = new ListBookHelper();
		StudentHelper sh = new StudentHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listtoUpdate = dao.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String studentName = request.getParameter("studentName");
		Student newStudent = sh.findStudent(studentName);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch (NumberFormatException ex) {
			ld = LocalDate.now(); 
		}
		try {
			//items are selected in list to add
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<ListBooks> selectedItemsInList = new ArrayList<ListBooks>();

			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ListBooks c = lih.searchForListBookById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);

			}
			listtoUpdate.setListOfItems(selectedItemsInList);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<ListBooks> selectedItemsInList = new ArrayList<ListBooks>();
			listtoUpdate.setListOfItems(selectedItemsInList);
		}

		listtoUpdate.setListName(newListName);
		listtoUpdate.setCourseStartDate(ld);
		listtoUpdate.setStudent(newStudent);

		dao.updateList(listtoUpdate);

		getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
	
	}

}
