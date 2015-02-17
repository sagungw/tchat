package org.kelompokFPJ2EE.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.kelompokFPJ2EE.domain.MemberLikeQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MemberLikeQuestionRepositoryImpl implements MemberLikeQuestionRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<MemberLikeQuestion> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from MemberLikeQuestion").list();
	}

	@Override
	@Transactional
	public MemberLikeQuestion findById(Integer idMemberLikeQuestion) {
		return (MemberLikeQuestion)sessionFactory.getCurrentSession().get(MemberLikeQuestion.class, idMemberLikeQuestion);
	}

	@Override
	@Transactional
	public void addMemberLikeQuestion(MemberLikeQuestion idMemberLikeQuestion) {
		sessionFactory.getCurrentSession().save(idMemberLikeQuestion);
	}

	@Override
	@Transactional
	public void removeMemberLikeQuestion(Integer idMemberLikeQuestion) {
		MemberLikeQuestion memberLikeQuestionToDelete = findById(idMemberLikeQuestion);
        if(memberLikeQuestionToDelete != null) {
        	sessionFactory.getCurrentSession().delete(memberLikeQuestionToDelete);
        	sessionFactory.getCurrentSession().flush();
        }
	}

}
