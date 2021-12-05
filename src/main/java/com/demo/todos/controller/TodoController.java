package com.demo.todos.controller;

import com.demo.todos.dto.TodoRequestDto;
import com.demo.todos.dto.TodoResponseDto;
import com.demo.todos.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/todos")
public class TodoController {

    private final TodoService todoService;

    @PostMapping()
    @ResponseBody
    public ResponseEntity<TodoResponseDto> create(@RequestBody TodoRequestDto requestDto) {
        TodoResponseDto responseDto = todoService.createTodo(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping()
    public void findAll() {
        log.info("findAll");
    }

    @GetMapping("/{id}")
    public void findTodoById(@PathVariable Integer id) {
        log.info("findTodoById");
    }

    @PutMapping("/{id}")
    public void updateTodo(@PathVariable Integer id) {
        log.info("updateTodo");
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Integer id) {
        log.info("deleteTodo");
    }
}
