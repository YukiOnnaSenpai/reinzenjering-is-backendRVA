package rva.service;

import java.util.List;

public interface BaseService<T> {

	abstract void insert(T dao);

	abstract void update(T dao);

	abstract void delete(Integer id);

	abstract List<T> getAll();

	abstract T getOneById(Integer id);

	abstract List<T> getByName(String name);

}
