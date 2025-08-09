package com.example.TodoApp.Service;

import java.util.List;
import java.util.Optional;

import com.example.TodoApp.model.Todo;

public interface TodoServiceInterface {
	  Todo saveTodo(Todo todo);

	    Todo getTodoById(int id);
	    List<Todo> getAllTodos();
	    void deleteTodoById(int id);
	    default boolean isValidTodo(Todo todo) {
	        return todo != null && todo.getTitle() != null && !todo.getTitle().trim().isEmpty();
	    }
}
