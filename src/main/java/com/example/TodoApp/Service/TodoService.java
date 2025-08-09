package com.example.TodoApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.TodoApp.Repository.TodoRepository;
import com.example.TodoApp.model.Todo;

@Service
public class TodoService implements TodoServiceInterface {
	  private final TodoRepository todoRepository;

	    
	    public TodoService(TodoRepository todoRepository) {
	        this.todoRepository = todoRepository;
	    }
	    @Override
	    public Todo saveTodo(Todo todo) {
	        return todoRepository.save(todo);
	    }
	    @Override
	    public Todo getTodoById(int id) {
	    	   return todoRepository.findById(id).orElse(null);
	    }

	    @Override
	    public List<Todo> getAllTodos() {
	        return todoRepository.findAll();
	    }
	    @Override
	    public void deleteTodoById(int id) {
	        todoRepository.deleteById(id);
	    }
}
