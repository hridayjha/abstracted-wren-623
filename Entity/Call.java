package com.customer.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

//@Entity
public class Call {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer callId;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
	private Double duration;
	private String mobile;
	@OneToOne
	private Operator operator;
	@OneToOne
	private Issue issue;
	public Call()
	{
		
	}
	public Call(Integer callId, LocalDate date, Double duration, String mobile, Operator operator, Issue issue) {
		super();
		this.callId = callId;
		this.date = date;
		this.duration = duration;
		this.mobile = mobile;
		this.operator = operator;
		this.issue = issue;
	}
	public Integer getCallId() {
		return callId;
	}
	public void setCallId(Integer callId) {
		this.callId = callId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Issue getIssue() {
		return issue;
	}
	public void setIssue(Issue issue) {
		this.issue = issue;
	}
	@Override
	public String toString() {
		return "Call [callId=" + callId + ", duration=" + duration + ", mobile=" + mobile + ", operator=" + operator
				+ ", issue=" +  "]";
	}
	
}
