package org.kelompokFPJ2EE.service;

import java.util.Date;
import java.util.List;

import org.kelompokFPJ2EE.domain.Commentary;
import org.kelompokFPJ2EE.domain.Member;
import org.kelompokFPJ2EE.repository.CommentaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaryServiceImpl implements CommentaryService {
	
	@Autowired
	private CommentaryRepository commentaryRepo;
	
	@Autowired
	private MemberService memberServ;
	
	@Autowired
	private AnswerService answerServ;
	
	@Autowired
	private QuestionService questionServ;
	
	@Override
	public List<Commentary> findAll() {
		return commentaryRepo.findAll();
	}

	@Override
	public Commentary findById(Integer idCommentary) {
		return commentaryRepo.findById(idCommentary);
	}

	@Override
	public void addCommentary(Commentary commentary) {
		commentaryRepo.addCommentary(commentary);
	}

	@Override
	public void editCommentary(Commentary commentary, Integer idCommentary) {
		commentaryRepo.editCommentary(commentary, idCommentary);
	}

	@Override
	public void removeCommentary(Integer idCommentary) {
		commentaryRepo.removeCommentary(idCommentary);
	}
	
	/*
	 * 
	 */
	
	public boolean addCommentAction(Member session, Integer idQuestionAddComment, Integer idAnswerAddComment, String descriptionAddComment){
		if(descriptionAddComment != null){
			Commentary comment = new Commentary();
			comment.setMemberCommentary(session);
			comment.setAnswerCommentary(answerServ.findById(idAnswerAddComment));
			comment.setDescriptionCommentary(descriptionAddComment);
			comment.setTimeCommentary((new Date()));
			
			this.addCommentary(comment);
			return true;
		}
		return false;
	}
}
