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
@Table(name = "questionHaveLabel")
public class QuestionHaveLabel {
	@Id
	@GeneratedValue
	@Column(name = "idQuestionHaveLabel")
	private int idQuestionHaveLabel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idQuestion")
	private Question questionQuestionHaveLabel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idQuestionLabel")
	private QuestionLabel questionLabelQuestionHaveLabel;
	
	public QuestionHaveLabel(){}
	
	/*
	 * 
	 */
	
	public int getIdQuestionHaveLabel() {
		return idQuestionHaveLabel;
	}

	public void setIdQuestionHaveLabel(int idQuestionHaveLabel) {
		this.idQuestionHaveLabel = idQuestionHaveLabel;
	}

	public Question getQuestionQuestionHaveLabel() {
		return questionQuestionHaveLabel;
	}

	public void setQuestionQuestionHaveLabel(Question questionQuestionHaveLabel) {
		this.questionQuestionHaveLabel = questionQuestionHaveLabel;
	}

	public QuestionLabel getQuestionLabelQuestionHaveLabel() {
		return questionLabelQuestionHaveLabel;
	}

	public void setQuestionLabelQuestionHaveLabel(
			QuestionLabel questionLabelQuestionHaveLabel) {
		this.questionLabelQuestionHaveLabel = questionLabelQuestionHaveLabel;
	}
}
