package com.gimaletdinov.dictionary.dictionary_application_mvc.exception_handing;

public class NoSuchWordException extends RuntimeException{
    public NoSuchWordException(String message) {
        super(message);
    }
}
