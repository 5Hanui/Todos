package com.demo.todos.common.exception.validator;


import com.demo.todos.dto.TodoRequestDto;
import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    public boolean isValid(TodoRequestDto requestDto) {
        if(requestDto.getName() == null && requestDto.getCompleted() == null)
            return false;
        return true;
    }
}
