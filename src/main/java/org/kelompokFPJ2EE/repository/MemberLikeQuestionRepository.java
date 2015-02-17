package org.kelompokFPJ2EE.repository;

import java.util.List;

import org.kelompokFPJ2EE.domain.MemberLikeQuestion;


public interface MemberLikeQuestionRepository {
	public List<MemberLikeQuestion> findAll();
    public MemberLikeQuestion findById(Integer idMemberLikeQuestion);
    
    public void addMemberLikeQuestion(MemberLikeQuestion memberLikeQuestion);
    public void removeMemberLikeQuestion(Integer idMemberLikeQuestion);
}
