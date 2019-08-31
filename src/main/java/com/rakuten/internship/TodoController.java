package com.rakuten.internship;

import com.rakuten.internship.entity.Todo;
import com.rakuten.internship.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * このクラスは、ウェブアプリケーションの挙動を制御するためのコントローラークラスです。。
 * コントローラーとして使えるように、コードを記入してください。
 */
@Controller
public class TodoController {

    // TODO 必要なメンバーを宣言してください。
    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String home(Model model) {
        // TODO 必要なコードを作成してください。
        List<Todo> todos = new ArrayList<Todo>();
        todos = todoService.findTodos();
        model.addAttribute("todos", todos);

        return "home";
    }

    @GetMapping("/create")
    public String create() {
        // TODO 必要なコードを作成してください。
        return "create";
    }

    @PostMapping("/create")
    public String createTodo(@ModelAttribute Todo todo,
                             @RequestParam("text1") String str1, 
                             @RequestParam("text2")String str2) {
        // TODO 必要なコードを作成してください。
        todo.setId(todoService.returnRecords() + 1);
        todo.setTitle(str1);
        todo.setDescription(str2);
        todoService.save(todo);
        return "complete";
    }
}
