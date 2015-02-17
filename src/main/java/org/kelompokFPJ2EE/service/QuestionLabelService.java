package org.kelompokFPJ2EE.service;

import java.util.List;

import org.kelompokFPJ2EE.domain.QuestionLabel;


public interface QuestionLabelService {
	public List<QuestionLabel> findAll();
    public QuestionLabel findById(Integer idQuestionLabel);
 
    public void addQuestionLabel(QuestionLabel questionLabel);
    public void editQuestionLabel(QuestionLabel questionLabel, Integer idQuestionLabel);
    public void removeQuestionLabel(Integer idQuestionLabel);
}
