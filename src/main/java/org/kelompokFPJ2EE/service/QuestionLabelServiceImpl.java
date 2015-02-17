package org.kelompokFPJ2EE.service;

import java.util.List;

import org.kelompokFPJ2EE.domain.QuestionLabel;
import org.kelompokFPJ2EE.repository.QuestionLabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionLabelServiceImpl implements QuestionLabelService {
	
	@Autowired
	private QuestionLabelRepository questionLabelRepo;
	
	@Override
	public List<QuestionLabel> findAll() {
		return questionLabelRepo.findAll();
	}

	@Override
	public QuestionLabel findById(Integer idQuestionLabel) {
		return questionLabelRepo.findById(idQuestionLabel);
	}

	@Override
	public void addQuestionLabel(QuestionLabel questionLabel) {
		questionLabelRepo.addQuestionLabel(questionLabel);
	}

	@Override
	public void editQuestionLabel(QuestionLabel questionLabel, Integer idQuestionLabel) {
		questionLabelRepo.editQuestionLabel(questionLabel, idQuestionLabel);
	}

	@Override
	public void removeQuestionLabel(Integer idQuestionLabel) {
		questionLabelRepo.removeQuestionLabel(idQuestionLabel);
	}

}
