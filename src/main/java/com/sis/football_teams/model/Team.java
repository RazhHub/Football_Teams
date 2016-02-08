package com.sis.football_teams.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sis.football_teams.util.TeamDateSerializer;

public class Team {

	@NotNull(message="Name cannot be empty")
	private String name;
	private String city;
	private String owner;
	private String competition;
	private List<Player> players;
	private Date createdDate;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getCompetition() {
		return competition;
	}
	public void setCompetition(String competition) {
		this.competition = competition;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public Date getCreatedDate() {
		return createdDate;
	}

	@JsonSerialize(using = TeamDateSerializer.class)
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	@Override
	public String toString() {
		return "Team [name=" + name + ", city=" + city + ", owner=" + owner
				+ ", competition=" + competition + ", players=" + players
				+ ", createdDate=" + createdDate + "]";
	}

}
