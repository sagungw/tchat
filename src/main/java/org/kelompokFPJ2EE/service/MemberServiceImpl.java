package org.kelompokFPJ2EE.service;

import java.util.List;

import org.kelompokFPJ2EE.domain.Member;
import org.kelompokFPJ2EE.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Override
	public List<Member> findAll() {
		return memberRepo.findAll();
	}

	@Override
	public Member findById(String username) {
		return memberRepo.findById(username);
	}

	@Override
	public void addMember(Member member) {
		memberRepo.addMember(member);
	}

	@Override
	public void editMember(Member member, String username) {
		memberRepo.editMember(member, username);
	}

	@Override
	public void removeMember(String username) {
		memberRepo.removeMember(username);
	}
	
	/*
	 * 
	 */
	
	public boolean loginAction(String usernameLogin, String passwordLogin){
		Member member = this.findById(usernameLogin);
		
		if(member != null && member.getPasswordMember().equals(passwordLogin)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean registrationAction(String usernameRegistration, String passwordRegistration, String profileNameRegistration){
		Member member = new Member();
		
		if(usernameRegistration.equals("") || passwordRegistration.equals("") || profileNameRegistration.equals("")) {
			return false;
		} else {
			member.setUsernameMember(usernameRegistration);
			member.setPasswordMember(passwordRegistration);
			member.setProfileNameMember(profileNameRegistration);
			this.addMember(member);
			
			return true;
		}
	}
	
	@Override
	public boolean editProfileAction(Member session, String usernameEditProfile, String oldPasswordEditProfile, String newPasswordEditProfile){
		Member newMember = new Member();
		Member oldMember = session;
		
		if(oldMember.getPasswordMember().equals(oldPasswordEditProfile)){
			newMember.setPasswordMember(newPasswordEditProfile);
			newMember.setProfileNameMember(usernameEditProfile);
			newMember.setReputationMember(oldMember.getReputationMember());
			newMember.setStatusMember(oldMember.getStatusMember());
			
			this.editMember(newMember, oldMember.getUsernameMember());
			return true;
		}else{
			return false;
		}
	}
	
}
