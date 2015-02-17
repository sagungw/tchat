package org.kelompokFPJ2EE.service;

import java.util.List;

import org.kelompokFPJ2EE.domain.QuestionHaveLabel;

public interface QuestionHaveLabelService {
	public List<QuestionHaveLabel> findAll();
    public QuestionHaveLabel findById(Integer idQuestionHaveLabel);
    
    public void addQuestionHaveLabel(QuestionHaveLabel questionHaveLabel);
    public void removeQuestionHaveLabel(Integer idQuestionHaveLabel);
}
