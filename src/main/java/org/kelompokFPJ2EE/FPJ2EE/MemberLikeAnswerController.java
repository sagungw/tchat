package org.kelompokFPJ2EE.FPJ2EE;

import javax.servlet.http.HttpSession;

import org.kelompokFPJ2EE.domain.Member;
import org.kelompokFPJ2EE.service.AnswerService;
import org.kelompokFPJ2EE.service.MemberLikeAnswerService;
import org.kelompokFPJ2EE.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberLikeAnswerController {
	
	@Autowired
	private MemberService memberServ;
	
	@Autowired
	private AnswerService answerServ;
	
	@Autowired
	private MemberLikeAnswerService memberLikeAnswerServ;
	
	
	@RequestMapping(value="/post/likesAnswerAction/{idAnswer}", method = RequestMethod.GET)
	public ModelAndView likesAnswerAction(HttpSession session, @PathVariable Integer idAnswer){
		ModelAndView mav = new ModelAndView("redirect:/post/"+answerServ.findById(idAnswer).getQuestionAnswer().getIdQuestion());
		memberLikeAnswerServ.likesAnswerAction((Member)session.getAttribute("memberSession"), idAnswer);
		return mav;
	}
	
	@RequestMapping(value="/post/dislikesAnswerAction/{idAnswer}", method = RequestMethod.GET)
	public ModelAndView dislikesAnswerAction(HttpSession session, @PathVariable Integer idAnswer){
		ModelAndView mav = new ModelAndView("redirect:/post/"+answerServ.findById(idAnswer).getQuestionAnswer().getIdQuestion());
		memberLikeAnswerServ.dislikesAnswerAction((Member)session.getAttribute("memberSession"), idAnswer);
		return mav;
	}
	
}
