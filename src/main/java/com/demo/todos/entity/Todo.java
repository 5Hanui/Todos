package com.demo.todos.entity;

import com.demo.todos.dto.TodoRequestDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todo_tb")
public class Todo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private Boolean completed;

    @Column
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="Asia/Seoul")
    private LocalDateTime completedAt;

    public void modify(TodoRequestDto requestDto) {
        if(requestDto.getName() != null) this.name = requestDto.getName();
        if(requestDto.getCompleted() != null) this.completed = requestDto.getCompleted();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
