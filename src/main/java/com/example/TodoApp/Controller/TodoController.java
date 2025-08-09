package com.example.TodoApp.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TodoApp.Service.TodoServiceInterface;
import com.example.TodoApp.model.Todo;


@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoServiceInterface todoService;

    public TodoController(TodoServiceInterface todoService) {
        this.todoService = todoService;
    }

    // 1️⃣ Create To-do
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo savedTodo = todoService.saveTodo(todo);
        return ResponseEntity.status(201).body(savedTodo);
    }

    // 2️⃣ Get To-do by ID
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable int id) {
        Todo todo = todoService.getTodoById(id);
        if (todo != null) {
            return ResponseEntity.ok(todo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 3️⃣ Get all To-dos
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    // 4️⃣ Update To-do
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable int id, @RequestBody Todo updatedTodo) {
        Todo existingTodo = todoService.getTodoById(id);
        if (existingTodo != null) {
            existingTodo.setTitle(updatedTodo.getTitle());
            existingTodo.setDescription(updatedTodo.getDescription());
            existingTodo.setCompleted(updatedTodo.isCompleted());
            Todo savedTodo = todoService.saveTodo(existingTodo);
            return ResponseEntity.ok(savedTodo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 5️⃣ Delete To-do
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable int id) {
        Todo existingTodo = todoService.getTodoById(id);
        if (existingTodo != null) {
            todoService.deleteTodoById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
