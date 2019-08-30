package com.rakuten.internship.entity;

import javax.persistence.*;
import lombok.Data;

/**
 * このクラスは、タスク管理の対象となるTodoのエンティティーです。
 * エンティティーとして使えるように、コードを記入してください。
 */
@Entity
@Data
public class Todo {
    // TODO 必要なコードを記入してください。
    
    @Id
    public int id;
    public String title;    
    public String description;
    
    public Todo() {}
    
    public Todo(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}