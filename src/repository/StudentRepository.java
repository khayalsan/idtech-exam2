package repository;

import entity.Student;

import java.util.List;
import java.util.Optional;

public class StudentRepository implements Repository<Student, Long> {



	@Override
	public Optional<Student> getById(Object key) {
		return Optional.empty();
	}

	@Override
	public void add(Student student) {

	}

	@Override
	public void remove(Long key) {

	}

	@Override
	public Optional<Student> getById(Long key) {
		return Optional.empty();
	}

	@Override
	public List<Student> getAll() {
		return List.of();
	}
}
