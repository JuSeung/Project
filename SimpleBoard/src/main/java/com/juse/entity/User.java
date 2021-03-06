package com.juse.entity;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.juse.enums.RoleType;

/**
 * @author juseung
 * 로그인 정보
 * User Entity
 */
@Entity
public class User {
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private int id;
	
	private String name;
	private String nikname;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	@OneToMany(mappedBy="user")
	private List<Board> boards = new ArrayList<Board>();
	
	public User() {
	}
	
	public User(String name, String nikname, RoleType roleType) {
		this.name = name;
		this.nikname = nikname;
		this.roleType = roleType;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNikname() {
		return nikname;
	}
	public void setNikname(String nikname) {
		this.nikname = nikname;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public RoleType getRoleType() {
		return roleType;
	}
	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
	public List<Board> getBoards() {
		return boards;
	}
	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}
	
	
}
