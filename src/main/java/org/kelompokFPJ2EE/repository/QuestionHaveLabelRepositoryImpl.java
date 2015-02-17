package org.kelompokFPJ2EE.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.kelompokFPJ2EE.domain.QuestionHaveLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class QuestionHaveLabelRepositoryImpl implements QuestionHaveLabelRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<QuestionHaveLabel> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from QuestionHaveLabel").list();
	}

	@Override
	@Transactional
	public QuestionHaveLabel findById(Integer idQuestionHaveLabel) {
		return (QuestionHaveLabel)sessionFactory.getCurrentSession().get(QuestionHaveLabel.class, idQuestionHaveLabel);
	}

	@Override
	@Transactional
	public void addQuestionHaveLabel(QuestionHaveLabel idQuestionHaveLabel) {
		sessionFactory.getCurrentSession().save(idQuestionHaveLabel);
	}

	@Override
	@Transactional
	public void removeQuestionHaveLabel(Integer idQuestionHaveLabel) {
		QuestionHaveLabel questionHaveLabelToDelete = findById(idQuestionHaveLabel);
        if(questionHaveLabelToDelete != null) {
        	sessionFactory.getCurrentSession().delete(questionHaveLabelToDelete);
        	sessionFactory.getCurrentSession().flush();
        }
	}

}
