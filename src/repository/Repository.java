package repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, K> {
	void add(T t);
	void remove(K key);
	Optional<T> getById(K key);
	List<T> getAll();
}
