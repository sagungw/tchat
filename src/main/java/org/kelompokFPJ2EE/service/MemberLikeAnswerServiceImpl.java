package org.kelompokFPJ2EE.service;

import java.util.List;

import org.kelompokFPJ2EE.domain.Answer;
import org.kelompokFPJ2EE.domain.Member;
import org.kelompokFPJ2EE.domain.MemberLikeAnswer;
import org.kelompokFPJ2EE.repository.MemberLikeAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberLikeAnswerServiceImpl implements MemberLikeAnswerService {
	
	@Autowired
	private MemberLikeAnswerRepository memberLikeAnswerRepo;
	
	@Autowired
	private AnswerService answerServ;
	
	@Override
	public List<MemberLikeAnswer> findAll() {
		return memberLikeAnswerRepo.findAll();
	}

	@Override
	public MemberLikeAnswer findById(Integer idMemberLikeAnswer) {
		return memberLikeAnswerRepo.findById(idMemberLikeAnswer);
	}

	@Override
	public void addMemberLikeAnswer(MemberLikeAnswer memberLikeAnswer) {
		memberLikeAnswerRepo.addMemberLikeAnswer(memberLikeAnswer);
	}

	@Override
	public void removeMemberLikeAnswer(Integer idMemberLikeAnswer) {
		memberLikeAnswerRepo.removeMemberLikeAnswer(idMemberLikeAnswer);
	}
	
	/*
	 * 
	 */
	
	@Override
	public void likesAnswerAction(Member session, Integer idAnswer){
		List<MemberLikeAnswer> memberLikeAnswerList = this.findAll();
		MemberLikeAnswer temp = new MemberLikeAnswer();
		temp.setIdMemberLikeAnswer(-1);
		Member memb = session;
		Answer ans = answerServ.findById(idAnswer);
		boolean flag = true;
		
		for(MemberLikeAnswer x : memberLikeAnswerList){
			if(x.getAnswerMemberLikeAnswer().getIdAnswer() == idAnswer && x.getMemberMemberLikeAnswer().getUsernameMember().equals(memb.getUsernameMember())){
				if(x.getValueMemberLikeAnswer() == 1){
					ans.setRatingAnswer(ans.getRatingAnswer() - 1);
					flag = false;
				}else{
					ans.setRatingAnswer(ans.getRatingAnswer() + 1);
					flag = true;
				}
				temp = x;
				break;
			}
		}
		
		if(flag){
			MemberLikeAnswer mla = new MemberLikeAnswer();
			mla.setMemberMemberLikeAnswer(memb);
			mla.setAnswerMemberLikeAnswer(ans);
			mla.setValueMemberLikeAnswer(1);
			this.addMemberLikeAnswer(mla);
			
			ans.setRatingAnswer(ans.getRatingAnswer() + 1);
		}
		
		if(temp.getIdMemberLikeAnswer() != -1 ){
			this.removeMemberLikeAnswer(temp.getIdMemberLikeAnswer());
		}
		
		answerServ.editAnswer(ans, ans.getIdAnswer());
	}
	
	@Override
	public void dislikesAnswerAction(Member session, Integer idAnswer){
		List<MemberLikeAnswer> memberLikeAnswerList = this.findAll();
		MemberLikeAnswer temp = new MemberLikeAnswer();
		temp.setIdMemberLikeAnswer(-1);
		Answer ans = answerServ.findById(idAnswer);
		Member memb = session;
		boolean flag = true;
		
		
		for(MemberLikeAnswer x : memberLikeAnswerList){
			if(x.getAnswerMemberLikeAnswer().getIdAnswer() == idAnswer && x.getMemberMemberLikeAnswer().getUsernameMember().equals(memb.getUsernameMember())){
				if(x.getValueMemberLikeAnswer() == 1){
					ans.setRatingAnswer(ans.getRatingAnswer() - 1);
					flag = true;
				}else{
					ans.setRatingAnswer(ans.getRatingAnswer() + 1);
					flag = false;
				}
				temp = x;
				break;
			}
		}
		
		if(flag){
			MemberLikeAnswer mla = new MemberLikeAnswer();
			mla.setMemberMemberLikeAnswer(memb);
			mla.setAnswerMemberLikeAnswer(ans);
			mla.setValueMemberLikeAnswer(0);
			this.addMemberLikeAnswer(mla);
			
			ans.setRatingAnswer(ans.getRatingAnswer() - 1);
		}
		
		if(temp.getIdMemberLikeAnswer() != -1 ){
			this.removeMemberLikeAnswer(temp.getIdMemberLikeAnswer());
		}
		
		answerServ.editAnswer(ans, ans.getIdAnswer());
	}
}
