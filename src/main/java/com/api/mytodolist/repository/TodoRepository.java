package com.api.mytodolist.repository;

import com.api.mytodolist.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
