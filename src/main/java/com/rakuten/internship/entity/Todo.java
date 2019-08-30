package com.rakuten.internship.entity;

import javax.persistence.*;

// import lombok.*; // 恐らく lombok の jar ファイルをインストールする必要ありか(?)

/**
 * このクラスは、タスク管理の対象となるTodoのエンティティーです。
 * エンティティーとして使えるように、コードを記入してください。
 */
@Entity
// @Data
// @Getter
// @Setter
public class Todo {
    // TODO 必要なコードを記入してください。
    
    @Id
    public int id;
    public String title;    
    public String description;
    
    public Todo() {}
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Todo(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}