package org.kelompokFPJ2EE.service;

import java.util.List;

import org.kelompokFPJ2EE.domain.MemberLikeQuestion;

public interface MemberLikeQuestionService {
	public List<MemberLikeQuestion> findAll();
    public MemberLikeQuestion findById(Integer idMemberLikeQuestion);
    
    public void addMemberLikeQuestion(MemberLikeQuestion memberLikeQuestion);
    public void removeMemberLikeQuestion(Integer idMemberLikeQuestion);
}
