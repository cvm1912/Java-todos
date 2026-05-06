package org.example.todosapi;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("anotherTodoService")
@Primary
public class AnotherTodoService implements TodoService{
    @Override
    @TimeMonitor
    public String doSomething() {
        return "something from another todo service";
    }
}
