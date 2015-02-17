package org.kelompokFPJ2EE.service;

import java.util.List;

import org.kelompokFPJ2EE.domain.Commentary;
import org.kelompokFPJ2EE.domain.Member;

public interface CommentaryService {
	public List<Commentary> findAll();
    public Commentary findById(Integer idCommentary);
 
    public void addCommentary(Commentary commentary);
    public void editCommentary(Commentary commentary, Integer idCommentary);
    public void removeCommentary(Integer idCommentary);
    
    public boolean addCommentAction(Member session, Integer idQuestionAddComment, Integer idAnswerAddComment, String descriptionAddComment);
}
