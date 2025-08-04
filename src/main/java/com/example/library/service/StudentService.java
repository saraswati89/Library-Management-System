package com.example.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.entities.Student;
import com.example.library.entities.Transaction;
import com.example.library.repo.StudentRepository;
import com.example.library.repo.TransactionRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TransactionRepository transactionRepo;

	public StudentService() {

	}
	public String addStudent(Student student) {

		List<Student> allStudent = studentRepository.findAll();
		for (Student s : allStudent) {
			if (s.getYear().equals(student.getYear()) && s.getBranch().equals(student.getBranch())
					&& s.getDivision().equals(student.getDivision())
					&& s.getRollNumber().equals(student.getRollNumber())) {

				return "NOT OK";
			}
		}

		studentRepository.save(student);

		return "OK";
	}
	public List<String> getAllStudentsName() {
		List<Student> allStudent = studentRepository.findAll();
		List<String> studentNames = new ArrayList<String>();
		for (Student student : allStudent) {

			studentNames.add(student.getName() + ' ' + student.getSurname());
		}
		return studentNames;
	}
	public Student getOneStudent(Long regNumber) {

		Optional<Student> optional = studentRepository.findById(regNumber);
		return optional.get();
	}
	public List<Student> getAllStudents() {
		return studentRepository.findAll();

	}
	public List<Transaction> getTransactionsByStudentRegNumber(Long regNumber) {
		return transactionRepo.findByRegNumber(regNumber);
	}
	public Boolean validateRegNr(Long regNr) {
		Optional<Student> optional = studentRepository.findById(regNr);
		if (optional.isEmpty()) {

			return false;

		} else {
			return true;
		}
	}
	public Student searchByRegNr(Long regNr) {
		return studentRepository.getById(regNr);
	}
	public List<Student> searchBystudentName(String fullName) {

		List<Student> student = new ArrayList<Student>();
		List<Student> allStudent = studentRepository.findAll();
		for (Student S : allStudent) {
			String fName = S.getName() + " " + S.getSurname();
			if (fName.equalsIgnoreCase(fullName)) {
				student.add(S);
			}
		}

		return student;
	}
	public void payFine(Student student) {
		Student oneStudent = getOneStudent(student.getRegistrationNumber());
		int originalFinePaid = oneStudent.getFinePaid();
		originalFinePaid += student.getFinePaid();
		oneStudent.setFinePaid(originalFinePaid);
		studentRepository.save(oneStudent);

	}
	public void updateStudentDetails(Student student, Long regNumber) {

		Student student2 = studentRepository.getById(regNumber);

		student2.setName(student.getName());
		student2.setSurname(student.getSurname());
		student2.setYear(student.getYear());
		student2.setBranch(student.getBranch());
		student2.setDivision(student.getDivision());
		student2.setRollNumber(student.getRollNumber());

		studentRepository.save(student2);

	}
	public boolean deleteStudent(Long regNumber) {

		Student student = studentRepository.getById(regNumber);
		if (student.getFine() > student.getFinePaid() || student.getBooks().size() > 0) {

			return false;
		} else {
			studentRepository.delete(student);
			return true;
		}

	}

}
