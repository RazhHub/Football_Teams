package com.sis.football_teams.controller;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sis.football_teams.model.Team;
import com.sis.football_teams.repository.TeamRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:controller-tests.xml")
public class TeamControllerTest {


	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private TeamController teamController;

	private Team team = new Team();


	@Before
	public void setup() {

		reset(teamRepository);

		team.setName("Test Team");
		team.setCity("Manchester");
		team.setOwner("Test Owner");

	}


	@Test
	public void testCreateTeam(){		
		
		replay(teamRepository);
		ResponseEntity<String> response = teamController.createTeam(team);
		verify(teamRepository);
		assertTrue(response.getBody().equalsIgnoreCase("Team Created"));
		assertTrue(response.getStatusCode() == HttpStatus.OK);
	}


	@Test
	public void getSingleTeam(){	

		expect(teamRepository.getTeamByName("Test Team")).andReturn(team);		
		replay(teamRepository);
		ResponseEntity<Team> response = teamController.getTeamByName("Test Team");
		verify(teamRepository);

		assertTrue(response.getStatusCode() == HttpStatus.OK);
		assertTrue(response.getBody().getName().equalsIgnoreCase("Test Team"));
	}
}
