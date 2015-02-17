package org.kelompokFPJ2EE.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "questionLabel")
public class QuestionLabel {
	@Id
	@GeneratedValue
	@Column(name = "idQuestionLabel")
	private int idQuestionLabel;
	
	@Column(name = "titleQuestionLabel")
	private String titleQuestionLabel;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "questionLabelQuestionHaveLabel")
	private List<QuestionHaveLabel> questionHaveLabelQuestionLabel;
	
	public QuestionLabel(){}
	
	/*
	 * 
	 */
	
	public int getIdQuestionLabel() {
		return idQuestionLabel;
	}

	public void setIdQuestionLabel(int idQuestionLabel) {
		this.idQuestionLabel = idQuestionLabel;
	}

	public String getTitleQuestionLabel() {
		return titleQuestionLabel;
	}

	public void setTitleQuestionLabel(String titleQuestionLabel) {
		this.titleQuestionLabel = titleQuestionLabel;
	}

	public List<QuestionHaveLabel> getQuestionHaveLabelQuestionLabel() {
		return questionHaveLabelQuestionLabel;
	}

	public void setQuestionHaveLabelQuestionLabel(
			List<QuestionHaveLabel> questionHaveLabelQuestionLabel) {
		this.questionHaveLabelQuestionLabel = questionHaveLabelQuestionLabel;
	}
}
