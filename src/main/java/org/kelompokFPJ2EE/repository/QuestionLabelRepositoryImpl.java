package org.kelompokFPJ2EE.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.kelompokFPJ2EE.domain.QuestionLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class QuestionLabelRepositoryImpl implements QuestionLabelRepository {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
    @Override
    @Transactional
	public List<QuestionLabel> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from QuestionLabel").list();
	}

	@Override
	@Transactional
	public QuestionLabel findById(Integer idQuestionLabel) {
		return (QuestionLabel)sessionFactory.getCurrentSession().get(QuestionLabel.class, idQuestionLabel);
	}

	@Override
	@Transactional
	public void addQuestionLabel(QuestionLabel questionLabel) {
		sessionFactory.getCurrentSession().save(questionLabel);
	}

	@Override
	@Transactional
	public void editQuestionLabel(QuestionLabel questionLabel, Integer idQuestionLabel) {
		QuestionLabel questionLabelToUpdate = findById(idQuestionLabel);
        if(questionLabelToUpdate != null) {
        	questionLabelToUpdate.setTitleQuestionLabel(questionLabel.getTitleQuestionLabel());
        	sessionFactory.getCurrentSession().update(questionLabelToUpdate);
        	sessionFactory.getCurrentSession().flush();
        }
	}

	@Override
	@Transactional
	public void removeQuestionLabel(Integer idQuestionLabel) {
		QuestionLabel questionLabelToDelete = findById(idQuestionLabel);
        if(questionLabelToDelete != null) {
        	sessionFactory.getCurrentSession().delete(questionLabelToDelete);
            sessionFactory.getCurrentSession().flush();
        }
	}
}
