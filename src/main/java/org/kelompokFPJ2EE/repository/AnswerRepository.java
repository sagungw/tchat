package org.kelompokFPJ2EE.repository;

import java.util.List;

import org.kelompokFPJ2EE.domain.Answer;


public interface AnswerRepository {
	public List<Answer> findAll();
    public Answer findById(Integer idAnswer);
 
    public void addAnswer(Answer answer);
    public void editAnswer(Answer answer, Integer idAnswer);
    public void removeAnswer(Integer idAnswer);
}
