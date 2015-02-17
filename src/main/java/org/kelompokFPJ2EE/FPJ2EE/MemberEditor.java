package org.kelompokFPJ2EE.FPJ2EE;

import java.beans.PropertyEditorSupport;

import org.kelompokFPJ2EE.domain.Member;
import org.kelompokFPJ2EE.service.MemberService;
import org.springframework.stereotype.Component;


@Component
public class MemberEditor extends PropertyEditorSupport {
	private final MemberService memberServ;
	
	public MemberEditor(){
		this.memberServ = null;
	}
	
	public MemberEditor(MemberService memberServ){
		this.memberServ = memberServ;
	}
	
	@Override
    public void setAsText(String text) throws IllegalArgumentException {
        // Find a category by its categoryId from text
        Member member = (Member)memberServ.findById(text);
        setValue(member);
    } 
	
}
