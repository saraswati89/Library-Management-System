package com.example.library.entities;

import java.util.ArrayList;

public class Constants {

	public Constants() {

	}

	public static String USERNAME = "Admin";
	public static String PASSWORD = "Password@123";
	public static int FINE_PER_DAY = 5;
	public static int RETURN_DURATION = 15;
	public static int BOOK_LIMIT = 4;
	public static String SESSION_ADMIN = "ADMIN";
	
	public static String SESSION_OK = "SOK";
	
	public static String SESSION_NOTOK = "SNOTOK";

	// Categories
	public static ArrayList<String> getAllCategories() {
		ArrayList<String> categories = new ArrayList<String>();
		categories.add("Engineering");
		categories.add("Technology");
		categories.add("MBA");
		categories.add("Competitive Exam");
		categories.add("General Knowledge");
		categories.add("Horror Stories");
		categories.add("Others");

		return categories;
	}

	// Branches
	public static ArrayList<String> getAllBranches() {
		ArrayList<String> branches = new ArrayList<String>();
		branches.add("Mechanical");
		branches.add("Civil");
		branches.add("E&TC");
		branches.add("Compter Science");
		branches.add("IT");
		branches.add("MBA");

		return branches;
	}

	// Years
	public static ArrayList<String> getAllYears() {
		ArrayList<String> years = new ArrayList<String>();
		years.add("First");
		years.add("Second");
		years.add("Third");
		years.add("Fourth");

		return years;
	}

	// Divisions
	public static ArrayList<String> getAllDivision() {
		ArrayList<String> divisions = new ArrayList<String>();
		divisions.add("A");
		divisions.add("B");
		divisions.add("C");

		return divisions;
	}

}
