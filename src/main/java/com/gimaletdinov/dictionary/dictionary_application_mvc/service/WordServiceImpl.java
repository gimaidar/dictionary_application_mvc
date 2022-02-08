package com.gimaletdinov.dictionary.dictionary_application_mvc.service;

import com.gimaletdinov.dictionary.dictionary_application_mvc.dao.WordDAO;
import com.gimaletdinov.dictionary.dictionary_application_mvc.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WordServiceImpl implements WordService{

    @Autowired
    private WordDAO wordDAO;

    @Override
    @Transactional
    public List<Word> getAllWords() {
        return wordDAO.getAllWords();
    }

    @Override
    @Transactional
    public void saveWord(Word word) {
        wordDAO.saveWord(word);
    }

    @Override
    @Transactional
    public Word getWord(int id) {
        return wordDAO.getWord(id);
    }

    @Override
    @Transactional
    public void deleteWord(int id) {
        wordDAO.deleteWord(id);
    }
}
