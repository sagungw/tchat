package org.kelompokFPJ2EE.service;

import java.util.List;

import org.kelompokFPJ2EE.domain.Member;
import org.kelompokFPJ2EE.domain.MemberLikeAnswer;

public interface MemberLikeAnswerService {
	public List<MemberLikeAnswer> findAll();
    public MemberLikeAnswer findById(Integer idMemberLikeAnswer);
    
    public void addMemberLikeAnswer(MemberLikeAnswer memberLikeAnswer);
    public void removeMemberLikeAnswer(Integer idMemberLikeAnswer);
    
    public void likesAnswerAction(Member session, Integer idAnswer);
    public void dislikesAnswerAction(Member session, Integer idAnswer);
}
