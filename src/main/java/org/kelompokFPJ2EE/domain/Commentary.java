package org.kelompokFPJ2EE.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "commentary")
public class Commentary {
	@Id
	@GeneratedValue
	@Column(name = "idCommentary")
	private int idCommentary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAnswer")
	private Answer answerCommentary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usernameMember")
	private Member memberCommentary;
	
	@Column(name = "descriptionCommentary")
	private String descriptionCommentary;
	
	@Column(name = "timeCommentary")
	private Date timeCommentary;
	
	public Commentary(){}
	
	/*
	 * 
	 */
	
	public int getIdCommentary() {
		return idCommentary;
	}

	public void setIdCommentary(int idCommentary) {
		this.idCommentary = idCommentary;
	}

	public Answer getAnswerCommentary() {
		return answerCommentary;
	}

	public void setAnswerCommentary(Answer answerCommentary) {
		this.answerCommentary = answerCommentary;
	}

	public Member getMemberCommentary() {
		return memberCommentary;
	}

	public void setMemberCommentary(Member memberCommentary) {
		this.memberCommentary = memberCommentary;
	}

	public String getDescriptionCommentary() {
		return descriptionCommentary;
	}

	public void setDescriptionCommentary(String descriptionCommentary) {
		this.descriptionCommentary = descriptionCommentary;
	}

	public Date getTimeCommentary() {
		return timeCommentary;
	}

	public void setTimeCommentary(Date timeCommentary) {
		this.timeCommentary = timeCommentary;
	}
}
