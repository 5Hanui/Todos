package com.demo.todos.service;


import com.demo.todos.dto.TodoRequestDto;
import com.demo.todos.dto.TodoResponseDto;
import com.demo.todos.entity.Todo;
import com.demo.todos.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
