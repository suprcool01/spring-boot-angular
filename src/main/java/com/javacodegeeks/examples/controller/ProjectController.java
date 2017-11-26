package com.javacodegeeks.examples.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.javacodegeeks.dto.Project;
import com.javacodegeeks.examples.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public ResponseEntity<List<Project>> getProjects() {
		List<Project> projects = projectService.findAllProjects();
		if (projects.isEmpty()) {
			return new ResponseEntity<List<Project>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
	}

	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public ResponseEntity<Void> saveProject(@RequestBody Project project, UriComponentsBuilder ucBuilder) {
		if (project == null || project.getName() == null || "".equals(project.getName())) {
			//throw new RuntimeException("Project Name and Price are required fields");
		}
		if (projectService.isProjectAvailable(project)) {
			System.out.println("A Project with name " + project.getName() + " already exist");
			//return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		projectService.saveProject(project);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/project/{id}").buildAndExpand(project.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/project", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateProject(@RequestBody Project project) {
		/*if (project == null || project.getName() == null || "".equals(project.getName()) || project.getId() <= 0) {
			throw new RuntimeException("Project Name, Id, Price are required fields");
		}*/
		Project currentProject = projectService.findProjectById(project.getId());
		if (currentProject == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		projectService.updateProject(project);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public ResponseEntity<Project> getProjectByid(@PathVariable int id) {
		Project project = projectService.findProjectById(id);
		if (project == null) {
			return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}

	@RequestMapping(value = "/project/{name}", method = RequestMethod.GET)
	public ResponseEntity<Project> getProjectByName(@PathVariable String name) {
		Project project = projectService.findProjectByName(name);
		if (project == null) {
			return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}

	@RequestMapping(value = "/project/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProjectByid(@PathVariable int id) {
		Project currentProject = projectService.findProjectById(id);

		if (currentProject == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		projectService.deleteProjectById(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/projects", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProjects() {
		projectService.deleteAllProjects();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
