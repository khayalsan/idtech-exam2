package service;

import entity.Student;
import repository.StudentRepository;

import java.util.*;

public class StudentService {
	private final StudentRepository repository = new StudentRepository();
	public void addStudent(Student student) {
		repository.add(student);
	}

	public Optional<Student> findStudentById(Integer id) {
		return repository.getById(id);
	}

	public List<Student> getAllStudents() {
		return repository.getAll();
	}

	public Student findTopStudent() {
		Comparator<Student> comparator = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				var score1 = o1.calculateAverageScore();
				var score2 = o2.calculateAverageScore();
				if (Objects.equals(score1, score2)) return 0;
				else if (score1 < score2) return 1;
				else return -1;
			}
		};
		TreeSet<Student> sortedSet = new TreeSet<>(comparator);

		sortedSet.addAll(repository.getAll());

		var topStudent = sortedSet.stream().findFirst().orElse(null);

		if (topStudent == null || !topStudent.hasAtLeastOneExam()) return null;
		else return topStudent;
	}
	public void printStudentsWithStatus() {
		var students = repository.getAll();
		students.forEach(student -> {
			final var status = student.isPassed() ? "PASS" : "FAIL";
			System.out.println(student.getName() + " - " + status);
		});
	}
}
