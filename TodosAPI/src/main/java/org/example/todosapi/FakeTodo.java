package org.example.todosapi;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("fakeTodoService")
public class FakeTodo implements TodoService {


    @TimeMonitor
    // we have one method inside it
    public String doSomething(){
        return "hello from do something";
    }
}



