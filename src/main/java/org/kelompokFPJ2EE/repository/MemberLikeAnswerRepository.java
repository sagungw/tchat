package org.kelompokFPJ2EE.repository;

import java.util.List;

import org.kelompokFPJ2EE.domain.MemberLikeAnswer;


public interface MemberLikeAnswerRepository {
	public List<MemberLikeAnswer> findAll();
    public MemberLikeAnswer findById(Integer idMemberLikeAnswer);
    
    public void addMemberLikeAnswer(MemberLikeAnswer memberLikeAnswer);
    public void removeMemberLikeAnswer(Integer idMemberLikeAnswer);
}
