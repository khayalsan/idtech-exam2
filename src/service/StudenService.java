package service;

import entity.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StudenService {
	private final Map<Long, Student> students = new HashMap<>();
	//          will be replaced	
	public void addStudent(Student student) {
		students.put(student.getId(), student);
	}

	public Optional<Student> findStudentById(Long id) {
		return Optional.empty();
	}

	public Student findTopStudent() {
		return null;
	}
	public void printStudentsWithStatus() {

	}
}
