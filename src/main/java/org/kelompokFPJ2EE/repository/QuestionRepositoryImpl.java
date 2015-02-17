package org.kelompokFPJ2EE.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.kelompokFPJ2EE.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

	@Autowired
    private SessionFactory sessionFactory; // session factory object
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Question> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Question").list();
	}

	@Override
	@Transactional
	public Question findById(Integer idQuestion) {
		return (Question)sessionFactory.getCurrentSession().get(Question.class, idQuestion);
	}

	@Override
	@Transactional
	public void addQuestion(Question question) {
		sessionFactory.getCurrentSession().save(question);
	}

	@Override
	@Transactional
	public void editQuestion(Question question, Integer idQuestion) {
		Question questionToUpdate = findById(idQuestion);
        if(questionToUpdate != null) {
        	questionToUpdate.setAskingMemberQuestion(question.getAskingMemberQuestion());
        	questionToUpdate.setAskedMemberQuestion(question.getAskedMemberQuestion());
        	questionToUpdate.setTitleQuestion(question.getTitleQuestion());
        	questionToUpdate.setDescriptionQuestion(question.getDescriptionQuestion());
        	questionToUpdate.setRatingQuestion(question.getRatingQuestion());
        	questionToUpdate.setTimeQuestion(question.getTimeQuestion());
            sessionFactory.getCurrentSession().update(questionToUpdate);
            sessionFactory.getCurrentSession().flush();
        }
	}

	@Override
	@Transactional
	public void removeQuestion(Integer idQuestion) {
		Question questionToDelete = findById(idQuestion);
        if(questionToDelete != null) {
        	sessionFactory.getCurrentSession().delete(questionToDelete);
            sessionFactory.getCurrentSession().flush();
        }
	}

}
