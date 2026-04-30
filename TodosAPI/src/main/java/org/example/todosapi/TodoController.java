package org.example.todosapi;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")

public class TodoController {
    private static List<Todo> todos;

    //constructor
    public TodoController() {
        todos = new ArrayList<>();
        todos.add(new Todo(1, false, "Study", 101));
        todos.add(new Todo(2, true, "Reading", 102));
    }

    @GetMapping("/")
    public List<Todo> getTodos() {
        return ResponseEntity.ok(todos).getBody();
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






