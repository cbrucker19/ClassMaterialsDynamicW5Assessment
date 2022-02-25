import java.util.List;

import controller.StudentHelper;
import model.Student;

public class StudentTEST {

	public static void main(String[] args) { 
		
	
	Student Joe = new Student("Joe");
	
	StudentHelper sh = new StudentHelper();
	
	sh.insertStudent(Joe);
	
	List<Student> allStudents = sh.showAllStudents();
	for(Student a: allStudents) {
		System.out.println(a.toString());
	}
	}
}
