package org.kelompokFPJ2EE.service;

import java.util.List;

import org.kelompokFPJ2EE.domain.Member;

public interface MemberService {
	public List<Member> findAll();
    public Member findById(String username);
 
    public void addMember(Member member);
    public void editMember(Member member, String username);
    public void removeMember(String username);
    
    public boolean loginAction(String usernameLogin, String passwordLogin);
    public boolean registrationAction(String usernameRegistration, String passwordRegistration, String profileNameRegistration);
    public boolean editProfileAction(Member session, String usernameEditProfile, String oldPasswordEditProfile, String newPasswordEditProfile);
}
