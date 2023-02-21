package com.customer.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Solution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer solutionId;
	private String description;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Issue issue;
	public Solution()
	{
		
	}
	public Solution(Integer solutionId, String description, LocalDate date, Issue issue) {
		super();
		this.solutionId = solutionId;
		this.description = description;
		this.date = date;
		this.issue = issue;
	}
	public Integer getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(Integer solutionId) {
		this.solutionId = solutionId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Issue getIssue() {
		return issue;
	}
	public void setIssue(Issue issue) {
		this.issue = issue;
	}
	@Override
	public String toString() {
		return "Solution [solutionId=" + solutionId + ", description=" + description + ", issue=" + issue
				+  "]";
	}
	
}
