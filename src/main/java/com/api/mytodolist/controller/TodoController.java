package com.api.mytodolist.controller;


import com.api.mytodolist.models.Todo;
import com.api.mytodolist.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        try {
            List<Todo> todoList = todoService.findAll();
            return new ResponseEntity<>(todoList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping
    public ResponseEntity<Todo> save(@RequestBody Todo todo) {
        try {
            todoService.save(todo);
            return new ResponseEntity<>(todo, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(todo, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo>  findById(@PathVariable Long id) {

        try{
            Todo todo = todoService.findById(id);
            return new ResponseEntity<>(todo, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteById(@PathVariable Long id) {
        try {
            todoService.deleteById(id);
            return HttpStatus.OK;
        }catch (Exception e){
            return HttpStatus.BAD_REQUEST;
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        Todo updatedTodo = todoService.updateTodo(id, todo);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }
}
