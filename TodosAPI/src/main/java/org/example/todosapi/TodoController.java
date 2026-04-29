package org.example.todosapi;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class TodoController {
   private static List<Todo> todos ;
   //constructor
   public TodoController(){
        todos = new ArrayList<>();
        todos.add(new Todo(1, false, "Study", 101));
       todos.add(new Todo(2, true, "Reading", 102));
   }

   @GetMapping("/todos")
    public List<Todo> getTodos(){
       return ResponseEntity.ok(todos).getBody();
   }


   @PostMapping("/todos")
   public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
       todos.add(newTodo);
       return ResponseEntity
               .status(HttpStatus.CREATED)
               .body(newTodo);
   }
}







