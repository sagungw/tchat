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
@Table(name = "question")
public class Question {
	@Id
	@GeneratedValue
	@Column(name = "idQuestion")
	private int idQuestion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usernameMember")
	private Member askingMemberQuestion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mem_usernameMember")
	private Member askedMemberQuestion;
	
	@Column(name = "titleQuestion")
	private String titleQuestion;
	
	@Column(name = "descriptionQuestion")
	private String descriptionQuestion;
	
	@Column(name = "ratingQuestion")
	private int ratingQuestion;
	
	@Column(name = "timeQuestion")
	private Date timeQuestion;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "questionQuestionHaveLabel")
	private List<QuestionHaveLabel> questionHaveLabelQuestion;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "questionAnswer")
	private List<Answer> answerQuestion;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "questionMemberLikeQuestion")
	private List<MemberLikeQuestion> memberLikeQuestionQuestion;
	
	public Question(){}
	
	/*
	 * 
	 */
	
	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public Member getAskingMemberQuestion() {
		return askingMemberQuestion;
	}

	public void setAskingMemberQuestion(Member askingMemberQuestion) {
		this.askingMemberQuestion = askingMemberQuestion;
	}

	public Member getAskedMemberQuestion() {
		return askedMemberQuestion;
	}

	public void setAskedMemberQuestion(Member askedMemberQuestion) {
		this.askedMemberQuestion = askedMemberQuestion;
	}

	public String getTitleQuestion() {
		return titleQuestion;
	}

	public void setTitleQuestion(String titleQuestion) {
		this.titleQuestion = titleQuestion;
	}

	public String getDescriptionQuestion() {
		return descriptionQuestion;
	}

	public void setDescriptionQuestion(String descriptionQuestion) {
		this.descriptionQuestion = descriptionQuestion;
	}

	public int getRatingQuestion() {
		return ratingQuestion;
	}

	public void setRatingQuestion(int ratingQuestion) {
		this.ratingQuestion = ratingQuestion;
	}

	public Date getTimeQuestion() {
		return timeQuestion;
	}

	public void setTimeQuestion(Date timeQuestion) {
		this.timeQuestion = timeQuestion;
	}

	public List<QuestionHaveLabel> getQuestionHaveLabelQuestion() {
		return questionHaveLabelQuestion;
	}

	public void setQuestionHaveLabelQuestion(
			List<QuestionHaveLabel> questionHaveLabelQuestion) {
		this.questionHaveLabelQuestion = questionHaveLabelQuestion;
	}

	public List<Answer> getAnswerQuestion() {
		return answerQuestion;
	}

	public void setAnswerQuestion(List<Answer> answerQuestion) {
		this.answerQuestion = answerQuestion;
	}

	public List<MemberLikeQuestion> getMemberLikeQuestionQuestion() {
		return memberLikeQuestionQuestion;
	}

	public void setMemberLikeQuestionQuestion(
			List<MemberLikeQuestion> memberLikeQuestionQuestion) {
		this.memberLikeQuestionQuestion = memberLikeQuestionQuestion;
	}
}
