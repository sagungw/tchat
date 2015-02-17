package org.kelompokFPJ2EE.service;

import java.util.Date;
import java.util.List;

import org.kelompokFPJ2EE.domain.Member;
import org.kelompokFPJ2EE.domain.MemberLikeQuestion;
import org.kelompokFPJ2EE.domain.Question;
import org.kelompokFPJ2EE.domain.QuestionHaveLabel;
import org.kelompokFPJ2EE.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private MemberService memberServ;
	
	@Autowired
	private QuestionLabelService labelServ;
	
	@Autowired
	private QuestionHaveLabelService questionHaveLabelServ;
	
	@Autowired
	private MemberLikeQuestionService memberLikeQuestionServ;

	@Override
	public List<Question> findAll() {
		return questionRepo.findAll();
	}

	@Override
	public Question findById(Integer idQuestion) {
		return questionRepo.findById(idQuestion);
	}

	@Override
	public void addQuestion(Question question) {
		questionRepo.addQuestion(question);
	}

	@Override
	public void editQuestion(Question question, Integer idQuestion) {
		questionRepo.editQuestion(question, idQuestion);
	}

	@Override
	public void removeQuestion(Integer idQuestion) {
		questionRepo.removeQuestion(idQuestion);
	}
	
	/*
	 * 
	 */
	
	@Override
	public void addNewPostAction(Member member, String titleNewPost, String askingNewPost, String descriptionNewPost, String tagNewPost){
		Question newQuestion = new Question();
		
		newQuestion.setAskingMemberQuestion(member);
		newQuestion.setAskedMemberQuestion(memberServ.findById(askingNewPost));
		newQuestion.setTitleQuestion(titleNewPost);
		newQuestion.setDescriptionQuestion(descriptionNewPost);
		newQuestion.setRatingQuestion(0);
		newQuestion.setTimeQuestion((new Date()));
		
		this.addQuestion(newQuestion);
		
		String[] labelTemp = tagNewPost.split("|");
		for(String x : labelTemp){
			if(x.equals("") || x.equals("|")){
				continue;
			}else{
				QuestionHaveLabel qhl = new QuestionHaveLabel();
				qhl.setQuestionLabelQuestionHaveLabel(labelServ.findById(Integer.parseInt(x)));
				qhl.setQuestionQuestionHaveLabel(newQuestion);
				
				questionHaveLabelServ.addQuestionHaveLabel(qhl);
			}
		}
	}
	
	@Override
	public void likesQuestionAction(Member session, Integer idQuestion){
		List<MemberLikeQuestion> memberLikeQuestionList = memberLikeQuestionServ.findAll();
		MemberLikeQuestion temp = new MemberLikeQuestion();
		temp.setIdMemberLikeQuestion(-1);
		Member memb = session;
		Question question = this.findById(idQuestion);
		boolean flag = true;
		
		for(MemberLikeQuestion x : memberLikeQuestionList){
			if(x.getQuestionMemberLikeQuestion().getIdQuestion() == idQuestion && x.getMemberMemberLikeQuestion().getUsernameMember().equals(memb.getUsernameMember())){
				if(x.getValueMemberLikeQuestion() == 1){
					question.setRatingQuestion(question.getRatingQuestion() - 1);
					flag = false;
				}else{
					question.setRatingQuestion(question.getRatingQuestion() + 1);
					flag = true;
				}
				temp = x;
				break;
			}
		}
		
		if(flag){
			MemberLikeQuestion mlq = new MemberLikeQuestion();
			mlq.setMemberMemberLikeQuestion(memb);
			mlq.setQuestionMemberLikeQuestion(question);
			mlq.setValueMemberLikeQuestion(1);
			memberLikeQuestionServ.addMemberLikeQuestion(mlq);
			
			question.setRatingQuestion(question.getRatingQuestion() + 1);
		}
		
		if(temp.getIdMemberLikeQuestion() != -1){
			memberLikeQuestionServ.removeMemberLikeQuestion(temp.getIdMemberLikeQuestion());
		}
		
		this.editQuestion(question, question.getIdQuestion());
	}
	
	@Override
	public void dislikesQuestionAction(Member session, Integer idQuestion){
		List<MemberLikeQuestion> memberLikeQuestionList = memberLikeQuestionServ.findAll();
		MemberLikeQuestion temp = new MemberLikeQuestion();
		temp.setIdMemberLikeQuestion(-1);
		Member memb = session;
		Question question = this.findById(idQuestion);
		boolean flag = true;
		
		for(MemberLikeQuestion x : memberLikeQuestionList){
			if(x.getQuestionMemberLikeQuestion().getIdQuestion() == idQuestion && x.getMemberMemberLikeQuestion().getUsernameMember().equals(memb.getUsernameMember())){
				if(x.getValueMemberLikeQuestion() == 1){
					question.setRatingQuestion(question.getRatingQuestion() - 1);
					flag = true;
				}else{
					question.setRatingQuestion(question.getRatingQuestion() + 1);
					flag = false;
				}
				temp = x;
				break;
			}
		}
		
		if(flag){
			MemberLikeQuestion mlq = new MemberLikeQuestion();
			mlq.setMemberMemberLikeQuestion(memb);
			mlq.setQuestionMemberLikeQuestion(question);
			mlq.setValueMemberLikeQuestion(0);
			memberLikeQuestionServ.addMemberLikeQuestion(mlq);
			
			question.setRatingQuestion(question.getRatingQuestion() - 1);
		}
		
		if(temp.getIdMemberLikeQuestion() != -1){
			memberLikeQuestionServ.removeMemberLikeQuestion(temp.getIdMemberLikeQuestion());
		}
		
		this.editQuestion(question, question.getIdQuestion());
	}
    
}
