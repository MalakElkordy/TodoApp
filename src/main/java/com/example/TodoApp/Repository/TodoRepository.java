package com.example.TodoApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TodoApp.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
