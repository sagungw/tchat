package org.kelompokFPJ2EE.repository;

import java.util.List;

import org.kelompokFPJ2EE.domain.QuestionHaveLabel;


public interface QuestionHaveLabelRepository {
	public List<QuestionHaveLabel> findAll();
    public QuestionHaveLabel findById(Integer idQuestionHaveLabel);
    
    public void addQuestionHaveLabel(QuestionHaveLabel questionHaveLabel);
    public void removeQuestionHaveLabel(Integer idQuestionHaveLabel);
}
