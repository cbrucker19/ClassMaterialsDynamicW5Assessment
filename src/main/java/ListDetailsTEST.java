import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.StudentHelper;
import model.ListBooks;
import model.ListDetails;
import model.Student;

public class ListDetailsTEST {

	public static void main(String[] args) { 
		Student Cyrus = new Student("Cyrus");
		//StudentHelper sh = new StudentHelper();
		//sh.insertStudent(Cyrus);
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		ListBooks course1 = new ListBooks("CIS175", "Java2Book");
		ListBooks course2 = new ListBooks("CIS338","DatabaseBook");
		//ListBooks course3 = new ListBooks("WDV101","HTMLBook");
		//ListBooks course4 = new ListBooks("WDV341","PHPBook");
		
		List<ListBooks> cyrusItems = new ArrayList<ListBooks>();
		cyrusItems.add(course1);
		cyrusItems.add(course2);
		//cyrusItems.add(course3);
		//cyrusItems.add(course4);
		
		ListDetails cyrusList = new ListDetails("Cyrus' List", LocalDate.now(), Cyrus);
		
		cyrusList.setListOfItems(cyrusItems);
		ldh.insertNewListDetails(cyrusList);
		List<ListDetails> allLists = ldh.getLists();
		
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}
	}
}
