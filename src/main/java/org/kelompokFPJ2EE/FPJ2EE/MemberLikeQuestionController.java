package org.kelompokFPJ2EE.FPJ2EE;

import javax.servlet.http.HttpSession;

import org.kelompokFPJ2EE.domain.Member;
import org.kelompokFPJ2EE.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberLikeQuestionController {
	
	@Autowired
	private QuestionService questionServ;
	
	@RequestMapping(value="/post/likesQuestionAction/{idQuestion}", method = RequestMethod.GET)
	public ModelAndView likesQuestionAction(HttpSession session, @PathVariable Integer idQuestion){
		ModelAndView mav = new ModelAndView();
		
		questionServ.likesQuestionAction((Member)session.getAttribute("memberSession"), idQuestion);
		mav.setViewName("redirect:/post/" + idQuestion);
		
		return mav;
	}
	
	@RequestMapping(value="/post/dislikesQuestionAction/{idQuestion}", method = RequestMethod.GET)
	public ModelAndView dislikesQuestionAction(HttpSession session, @PathVariable Integer idQuestion){
		ModelAndView mav = new ModelAndView();
		
		questionServ.dislikesQuestionAction((Member)session.getAttribute("memberSession"), idQuestion);
		mav.setViewName("redirect:/post/" + idQuestion);
		
		return mav;
	}
}
