package com.yocool.todo.vo;

import com.yocool.todo.model.Todo;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


public class TodoDto {
    @NotEmpty
    @Length(min = 1, max = 100)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Todo toTodo() {
        return new Todo(description);
    }
}
