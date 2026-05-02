package org.example.todosapi;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AnotherTodoService implements TodoService{
    @Override
    public String doSomething() {
        return "something from another todo service";
    }
}
