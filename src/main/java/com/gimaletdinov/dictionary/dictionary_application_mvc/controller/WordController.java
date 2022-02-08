package com.gimaletdinov.dictionary.dictionary_application_mvc.controller;


import com.gimaletdinov.dictionary.dictionary_application_mvc.entity.Word;
import com.gimaletdinov.dictionary.dictionary_application_mvc.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/words")
public class WordController {

    @Autowired
    private WordService wordService;

    @RequestMapping("/")
    public String showAllWords(Model model){

        List<Word> allWords = wordService.getAllWords();
        model.addAttribute("allWords", allWords);

        return "word/all-words";
    }

    @RequestMapping("/addNewWord")
    public String addNewWord(Model model){

        Word word = new Word();
        model.addAttribute("word", word);

        return "word/word-info";
    }

    @RequestMapping("/saveWord")
    public String saveWord(@ModelAttribute("word") Word word){

        wordService.saveWord(word);

        return "redirect:/words/";
    }

    @RequestMapping("/updateInfo")
    public String updateWord(@RequestParam("wordId") int id, Model model){

        Word word = wordService.getWord(id);
        model.addAttribute("word", word);

        return "word/word-info";
    }

    @RequestMapping("/deleteWord")
    public String deleteWord(@RequestParam("wordId") int id){

        wordService.deleteWord(id);

        return "redirect:/words/";
    }
    
}
