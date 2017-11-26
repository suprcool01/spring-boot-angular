package com.javacodegeeks.examples.service;

import java.util.List;

import com.javacodegeeks.dto.Project;

public interface ProjectService {
	Project findProjectById(int id);

	Project findProjectByName(String name);

	void saveProject(Project Project);

	void updateProject(Project Project);

	void deleteProjectById(int id);

	List<Project> findAllProjects();

	void deleteAllProjects();

	public boolean isProjectAvailable(Project Project);

}
