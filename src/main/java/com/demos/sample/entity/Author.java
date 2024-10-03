package com.demos.sample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name="Author")
public class Author {
    
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	private String firstName;
	private long phoneNo;
	private String book;
	
	public Author(int id, String firstName, long phoneNo, String book) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.phoneNo = phoneNo;
		this.book = book;
	}
	public Author( String firstName,  String book,long phoneNo) {
		
		
		this.firstName = firstName;
		this.phoneNo = phoneNo;
		this.book = book;
	}

	public Author() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", phoneNo=" + phoneNo + ", book=" + book + "]";
	}
	
	

}
