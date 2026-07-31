package repository;

import entity.Student;

import java.util.*;

public class StudentRepository implements Repository<Student, Long> {

	private final Map<Long, Student> students = new HashMap<>();
	@Override
	public void add(Student student) {
		students.put(student.getId(), student);
	}

	@Override
	public void remove(Long key) {
		students.remove(key);
	}

	@Override
	public Optional<Student> getById(Long key) {
		var student = students.get(key);
		return Optional.ofNullable(student);
	}

	@Override
	public List<Student> getAll() {
		return new ArrayList<>(students.values());
	}
}
