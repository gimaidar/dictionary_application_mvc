package com.gimaletdinov.dictionary.dictionary_application_mvc.exception_handing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WordGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<WordIncorrectData> hadleEception(NoSuchWordException exception){
        WordIncorrectData data = new WordIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<WordIncorrectData> hadleEception(Exception exception){
        WordIncorrectData data = new WordIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);

    }
}
