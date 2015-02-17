package org.kelompokFPJ2EE.FPJ2EE;

import javax.servlet.http.HttpSession;

import org.kelompokFPJ2EE.domain.Member;
import org.kelompokFPJ2EE.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberServ;
	
	// ---------------------- halaman login ----------------------
	@RequestMapping(value="/loginAction", method=RequestMethod.POST)
    public ModelAndView loginAction(HttpSession session, String usernameLogin, String passwordLogin) {
		ModelAndView mav = new ModelAndView();
		
		boolean flag = memberServ.loginAction(usernameLogin, passwordLogin);
		
		if(flag){
			session.setAttribute("memberSession", memberServ.findById(usernameLogin));
			mav.setViewName("redirect:/home");
		}else{
			mav.setViewName("redirect:/login");
		}
		
        return mav;
    }
	// ---------------------- end of halaman login ----------------------
	
	
	
	// ---------------------- halaman registration ----------------------
	@RequestMapping(value="/registrationAction", method=RequestMethod.POST)
    public ModelAndView registrationAction(String usernameRegistration, String passwordRegistration, String profileNameRegistration) {
		ModelAndView mav = new ModelAndView();
		
		boolean flag = memberServ.registrationAction(usernameRegistration, passwordRegistration, profileNameRegistration);
		
		if(flag) {
			mav.setViewName("redirect:/login");
		} else {
			mav.setViewName("redirect:/Registration");
		}
         
        return mav;
    }
	// ---------------------- end of halaman registration ----------------------
	
	
	// ---------------------- halaman profile edit ----------------------
	
	@RequestMapping(value="/editProfileAction", method=RequestMethod.POST)
    public ModelAndView editProfileAction(HttpSession session, String usernameEditProfile, String oldPasswordEditProfile, String newPasswordEditProfile) {
		ModelAndView mav = new ModelAndView();
		
		boolean flag = memberServ.editProfileAction((Member)session.getAttribute("memberSession"), usernameEditProfile, oldPasswordEditProfile, newPasswordEditProfile);
		
		if(flag){
			mav.setViewName("redirect:/profileAskMe");
		}else{
			mav.setViewName("redirect:/profileEdit");
		}
		
        return mav;
    }
	
	// ---------------------- end of halaman profile edit ----------------------
}
