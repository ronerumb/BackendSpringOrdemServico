package com.os.os.Controller.Exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private List<FieldMessage> listError = new ArrayList<>();

    public ValidationError() {

    }

    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);

    }


    public List<FieldMessage> getListError() {
        return listError;
    }

    public void addListError(String fieldName, String message ) {
        this.listError.add(new FieldMessage(fieldName,message));
    }
}
