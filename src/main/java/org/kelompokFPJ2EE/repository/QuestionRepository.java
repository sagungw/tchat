package org.kelompokFPJ2EE.repository;

import java.util.List;

import org.kelompokFPJ2EE.domain.Question;


public interface QuestionRepository {
	public List<Question> findAll();
    public Question findById(Integer idQuestion);
 
    public void addQuestion(Question question);
    public void editQuestion(Question question, Integer idQuestion);
    public void removeQuestion(Integer idQuestion);
}
