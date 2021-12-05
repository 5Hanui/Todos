package com.demo.todos.service;


import com.demo.todos.dto.TodoRequestDto;
import com.demo.todos.dto.TodoResponseDto;
import com.demo.todos.entity.Todo;
import com.demo.todos.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public TodoResponseDto createTodo(TodoRequestDto requestDto) {

        Todo todo = requestDto.toEntity();
        todo = todoRepository.save(todo);

        return TodoResponseDto.toDto(todo);
    }

    public List<TodoResponseDto> findAll() {

        List<Todo> todoList = todoRepository.findAll();

        return TodoResponseDto.toDtoList(todoList);
    }

    public TodoResponseDto findTodoById(String todoId) {
        int id = Integer.parseInt(todoId);

        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isEmpty()) return null;

        return TodoResponseDto.toDto(todo.get());
    }

    @Transactional
    public TodoResponseDto updateTodo(String todoId, TodoRequestDto requestDto) {

        int id = Integer.parseInt(todoId);

        Optional<Todo> todoEntity = todoRepository.findById(id);
        if(todoEntity.isEmpty()) return null;

        Todo todo = todoEntity.get();
        todo.modify(requestDto);
        return TodoResponseDto.toDto(todo);
    }

    @Transactional
    public TodoResponseDto deleteTodo(String todoId) {

        int id = Integer.parseInt(todoId);

        Optional<Todo> todoEntity = todoRepository.findById(id);
        if(todoEntity.isEmpty()) return null;

        Todo todo = todoEntity.get();
        todoRepository.delete(todo);

        return TodoResponseDto.toDto(todo);
    }

}
