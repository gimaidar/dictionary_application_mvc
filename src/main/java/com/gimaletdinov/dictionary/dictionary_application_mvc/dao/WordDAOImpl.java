package com.gimaletdinov.dictionary.dictionary_application_mvc.dao;

import com.gimaletdinov.dictionary.dictionary_application_mvc.entity.Word;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class WordDAOImpl implements WordDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Word> getAllWords() {
        Session session = entityManager.unwrap(Session.class);
        List<Word> allWord = session.createQuery("from Word", Word.class).getResultList();
        return allWord;
    }

    @Override
    public void saveWord(Word word) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(word);
    }

    @Override
    public Word getWord(int id) {
        Session session = entityManager.unwrap(Session.class);
        Word word = session.get(Word.class, id);
        return word;
    }

    @Override
    public void deleteWord(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Word> query = session.createQuery("delete from Word where id =: wordId");
        query.setParameter("wordId", id);
        query.executeUpdate();
    }
}
