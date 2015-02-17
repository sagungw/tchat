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
@Table(name ="memberLikeQuestion")
public class MemberLikeQuestion {
	@Id
	@GeneratedValue
	@Column(name = "idMemberLikeQuestion")
	private int idMemberLikeQuestion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idQuestion")
	private Question questionMemberLikeQuestion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usernameMember")
	private Member memberMemberLikeQuestion;
	
	@Column(name = "valueMemberLikeQuestion")
	private int valueMemberLikeQuestion;
	
	public MemberLikeQuestion(){}
	
	/*
	 * 
	 */
	
	public int getIdMemberLikeQuestion() {
		return idMemberLikeQuestion;
	}

	public void setIdMemberLikeQuestion(int idMemberLikeQuestion) {
		this.idMemberLikeQuestion = idMemberLikeQuestion;
	}

	public Question getQuestionMemberLikeQuestion() {
		return questionMemberLikeQuestion;
	}

	public void setQuestionMemberLikeQuestion(Question questionMemberLikeQuestion) {
		this.questionMemberLikeQuestion = questionMemberLikeQuestion;
	}

	public Member getMemberMemberLikeQuestion() {
		return memberMemberLikeQuestion;
	}

	public void setMemberMemberLikeQuestion(Member memberMemberLikeQuestion) {
		this.memberMemberLikeQuestion = memberMemberLikeQuestion;
	}

	public int getValueMemberLikeQuestion() {
		return valueMemberLikeQuestion;
	}

	public void setValueMemberLikeQuestion(int valueMemberLikeQuestion) {
		this.valueMemberLikeQuestion = valueMemberLikeQuestion;
	}
}
