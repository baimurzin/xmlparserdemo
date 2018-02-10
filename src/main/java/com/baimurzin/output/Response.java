package com.baimurzin.output;

import java.util.ArrayList;
import java.util.List;

//todo refactor make more flexible
public class Response {
    private Object data;
    private List<Object> errors = new ArrayList<>();

    public Response() {
    }

    public void addError(Object error) {
        errors.add(error);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "Response{" +
                "data=" + data +
                ", errors=" + errors +
                '}';
    }
}
