package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author cyrusbrucker - cbrucker19
 * CIS175 - Spring 2022
 * Feb 17, 2022
 */
@Entity
@Table(name = "TextBooks")

public class ListBooks {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "book")
	private String book;
	@Column(name = "course")
	private String course;
	
	//constructors
	public ListBooks() {
		super();
	}
	public ListBooks(String book, String course) {
		super();
		this.book = book;
		this.course = course; 
	}
	public ListBooks(int id, String book, String course) {
		super();
		this.id = id; 
		this.book = book; 
		this.course = course; 
	}
	//Getters and setters 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	@Override
	public String toString() {
		return "ListBooks [id=" + id + ", book=" + book + ", courses=" + course + "]";
	}
	public String returnBookDetails() {
		return this.book + ":" + this.course; 
	}
}