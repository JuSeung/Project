package com.juse.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Board {
	@Id@GeneratedValue
	@Column(name="BOARD_ID")
	private Integer id;
	private String title;
	private Integer pwd;
	private String text;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	public Board() {
	}
	
	public Board(String title, Integer pwd, String text) {
		this.title = title;
		this.pwd = pwd;
		this.text = text;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
