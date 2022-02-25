package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ListDetails {
	@Id
	@GeneratedValue 
	private int id; 
	private String listName;
	private LocalDate courseStartDate;
	
	
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Student student; 
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ListBooks> listOfItems;
	
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListDetails(int id, String listName, LocalDate courseStartDate, Student student, List<ListBooks> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.courseStartDate = courseStartDate;
		this.student = student; 
		this.listOfItems = listOfItems;
	}

	public ListDetails(String listName, LocalDate courseStartDate, Student student, List<ListBooks> listOfItems) {
		super();
		this.listName = listName;
		this.courseStartDate = courseStartDate;
		this.student = student; 
		this.listOfItems = listOfItems;
	}

	public ListDetails(String listName, LocalDate courseStartDate, Student student) {
		super();
		this.listName = listName;
		this.courseStartDate = courseStartDate;
		this.student = student; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(LocalDate courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<ListBooks> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<ListBooks> listOfItems) {
		this.listOfItems = listOfItems;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", courseStartDate=" + courseStartDate
				+ ", student=" + student + ", listOfItems=" + listOfItems + "]";
	}
}