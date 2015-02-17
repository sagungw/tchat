package org.kelompokFPJ2EE.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.kelompokFPJ2EE.domain.MemberLikeAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MemberLikeAnswerRepositoryImpl  implements MemberLikeAnswerRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<MemberLikeAnswer> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from MemberLikeAnswer").list();
	}

	@Override
	@Transactional
	public MemberLikeAnswer findById(Integer idMemberLikeAnswer) {
		return (MemberLikeAnswer)sessionFactory.getCurrentSession().get(MemberLikeAnswer.class, idMemberLikeAnswer);
	}

	@Override
	@Transactional
	public void addMemberLikeAnswer(MemberLikeAnswer idMemberLikeAnswer) {
		sessionFactory.getCurrentSession().save(idMemberLikeAnswer);
	}

	@Override
	@Transactional
	public void removeMemberLikeAnswer(Integer idMemberLikeAnswer) {
		MemberLikeAnswer memberLikeAnswerToDelete = findById(idMemberLikeAnswer);
        if(memberLikeAnswerToDelete != null) {
        	sessionFactory.getCurrentSession().delete(memberLikeAnswerToDelete);
        	sessionFactory.getCurrentSession().flush();
        }
	}

}
