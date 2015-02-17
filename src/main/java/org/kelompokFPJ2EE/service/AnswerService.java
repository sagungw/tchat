package org.kelompokFPJ2EE.service;

import java.util.List;



import org.kelompokFPJ2EE.domain.Answer;
import org.kelompokFPJ2EE.domain.Member;

public interface AnswerService {
	public List<Answer> findAll();
    public Answer findById(Integer idAnswer);
 
    public void addAnswer(Answer answer);
    public void editAnswer(Answer answer, Integer idAnswer);
    public void removeAnswer(Integer idAnswer);
    
    public boolean addAnswerAction(Member session, Integer idQuestionAddAnswer, Integer typeQuestionAddAnswer, String descriptionAddAnswer);
}
