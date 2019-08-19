package com.rakuten.internship.entity;

import javax.persistence.*;

/**
 * このクラスは、タスク管理の対象となるTodoのエンティティーです。
 * エンティティーとして使えるように、コードを記入してください。
 */
@Entity
public class Todo {
    // TODO 必要なコードを記入してください。
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private Integer id;
 
    private String title;    
 
    private String description;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "Todo [id=" + id + ", title=" + title + ", description=" + description + "]";
    }
 
}