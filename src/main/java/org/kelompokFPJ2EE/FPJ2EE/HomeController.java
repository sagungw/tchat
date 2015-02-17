package org.kelompokFPJ2EE.FPJ2EE;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.kelompokFPJ2EE.domain.Answer;
import org.kelompokFPJ2EE.domain.Member;
import org.kelompokFPJ2EE.domain.Question;
import org.kelompokFPJ2EE.domain.QuestionHaveLabel;
import org.kelompokFPJ2EE.domain.QuestionLabel;
import org.kelompokFPJ2EE.service.AnswerService;
import org.kelompokFPJ2EE.service.MemberService;
import org.kelompokFPJ2EE.service.QuestionHaveLabelService;
import org.kelompokFPJ2EE.service.QuestionLabelService;
import org.kelompokFPJ2EE.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@Autowired
	private MemberService memberServ;
	
	@Autowired
	private QuestionService questionServ;
	
	@Autowired
	private AnswerService answerServ;
	
	@Autowired
	private QuestionLabelService labelServ;
	
	@Autowired
	private QuestionHaveLabelService questionHaveLabelServ;
	
	
	// ---------------------- halaman login ----------------------
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
    public ModelAndView login(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		if(session.getAttribute("memberSession") == null){
			mav.setViewName("/Login");
		}else{
			mav.setViewName("redirect:/home");
		}
		
        return mav;
    }
	
	// ---------------------- end of halaman login ----------------------
	
	
	// ---------------------- halaman registration ----------------------
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public ModelAndView registration(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		if(session.getAttribute("memberSession") == null){
			mav.setViewName("/Registration");
		}else{
			mav.setViewName("redirect:/home");
		}
		
        return mav;
	}
	
	// ---------------------- end of halaman registration ----------------------
	
	
	// ---------------------- halaman home ----------------------
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(HttpSession session, String descriptionQuestionSearch, Integer labelQuestionSearch) {
		ModelAndView mav = new ModelAndView();
		
		if(session.getAttribute("memberSession") == null){
			mav.setViewName("redirect:/login");
		}else{
			List<QuestionLabel> labelList = labelServ.findAll();
			
			mav.addObject("member", (Member)session.getAttribute("memberSession"));
			mav.addObject("labels", labelList);
			
			
			if(labelQuestionSearch == null){
				List<Question> questionList = questionServ.findAll();
				mav.addObject("questions", questionList);
			}else{
				List<QuestionHaveLabel> questionHaveLabelList = questionHaveLabelServ.findAll();
				List<Question> questionList = new ArrayList<Question>();
				if(labelQuestionSearch == 1){
					for(QuestionHaveLabel x : questionHaveLabelList){
						if(x.getQuestionQuestionHaveLabel().getTitleQuestion().contains(descriptionQuestionSearch)){
							if(!questionList.contains(x.getQuestionQuestionHaveLabel())){
								questionList.add(x.getQuestionQuestionHaveLabel());
							}
						}
					}
				}else{
					for(QuestionHaveLabel x : questionHaveLabelList){
						if((x.getQuestionLabelQuestionHaveLabel().getIdQuestionLabel() == 1 || x.getQuestionLabelQuestionHaveLabel().getIdQuestionLabel() == labelQuestionSearch) && x.getQuestionQuestionHaveLabel().getTitleQuestion().contains(descriptionQuestionSearch)){
							if(!questionList.contains(x.getQuestionQuestionHaveLabel())){
								questionList.add(x.getQuestionQuestionHaveLabel());
							}
						}
					}
				}
				
				mav.addObject("questions", questionList);
				mav.addObject("selectedLabel", labelServ.findById(labelQuestionSearch).getIdQuestionLabel());
			}
			
			mav.setViewName("/Home");
		}
		
		return mav;
	}
	
	// ---------------------- end of halaman home ----------------------
	
	
	// ---------------------- halaman post ----------------------
	
	@RequestMapping(value="/post/{idQuestion}", method=RequestMethod.GET)
	public ModelAndView categoryEditForm(HttpSession session, @PathVariable Integer idQuestion) {
		ModelAndView mav = new ModelAndView();
		
		Question question= questionServ.findById(idQuestion);
		
		if(session.getAttribute("memberSession") == null){
			mav.setViewName("redirect:/login");
		}else{
			if(question == null){
				mav.setViewName("redirect:/home");
			} else {
				mav.addObject("question", question);
				
				mav.addObject("isAnswered", false);
				List<Answer> answerList = answerServ.findAll();
				for(Answer x : answerList){
					if(x.getQuestionAnswer().getIdQuestion() == question.getIdQuestion() && x.getTypeAnswer() == 1){
						mav.addObject("isAnswered", true);
						List<Answer> temp = new ArrayList<Answer>();
						temp.add(x);
						mav.addObject("officialAnswer", temp);
					}
				}
				
				mav.addObject("member", (Member)session.getAttribute("memberSession"));
				mav.setViewName("/Post");
			}
		}
		
		return mav;
	}
	
	// ---------------------- end of halaman post ----------------------
	
	
	// ---------------------- halaman new post ----------------------
	
	@RequestMapping(value = "/newPost", method = RequestMethod.GET)
	public ModelAndView newPost(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("memberSession") == null){
			mav.setViewName("/Login");
		}else{
			mav.addObject("member", (Member)session.getAttribute("memberSession"));
			mav.addObject("labels", labelServ.findAll());
			mav.addObject("members", memberServ.findAll());
			mav.setViewName("/NewPost");
		}
		
		return mav;
	}
	
	// ---------------------- end of halaman new post ----------------------
	
	
	// ---------------------- halaman profile edit ----------------------
	
	@RequestMapping(value = "/profileEdit", method = RequestMethod.GET)
	public ModelAndView profileEdit(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("memberSession") == null){
			mav.setViewName("redirect:/login");
		}else{
			mav.addObject("member", (Member)session.getAttribute("memberSession"));
			mav.setViewName("/ProfileEdit");
		}
		
		return mav;
	}
	
	// ---------------------- end of halaman profile edit ----------------------
		
	
	// ---------------------- halaman profile ask me ----------------------
	
	@RequestMapping(value = "/profileAskMe", method = RequestMethod.GET)
	public ModelAndView profileAskMe(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("memberSession") == null){
			mav.setViewName("redirect:/login");
		}else{
			List<Question> allQuestion = questionServ.findAll();
			List<Question> question = new ArrayList<Question>();
			Member temp = (Member)session.getAttribute("memberSession");
			
			for(Question iter : allQuestion){
				if(iter.getAskedMemberQuestion().getUsernameMember().equals(temp.getUsernameMember())){
					question.add(iter);
				}
			}
			
			mav.addObject("member", (Member)session.getAttribute("memberSession"));
			mav.addObject("questions", question);
			
			mav.setViewName("/ProfileAskMe");
		}
		
		return mav;
	}
	
	// ---------------------- end of halaman profile ask me ----------------------
		
	
	// ---------------------- halaman profile ask you ----------------------
	
	@RequestMapping(value = "/profileAskYou", method = RequestMethod.GET)
	public ModelAndView profileAskYou(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("memberSession") == null){
			mav.setViewName("redirect:/login");
		}else{
			List<Question> allQuestion = questionServ.findAll();
			List<Question> question = new ArrayList<Question>();
			Member temp = (Member)session.getAttribute("memberSession");
			
			for(Question iter : allQuestion){
				if(iter.getAskingMemberQuestion().getUsernameMember().equals(temp.getUsernameMember())){
					question.add(iter);
				}
			}
			
			mav.addObject("member", (Member)session.getAttribute("memberSession"));
			mav.addObject("questions", question);
			
			mav.setViewName("/ProfileAskYou");
		}
		
		return mav;
	}
	
	// ---------------------- end of halaman profile ask you ----------------------
	
	// ---------------------- end of logout ----------------------
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutAction(HttpSession session){
		ModelAndView mav = new ModelAndView("/Login");
		session.invalidate();
		return mav;
	}
	
	// ---------------------- end of logout ----------------------
		
}
