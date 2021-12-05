package com.demo.todos.controller;

import com.demo.todos.common.exception.ErrorCode;
import com.demo.todos.common.exception.validator.TodoValidator;
import com.demo.todos.dto.TodoRequestDto;
import com.demo.todos.dto.TodoResponseDto;
import com.demo.todos.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/todos")
public class TodoController {

    private final TodoService todoService;

    private final TodoValidator todoValidator;

    @PostMapping()
    @ResponseBody
    public ResponseEntity create(@RequestParam(value = "apikey", required = false) String apikey
                                                  ,@RequestBody TodoRequestDto requestDto) {
        if(apikey == null || !apikey.equals("123")) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ErrorCode.NOT_AUTHORIZED);

        todoValidator.isValid(requestDto);

        TodoResponseDto responseDto = todoService.createTodo(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping()
    public ResponseEntity<List<TodoResponseDto>> findAll() {

        List<TodoResponseDto> responseDtoList = todoService.findAll();
        return ResponseEntity.ok().body(responseDtoList);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity findTodoById(@PathVariable String todoId) {
        TodoResponseDto responseDto = todoService.findTodoById(todoId);
        return ResponseEntity.ok().body(responseDto);
    }

    @PutMapping("/{todoId}")
    public ResponseEntity updateTodo(@PathVariable String todoId
                                    , @RequestParam(value = "apikey",required = false) String apikey
                                    , @RequestBody TodoRequestDto requestDto) {
        if(apikey == null || !apikey.equals("123")) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ErrorCode.NOT_AUTHORIZED);

        todoValidator.isValid(requestDto);

        TodoResponseDto responseDto = todoService.updateTodo(todoId, requestDto);

        return ResponseEntity.ok().body(responseDto);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity deleteTodo(@PathVariable String todoId
                            , @RequestParam(value = "apikey",required = false) String apikey) {
        if(apikey == null || !apikey.equals("123")) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ErrorCode.NOT_AUTHORIZED);

        TodoResponseDto responseDto = todoService.deleteTodo(todoId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
