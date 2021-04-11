package de.orion.controller.exception;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException() {
        super("Person is not found");
    }
}
