package com.example.zadanie.exception;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String objectType, Object id) {
        super(objectType + " s ID " + id + " nebol nájdený");
    }
}