package org.kelompokFPJ2EE.FPJ2EE;


import javax.servlet.http.HttpSession;

import org.kelompokFPJ2EE.domain.Member;
import org.kelompokFPJ2EE.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionServ;
	
	
	@RequestMapping(value="/addNewPostAction", method=RequestMethod.POST)
	public ModelAndView addNewPostAction(HttpSession session, String titleNewPost, String askingNewPost, String descriptionNewPost, String tagNewPost) {
		ModelAndView mav = new ModelAndView("redirect:/home");
		questionServ.addNewPostAction((Member)session.getAttribute("memberSession"), titleNewPost, askingNewPost, descriptionNewPost, tagNewPost);
		return mav;
	}
}
