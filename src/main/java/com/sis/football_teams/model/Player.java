package com.sis.football_teams.model;

import java.util.Date;

public class Player {

	private String name;
	private byte age;
	private Date dateOfBirth;
	private Positions position;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Positions getPosition() {
		return position;
	}
	public void setPosition(Positions position) {
		this.position = position;
	}

}
