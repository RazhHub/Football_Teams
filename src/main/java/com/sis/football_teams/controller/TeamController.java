package com.sis.football_teams.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sis.football_teams.model.Team;
import com.sis.football_teams.repository.TeamRepository;


@RestController
public class TeamController {

	private static final Logger logger = LoggerFactory.getLogger(TeamController.class);

	@Autowired
	TeamRepository teamRepository;



	//--------------Great Team---------------------------
	@RequestMapping(value="/team", method = RequestMethod.POST)
	@Secured(value = {"ROLE_ADMIN"})
	public ResponseEntity<String> createTeam(@Valid @RequestBody Team body) {

		logger.info("Executing create team api with " + body.toString());
		Team team = null;

		if (!StringUtils.isEmpty(body.getName())){
			team = teamRepository.getTeamByName(body.getName());
		}else{
			return new ResponseEntity<String>("Request failed, Team name cannot be empty.", HttpStatus.BAD_REQUEST);
		}

		if(team == null){
			teamRepository.createTeam(body.getName(), body.getCity(), body.getOwner(), body.getCompetition(), body.getPlayers());
		}else {
			return new ResponseEntity<String>("Request failed, Team name already exist, please choose a different name.", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Team Created", HttpStatus.OK);

	}


	//--------------   Get Single Team By Name    ---------------------------
	@RequestMapping(value="/team/{teamName}", method = RequestMethod.GET)
	@Secured(value = { "ROLE_BASIC", "ROLE_ADMIN" })
	public ResponseEntity<Team> getTeamByName(@PathVariable("teamName") String teamName) {

		logger.info("Executing get team api with teamName: " + teamName);

		Team team = teamRepository.getTeamByName(teamName);

		return new ResponseEntity<Team>(team, HttpStatus.OK);

	}


	//--------------   List All Teams       ---------------------------
	@RequestMapping(value="/teams", method = RequestMethod.GET)
	@Secured(value = { "ROLE_BASIC", "ROLE_ADMIN" })
	public ResponseEntity<List<Team>> listAllTeams() {

		logger.info("Executing list all teams api...");
		List<Team> teams = teamRepository.listAllTeams();		

		return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);

	}
}
