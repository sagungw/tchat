package org.kelompokFPJ2EE.FPJ2EE;

import javax.servlet.http.HttpSession;

import org.kelompokFPJ2EE.domain.Member;
import org.kelompokFPJ2EE.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnswerController {
	
	@Autowired
	private AnswerService answerServ;
	
	@RequestMapping(value="/post/addAnswerAction", method = RequestMethod.POST)
	public ModelAndView addAnswerAction(HttpSession session, Integer idQuestionAddAnswer, Integer typeQuestionAddAnswer, String descriptionAddAnswer){
		ModelAndView mav = new ModelAndView();
		boolean flag = answerServ.addAnswerAction((Member)session.getAttribute("memberSession"), idQuestionAddAnswer, typeQuestionAddAnswer, descriptionAddAnswer);
		
		if(flag){
			mav.setViewName("redirect:/post/" + idQuestionAddAnswer);
		}else{
			mav.setViewName("/home");
		}
		
		return mav;
	}
	
}
