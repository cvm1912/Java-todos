package org.example.todosapi;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
       return todos;
   }

   @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo newTodo){
       todos.add(newTodo);
       return newTodo;
   }
}







