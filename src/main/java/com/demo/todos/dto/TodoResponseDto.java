package com.demo.todos.dto;

import com.demo.todos.entity.Todo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class TodoResponseDto {
    private Integer id;
    private String name;
    private Boolean completed;

    @JsonProperty("complete_at")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="Asia/Seoul")
    private LocalDateTime completedAt;

    @JsonProperty("created_at")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="Asia/Seoul")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="Asia/Seoul")
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

    public static List<TodoResponseDto> toDtoList(List<?extends Todo> list) {
        List<TodoResponseDto> dto = new ArrayList<>();

        if(list != null) {
            for(Todo todo : list) {
                dto.add(toDto(todo));
            }
        }
        return dto;
    }
}
