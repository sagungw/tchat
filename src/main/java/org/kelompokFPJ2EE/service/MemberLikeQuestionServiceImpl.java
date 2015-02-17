package org.kelompokFPJ2EE.service;

import java.util.List;

import org.kelompokFPJ2EE.domain.MemberLikeQuestion;
import org.kelompokFPJ2EE.repository.MemberLikeQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberLikeQuestionServiceImpl implements MemberLikeQuestionService {
	
	@Autowired
	private MemberLikeQuestionRepository memberLikeQuestionRepo;

	@Override
	public List<MemberLikeQuestion> findAll() {
		return memberLikeQuestionRepo.findAll();
	}

	@Override
	public MemberLikeQuestion findById(Integer idMemberLikeQuestion) {
		return memberLikeQuestionRepo.findById(idMemberLikeQuestion);
	}

	@Override
	public void addMemberLikeQuestion(MemberLikeQuestion memberLikeQuestion) {
		memberLikeQuestionRepo.addMemberLikeQuestion(memberLikeQuestion);
	}

	@Override
	public void removeMemberLikeQuestion(Integer idMemberLikeQuestion) {
		memberLikeQuestionRepo.removeMemberLikeQuestion(idMemberLikeQuestion);
	}
}
