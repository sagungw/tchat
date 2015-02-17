package org.kelompokFPJ2EE.service;

import java.util.Date;
import java.util.List;

import org.kelompokFPJ2EE.domain.Answer;
import org.kelompokFPJ2EE.domain.Member;
import org.kelompokFPJ2EE.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	private AnswerRepository answerRepo;
	
	@Autowired
	private MemberService memberServ;
	
	@Autowired
	private QuestionService questionServ;
	
	@Override
	public List<Answer> findAll() {
		return answerRepo.findAll();
	}

	@Override
	public Answer findById(Integer idAnswer) {
		return answerRepo.findById(idAnswer);
	}

	@Override
	public void addAnswer(Answer answer) {
		answerRepo.addAnswer(answer);
	}

	@Override
	public void editAnswer(Answer answer, Integer idAnswer) {
		answerRepo.editAnswer(answer, idAnswer);
	}

	@Override
	public void removeAnswer(Integer idAnswer) {
		answerRepo.removeAnswer(idAnswer);
	}
	
	/*
	 * 
	 */
	
	@Override
	public boolean addAnswerAction(Member session, Integer idQuestionAddAnswer, Integer typeQuestionAddAnswer, String descriptionAddAnswer){
		if(descriptionAddAnswer != null){
			Answer answer = new Answer();
			answer.setMemberAnswer(session);
			answer.setQuestionAnswer(questionServ.findById(idQuestionAddAnswer));
			answer.setDescriptionAnswer(descriptionAddAnswer);
			answer.setRatingAnswer(0);
			answer.setTimeAnswer((new Date()));
			answer.setTypeAnswer(typeQuestionAddAnswer);
			
			this.addAnswer(answer);
			return true;
		}
		return false;
	}
}
