package org.kelompokFPJ2EE.service;

import java.util.List;

import org.kelompokFPJ2EE.domain.Member;
import org.kelompokFPJ2EE.domain.Question;

public interface QuestionService {
	public List<Question> findAll();
    public Question findById(Integer idQuestion);
 
    public void addQuestion(Question question);
    public void editQuestion(Question question, Integer idQuestion);
    public void removeQuestion(Integer idQuestion);
    
    public void addNewPostAction(Member session, String titleNewPost, String askingNewPost, String descriptionNewPost, String tagNewPost);
    public void likesQuestionAction(Member session, Integer idQuestion);
    public void dislikesQuestionAction(Member session, Integer idQuestion);
    
    
}
