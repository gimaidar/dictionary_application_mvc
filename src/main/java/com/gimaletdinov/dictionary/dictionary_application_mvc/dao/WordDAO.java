package com.gimaletdinov.dictionary.dictionary_application_mvc.dao;

import com.gimaletdinov.dictionary.dictionary_application_mvc.entity.Word;

import java.util.List;

public interface WordDAO {

    public List<Word> getAllWords();

    public void saveWord(Word word);

    public Word getWord(int id);

    public void deleteWord(int id);
}
