package ru.netology.hibernate_layers.exception;

public class IncorrectInputDataException extends RuntimeException{
    public IncorrectInputDataException(String msg) {
        super(msg);
    }
}
