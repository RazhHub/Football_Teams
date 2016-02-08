package com.sis.football_teams.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sis.football_teams.model.Player;
import com.sis.football_teams.model.Team;
import com.sis.football_teams.repository.TeamRepository;


@Repository
public class TeamRepositoryImpl implements TeamRepository {

	private static List<Team> teams = new ArrayList<Team>();



	@Override
	public void createTeam(String name, String city, String owner, String competition, List<Player> players) {

		Team team = new Team();		
		team.setName(name);
		team.setCity(city);
		team.setOwner(owner);
		team.setCompetition(competition);
		team.setPlayers(players);
		team.setCreatedDate(new Date());

		teams.add(team);
	}

	@Override
	public Team getTeamByName(String name) {
		for(Team team : teams){
			if(team.getName().equalsIgnoreCase(name)){
				return team;
			}
		}
		return null;
	}

	@Override
	public List<Team> listAllTeams() {
		return teams;
	}

}
