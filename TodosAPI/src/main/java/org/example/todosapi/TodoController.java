package org.example.todosapi;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Component
@RestController
@RequestMapping("/api/v1/todos")

public class TodoController {

    private FakeTodo fakeTodo;
    private static List<Todo> todos;
    private TodoService todoService;

    //constructor
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
        todos = new ArrayList<>();
        todos.add(new Todo(1, false, "Study", 101));
        todos.add(new Todo(2, true, "Reading", 102));
    }
    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {
        System.out.println(todoService.doSomething());
        return ResponseEntity.ok(todos);
    }





    @PostMapping("/create")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
        todos.add(newTodo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newTodo);
    }


    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long todoId) {
        for (Todo todo : todos) {
            if (todo.getId() == todoId) {
                return ResponseEntity.ok(todo);
            }

        }
        return ResponseEntity.notFound().build();
    }

}






