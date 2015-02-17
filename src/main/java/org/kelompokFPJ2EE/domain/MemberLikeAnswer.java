package org.kelompokFPJ2EE.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "memberLikeAnswer")
public class MemberLikeAnswer {
	@Id
	@GeneratedValue
	@Column(name = "idMemberLikeAnswer")
	private int idMemberLikeAnswer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usernameMember")
	private Member memberMemberLikeAnswer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAnswer")
	private Answer answerMemberLikeAnswer;
	
	@Column(name = "valueMemberLikeAnswer")
	private int valueMemberLikeAnswer;
	
	public MemberLikeAnswer(){}
	
	/*
	 * 
	 */
	
	public int getIdMemberLikeAnswer() {
		return idMemberLikeAnswer;
	}

	public void setIdMemberLikeAnswer(int idMemberLikeAnswer) {
		this.idMemberLikeAnswer = idMemberLikeAnswer;
	}

	public Member getMemberMemberLikeAnswer() {
		return memberMemberLikeAnswer;
	}

	public void setMemberMemberLikeAnswer(Member memberMemberLikeAnswer) {
		this.memberMemberLikeAnswer = memberMemberLikeAnswer;
	}

	public Answer getAnswerMemberLikeAnswer() {
		return answerMemberLikeAnswer;
	}

	public void setAnswerMemberLikeAnswer(Answer answerMemberLikeAnswer) {
		this.answerMemberLikeAnswer = answerMemberLikeAnswer;
	}

	public int getValueMemberLikeAnswer() {
		return valueMemberLikeAnswer;
	}

	public void setValueMemberLikeAnswer(int valueMemberLikeAnswer) {
		this.valueMemberLikeAnswer = valueMemberLikeAnswer;
	}
}
