package com.demo.todos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.todos.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
