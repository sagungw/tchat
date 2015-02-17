package org.kelompokFPJ2EE.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.kelompokFPJ2EE.domain.Commentary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CommentaryRepositoryImpl implements CommentaryRepository {
	@Autowired
    private SessionFactory sessionFactory; // session factory object
	
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
	public List<Commentary> findAll() {
    	return sessionFactory.getCurrentSession().createQuery("from Commentary").list();
	}

    @Override
    @Transactional
	public Commentary findById(Integer idCommentary) {
    	return (Commentary)sessionFactory.getCurrentSession().get(Commentary.class, idCommentary);
	}

    @Override
    @Transactional
	public void addCommentary(Commentary commentary) {
		sessionFactory.getCurrentSession().save(commentary);
		
	}

    @Override
    @Transactional
	public void editCommentary(Commentary commentary, Integer idCommentary) {
    	Commentary commentaryToUpdate = findById(idCommentary);
        if(commentaryToUpdate != null) {
        	commentaryToUpdate.setMemberCommentary(commentary.getMemberCommentary());
        	commentaryToUpdate.setAnswerCommentary(commentary.getAnswerCommentary());
        	commentaryToUpdate.setDescriptionCommentary(commentary.getDescriptionCommentary());
        	commentaryToUpdate.setTimeCommentary(commentary.getTimeCommentary());
        	sessionFactory.getCurrentSession().update(commentaryToUpdate);
        	sessionFactory.getCurrentSession().flush();
        }
		
	}

    @Override
    @Transactional
	public void removeCommentary(Integer idCommentary) {
    	Commentary commentaryToDelete = findById(idCommentary);
        if(commentaryToDelete != null) {
        	sessionFactory.getCurrentSession().delete(idCommentary);
            sessionFactory.getCurrentSession().flush();
        }
	}

}
