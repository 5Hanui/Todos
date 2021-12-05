package com.demo.todos.dto;

import com.demo.todos.entity.Todo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TodoResponseDto {
    private Integer id;
    private String name;
    private Boolean completed;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
    private LocalDateTime completedAt;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
    private LocalDateTime createdAt;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
    private LocalDateTime updatedAt;

    public static TodoResponseDto toDto(Todo todo) {
        return TodoResponseDto.builder()
                .id(todo.getId())
                .name(todo.getName())
                .completed(todo.getCompleted())
                .completedAt(todo.getCompletedAt())
                .createdAt(todo.getCreatedAt())
                .updatedAt(todo.getUpdatedAt())
                .build();
    }
}
