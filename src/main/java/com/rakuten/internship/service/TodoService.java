package com.rakuten.internship.service;

import com.rakuten.internship.entity.Todo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

/**
 * このクラスは、データベースとのトランザクションをサポートするサービスクラスです。。
 */
@Service
@Transactional
public class TodoService {

    // TODO 必要なメンバーを宣言してください。
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Todo> findTodos(){
        // TODO 必要なコードを作成してください。
        List list = jdbcTemplate.queryForList("select * from tasks");
        
        List<Todo> todos = new ArrayList<Todo>();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map map = (Map)it.next();
            Todo todo = createTodo(map);
            todos.add(todo);
        }
                
        return todos;
    }
    
    // try ～ catch 使えばいけそうな気もするが…
    private Todo createTodo(Map map) {
        Todo todo = new Todo();
        todo.setId(((Integer) map.get("number")).intValue());
        todo.setTitle((String) map.get("title"));
        todo.setDescription((String) map.get("description"));
        return todo;
    }
    
    public Todo save(Todo todo) {
        // TODO 必要なコードを作成してください。
        String sql = "insert into tasks(number, title, description) values("
            + todo.getId()
            + ",'" 
            + todo.getTitle()
            + "','"
            + todo.getDescription()
            + "');";
        jdbcTemplate.update(sql);        
        
        return null;
    }


    public int returnRecords(){
        List list = jdbcTemplate.queryForList("select * from tasks");
        return list.size();
    }
}