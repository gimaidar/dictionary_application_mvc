package com.gimaletdinov.dictionary.dictionary_application_mvc.controller;


import com.gimaletdinov.dictionary.dictionary_application_mvc.entity.Word;
import com.gimaletdinov.dictionary.dictionary_application_mvc.exception_handing.NoSuchWordException;
import com.gimaletdinov.dictionary.dictionary_application_mvc.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WordControllerREST {

    @Autowired
    private WordService wordService;

    @GetMapping("/words")
    public List<Word> showAllWords(){
        List<Word> allWords = wordService.getAllWords();

        return allWords;
    }

    @GetMapping("/words/{id}")
    public Word getWord(@PathVariable int id){
        Word word = wordService.getWord(id);

        if (word == null){
            throw new NoSuchWordException("There is no word with id = " + id + " in Database");
        }

        return word;
    }

    @PostMapping("/words")
    public Word addNewWord(@RequestBody Word word){
        wordService.saveWord(word);
        return word;
    }

    @PutMapping("/words")
    public Word updateWord(@RequestBody Word word){
        wordService.saveWord(word);
        return word;
    }

    @DeleteMapping("/words/{id}")
    public String deleteWord(@PathVariable int id){
        Word word = wordService.getWord(id);
        if (word == null){
            throw new NoSuchWordException("There is no word with id = 0" + id + " in Database");
        }

        wordService.deleteWord(id);
        return "Word with id = " + id + " was deleted";
    }
}
