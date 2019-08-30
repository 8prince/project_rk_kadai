package com.rakuten.internship.service;

import java.util.List;

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
    
    private Todo createTodo(Map map) {
        Todo todo = new Todo();
        todo.setId(((Integer) map.get("number")).intValue());
        todo.setTitle((String) map.get("title"));
        todo.setContents((String) map.get("description"));
        return todo;
    }
    
    public Todo save(Todo todo) {
        // TODO 必要なコードを作成してください。
        String sql = "INSERT INTO tasks(number, title, description) VALUES("
            + todo.getId()
            + ",'" 
            + todo.getTitle()
            + "','"
            + todo.getContents()
            + "');";
        jdbcTemplate.update(sql);        
        
        return null;
    }


    public int returnRecords(){
        List list = jdbcTemplate.queryForList("select * from tasks");
//        return jdbcTemplate.queryForInt("select count(*) from tasks");
        return list.size();
    }
}