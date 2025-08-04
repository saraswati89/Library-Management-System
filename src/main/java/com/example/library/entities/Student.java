package com.example.library.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long regNumber;
	public String name;
	public String surname;
	public String branch;
	public String year;
	public String division;
	public String rollNumber;
	
	@OneToMany
	public List<Book> books;
	
	
	public int fine;
	public int finePaid;
	
	public Long getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(Long regNumber) {
		this.regNumber = regNumber;
	}

	public int getFinePaid() {
		return finePaid;
	}

	public void setFinePaid(int finePaid) {
		this.finePaid = finePaid;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public Long getRegistrationNumber() {
		return regNumber;
	}

	public void setRegistrationNumber(Long registrationNumber) {
		this.regNumber = registrationNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBook(List<Book> books) {
		this.books = books;
	}

	public Student() {
		super();
	}

	

}
