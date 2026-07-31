package repository;

import entity.Student;

import java.util.*;

public class StudentRepository implements Repository<Student, Integer> {

	private final Map<Integer, Student> students = new HashMap<>();
	@Override
	public void add(Student student) {
		students.put(student.getId(), student);
	}

	@Override
	public void remove(Integer id) {
		students.remove(id);
	}

	@Override
	public Optional<Student> getById(Integer id) {
		var student = students.get(id);
		return Optional.ofNullable(student);
	}

	@Override
	public List<Student> getAll() {
		return new ArrayList<>(students.values());
	}
}
