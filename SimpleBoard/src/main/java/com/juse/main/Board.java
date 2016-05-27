package com.juse.main;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Board {
	@Id@GeneratedValue
	@Column(name="BOARD_ID")
	private Long id;
	private String title;
	private Integer pwd;
	private String text;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPwd() {
		return pwd;
	}
	public void setPwd(Integer pwd) {
		this.pwd = pwd;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		if(this.user != null){
			this.user.getBoards().remove(this);
		}
		this.user = user;
		user.getBoards().add(this);
	}
}
