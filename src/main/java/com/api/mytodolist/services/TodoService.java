package com.api.mytodolist.services;

import com.api.mytodolist.models.Todo;
import com.api.mytodolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return (List<Todo>) todoRepository.findAll();
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo findById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid todo Id:" + id));
    }
    public Todo updateTodo(Long id, Todo todo) {
        Todo todoToUpdate = todoRepository.findById(id).orElseThrow(NoSuchElementException::new);
        todoToUpdate.setTitle(todo.getTitle());
        todoToUpdate.setDescription(todo.getDescription());
        todoToUpdate.setCompleted(todo.getCompleted());
        return todoRepository.save(todoToUpdate);
    }

    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }
}
