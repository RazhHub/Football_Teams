package com.sis.football_teams.repository;

import java.util.List;

import com.sis.football_teams.model.Player;
import com.sis.football_teams.model.Team;

public interface TeamRepository {

	public void createTeam(String name, String city, String owner, String competition, List<Player> players);

	public Team getTeamByName(String name);

	public List<Team> listAllTeams();

}
