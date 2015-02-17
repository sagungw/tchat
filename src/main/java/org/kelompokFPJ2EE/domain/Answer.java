package org.kelompokFPJ2EE.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer {
	
	@Id
	@GeneratedValue
	@Column(name = "idAnswer")
	private int idAnswer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usernameMember")
	private Member memberAnswer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idQuestion")
	private Question questionAnswer;
	
	@Column(name = "descriptionAnswer")
	private String descriptionAnswer;
	
	@Column(name = "ratingAnswer")
	private int ratingAnswer;
	
	@Column(name = "timeAnswer")
	private Date timeAnswer;
	
	@Column(name = "typeAnswer")
	private int typeAnswer;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "answerCommentary")
	private List<Commentary> commentaryAnswer;
	
	public Answer(){
		this.ratingAnswer = 0;
	}
	
	/*
	 * 
	 */
	
	public int getIdAnswer() {
		return idAnswer;
	}

	public void setIdAnswer(int idAnswer) {
		this.idAnswer = idAnswer;
	}

	public Member getMemberAnswer() {
		return memberAnswer;
	}

	public void setMemberAnswer(Member memberAnswer) {
		this.memberAnswer = memberAnswer;
	}

	public Question getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(Question questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public String getDescriptionAnswer() {
		return descriptionAnswer;
	}

	public void setDescriptionAnswer(String descriptionAnswer) {
		this.descriptionAnswer = descriptionAnswer;
	}

	public int getRatingAnswer() {
		return ratingAnswer;
	}

	public void setRatingAnswer(int ratingAnswer) {
		this.ratingAnswer = ratingAnswer;
	}

	public Date getTimeAnswer() {
		return timeAnswer;
	}

	public void setTimeAnswer(Date timeAnswer) {
		this.timeAnswer = timeAnswer;
	}

	public int getTypeAnswer() {
		return typeAnswer;
	}

	public void setTypeAnswer(int typeAnswer) {
		this.typeAnswer = typeAnswer;
	}

	public List<Commentary> getCommentaryAnswer() {
		return commentaryAnswer;
	}

	public void setCommentaryAnswer(List<Commentary> commentaryAnswer) {
		this.commentaryAnswer = commentaryAnswer;
	}
}
