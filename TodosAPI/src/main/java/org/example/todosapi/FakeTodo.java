package org.example.todosapi;

import org.springframework.stereotype.Component;

@Component
public class FakeTodo implements TodoService {

    // we have one method inside it
    public String doSomething(){
        return "hello from do something";
    }
}



