package org.kelompokFPJ2EE.FPJ2EE;

import javax.servlet.http.HttpSession;

import org.kelompokFPJ2EE.domain.Member;
import org.kelompokFPJ2EE.service.AnswerService;
import org.kelompokFPJ2EE.service.CommentaryService;
import org.kelompokFPJ2EE.service.MemberService;
import org.kelompokFPJ2EE.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentaryController {
	
	@Autowired
	private CommentaryService commentServ;
	
	@Autowired
	private MemberService memberServ;
	
	@Autowired
	private AnswerService answerServ;
	
	@Autowired
	private QuestionService questionServ;
	
	@RequestMapping(value="/post/addCommentAction", method = RequestMethod.POST)
	public ModelAndView addCommentAction(HttpSession session, Integer idQuestionAddComment, Integer idAnswerAddComment, String descriptionAddComment){
		ModelAndView mav = new ModelAndView();
		boolean flag = commentServ.addCommentAction((Member)session.getAttribute("memberSession"), idQuestionAddComment, idAnswerAddComment, descriptionAddComment);
		
		if(flag){
			mav.setViewName("redirect:/post/" + idQuestionAddComment);
		}else{
			mav.setViewName("/home");
		}
		return mav;
	}
	
}
