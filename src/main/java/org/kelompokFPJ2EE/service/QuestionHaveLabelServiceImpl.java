package org.kelompokFPJ2EE.service;

import java.util.List;

import org.kelompokFPJ2EE.domain.QuestionHaveLabel;
import org.kelompokFPJ2EE.repository.QuestionHaveLabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionHaveLabelServiceImpl implements QuestionHaveLabelService {
	
	@Autowired
	private QuestionHaveLabelRepository questionHaveLabelRepo;
	
	@Override
	public List<QuestionHaveLabel> findAll() {
		return questionHaveLabelRepo.findAll();
	}

	@Override
	public QuestionHaveLabel findById(Integer idQuestionHaveLabel) {
		return questionHaveLabelRepo.findById(idQuestionHaveLabel);
	}

	@Override
	public void addQuestionHaveLabel(QuestionHaveLabel questionHaveLabel) {
		questionHaveLabelRepo.addQuestionHaveLabel(questionHaveLabel);
	}

	@Override
	public void removeQuestionHaveLabel(Integer idQuestionHaveLabel) {
		questionHaveLabelRepo.removeQuestionHaveLabel(idQuestionHaveLabel);
	}
}
