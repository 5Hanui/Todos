package com.demo.todos.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "user_tb")
public class User {

    @Id
    @Column
    private String userId;

    @Column
    private String name;

    @Column
    private Integer age;
}
