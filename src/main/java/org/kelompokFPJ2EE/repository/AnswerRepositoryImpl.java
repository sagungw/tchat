package org.kelompokFPJ2EE.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.kelompokFPJ2EE.domain.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AnswerRepositoryImpl implements AnswerRepository{
	@Autowired
    private SessionFactory sessionFactory; // session factory object
	
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
	public List<Answer> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Answer").list();
	}

    @Override
    @Transactional
	public Answer findById(Integer idAnswer) {
		return (Answer)sessionFactory.getCurrentSession().get(Answer.class, idAnswer);
	}

    @Override
    @Transactional
	public void addAnswer(Answer answer) {
    	sessionFactory.getCurrentSession().save(answer);
	}

    @Override
    @Transactional
	public void editAnswer(Answer answer, Integer idAnswer) {
    	Answer answerToEdit = findById(idAnswer);
        if(answerToEdit != null) {
        	answerToEdit.setMemberAnswer(answer.getMemberAnswer());
        	answerToEdit.setQuestionAnswer(answer.getQuestionAnswer());
        	answerToEdit.setDescriptionAnswer(answer.getDescriptionAnswer());
        	answerToEdit.setRatingAnswer(answer.getRatingAnswer());
        	answerToEdit.setTimeAnswer(answer.getTimeAnswer());
        	answerToEdit.setTypeAnswer(answer.getTypeAnswer());
        	sessionFactory.getCurrentSession().update(answerToEdit);
        	sessionFactory.getCurrentSession().flush();
        }
	}

    @Override
    @Transactional
	public void removeAnswer(Integer idAnswer) {
    	Answer answerToRemove = findById(idAnswer);
        if(answerToRemove != null) {
        	sessionFactory.getCurrentSession().delete(answerToRemove);
        	sessionFactory.getCurrentSession().flush();
        }
	}

}
