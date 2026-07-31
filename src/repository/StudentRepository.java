package repository;

import entity.Student;

import java.util.*;

public class StudentRepository implements Repository<Student, Integer> {

	private final Map<Integer, Student> students = new HashMap<>();
	private Integer id = 0;
	@Override
	public void add(Student student) {
		student.setId(this.id);
		students.put(id++, student);
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
