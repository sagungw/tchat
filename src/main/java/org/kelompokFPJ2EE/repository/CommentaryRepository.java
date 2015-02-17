package org.kelompokFPJ2EE.repository;

import java.util.List;

import org.kelompokFPJ2EE.domain.Commentary;


public interface CommentaryRepository {
	public List<Commentary> findAll();
    public Commentary findById(Integer idCommentary);
 
    public void addCommentary(Commentary commentary);
    public void editCommentary(Commentary commentary, Integer idCommentary);
    public void removeCommentary(Integer idCommentary);
}
