package com.example.demo.service;

import java.util.List;

public interface ICrudService<T, ID> {

	public List<T> getAll();
	public void add(T entity);
	public void update(T entity);
	public void delete(ID id);
}
