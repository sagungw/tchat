package org.kelompokFPJ2EE.repository;

import java.util.List;

import org.kelompokFPJ2EE.domain.Member;


public interface MemberRepository {
	public List<Member> findAll();
    public Member findById(String username);
 
    public void addMember(Member member);
    public void editMember(Member member, String username);
    public void removeMember(String username);
}
