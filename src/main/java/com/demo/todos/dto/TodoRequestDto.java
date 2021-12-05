package com.demo.todos.dto;


import com.demo.todos.entity.Todo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TodoRequestDto {

    private String name;
    private Boolean completed;

    public Todo toEntity() {
        return Todo.builder()
                .name(this.name)
                .completed(this.completed)
                .build();
    }
}
