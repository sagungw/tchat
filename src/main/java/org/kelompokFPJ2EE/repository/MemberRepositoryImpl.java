package org.kelompokFPJ2EE.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.kelompokFPJ2EE.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	@Autowired
    private SessionFactory sessionFactory; // session factory object
	
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
	public List<Member> findAll() {
    	return sessionFactory.getCurrentSession().createQuery("from Member").list();
	}

    @Override
    @Transactional
	public Member findById(String username) {
    	return (Member)sessionFactory.getCurrentSession().get(Member.class, username);
	}

    @Override
    @Transactional
	public void addMember(Member member) {
    	sessionFactory.getCurrentSession().save(member);
	}

    @Override
    @Transactional
	public void editMember(Member member, String username) {
    	Member memberToUpdate = findById(username);
        if(memberToUpdate != null) {
        	memberToUpdate.setPasswordMember(member.getPasswordMember());
        	memberToUpdate.setProfileNameMember(member.getProfileNameMember());
            memberToUpdate.setReputationMember(member.getReputationMember());
            memberToUpdate.setStatusMember(member.getStatusMember());
            sessionFactory.getCurrentSession().update(memberToUpdate);
            sessionFactory.getCurrentSession().flush();
        }
	}

    @Override
    @Transactional
	public void removeMember(String username) {
    	Member memberToDelete = findById(username);
        if(memberToDelete != null) {
        	sessionFactory.getCurrentSession().delete(memberToDelete);
            sessionFactory.getCurrentSession().flush();
        }
	}
}
