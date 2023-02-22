package com.customer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Issue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer issueId;
	private String issueType;
	private String description;
	private String status;
//	@OneToOne
//	private Call call;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Solution solution;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Customer customer;
	public Issue()
	{
		
	}
	public Issue(Integer issueId, String issueType, String description, String status, Call call, Solution solution,
			Customer customer) {
		super();
		this.issueId = issueId;
		this.issueType = issueType;
		this.description = description;
		this.status = status;
//		this.call = call;
		this.solution = solution;
		this.customer = customer;
	}
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	public Call getCall() {
//		return call;
//	}
//	public void setCall(Call call) {
//		this.call = call;
//	}
	public Solution getSolution() {
		return solution;
	}
	public void setSolution(Solution solution) {
		this.solution = solution;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Issue [issueId=" + issueId + ", issueType=" + issueType + ", description=" + description + ", status="
				+ status +  ", solution=" + solution + "]";
	}
	
}
