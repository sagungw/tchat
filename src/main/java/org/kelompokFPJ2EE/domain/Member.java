package org.kelompokFPJ2EE.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "member")
public class Member {
	@Id
	@Column(name = "usernameMember")
	private String usernameMember;
	
	@Column(name = "passwordMember")
	private String passwordMember;
	
	@Column(name = "profileNameMember")
	private String profileNameMember;
	
	@Column(name = "reputationMember")
	private int reputationMember;
	
	@Column(name = "statusMember")
	private int StatusMember;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "askingMemberQuestion")
	private List<Question> questioning;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "askedMemberQuestion")
	private List<Question> questioned;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "memberMemberLikeQuestion")
	private List<MemberLikeQuestion> memberLikeQuestionMember;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "memberAnswer")
	private List<Answer> answerMember;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "memberCommentary")
	private List<Commentary> commentaryMember;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "memberMemberLikeAnswer")
	private List<MemberLikeAnswer> memberLikeAnswerMember;
	
	public Member(){}
	
	/*
	 * 
	 */
	
	public String getUsernameMember() {
		return usernameMember;
	}

	public void setUsernameMember(String usernameMember) {
		this.usernameMember = usernameMember;
	}

	public String getPasswordMember() {
		return passwordMember;
	}

	public void setPasswordMember(String passwordMember) {
		this.passwordMember = passwordMember;
	}

	public String getProfileNameMember() {
		return profileNameMember;
	}

	public void setProfileNameMember(String profileNameMember) {
		this.profileNameMember = profileNameMember;
	}

	public int getReputationMember() {
		return reputationMember;
	}

	public void setReputationMember(int reputationMember) {
		this.reputationMember = reputationMember;
	}

	public int getStatusMember() {
		return StatusMember;
	}

	public void setStatusMember(int statusMember) {
		StatusMember = statusMember;
	}

	public List<Question> getQuestioning() {
		return questioning;
	}

	public void setQuestioning(List<Question> questioning) {
		this.questioning = questioning;
	}

	public List<Question> getQuestioned() {
		return questioned;
	}

	public void setQuestioned(List<Question> questioned) {
		this.questioned = questioned;
	}

	public List<MemberLikeQuestion> getMemberLikeQuestionMember() {
		return memberLikeQuestionMember;
	}

	public void setMemberLikeQuestionMember(
			List<MemberLikeQuestion> memberLikeQuestionMember) {
		this.memberLikeQuestionMember = memberLikeQuestionMember;
	}

	public List<Answer> getAnswerMember() {
		return answerMember;
	}

	public void setAnswerMember(List<Answer> answerMember) {
		this.answerMember = answerMember;
	}

	public List<Commentary> getCommentaryMember() {
		return commentaryMember;
	}

	public void setCommentaryMember(List<Commentary> commentaryMember) {
		this.commentaryMember = commentaryMember;
	}

	public List<MemberLikeAnswer> getMemberLikeAnswerMember() {
		return memberLikeAnswerMember;
	}

	public void setMemberLikeAnswerMember(
			List<MemberLikeAnswer> memberLikeAnswerMember) {
		this.memberLikeAnswerMember = memberLikeAnswerMember;
	}
}
