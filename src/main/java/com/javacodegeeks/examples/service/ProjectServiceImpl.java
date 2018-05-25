package com.javacodegeeks.examples.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacodegeeks.dto.Project;
import com.javacodegeeks.examples.dal.UserDAL;


@Service
public class ProjectServiceImpl implements ProjectService {

	private static AtomicInteger counter = new AtomicInteger();

	private static List<Project> projects;

	@Autowired
	private BugService bugService;
	
	@Autowired
	private UserDAL userDAL;
	
	static {
		projects = populateProjects();
	}

	@Override
	public Project findProjectById(int id) {
		for (Project project : projects) {
			if (id == project.getId()) {
				project.setBugs(bugService.findAllBugs(id));
				return project;
			}
		}
		return null;
	}

	@Override
	public Project findProjectByName(String name) {
		for (Project project : projects) {
			if (name.equalsIgnoreCase(project.getName())) {
				return project;
			}
		}
		return null;
	}

	@Override
	public void saveProject(Project project) {
		project.setId(counter.incrementAndGet());
		projects.add(project);
	}

	@Override
	public void updateProject(Project project) {
		int index = projects.indexOf(project);
		projects.set(index, project);
	}

	@Override
	public void deleteProjectById(int id) {
		Iterator<Project> it = projects.iterator();
		while (it.hasNext()) {
			Project project = it.next();
			if (id == project.getId()) {
				it.remove();
			}
		}
	}

	@Override
	public List<Project> findAllProjects() {
		return projects;
	}

	@Override
	public void deleteAllProjects() {
		projects.clear();
	}

	@Override
	public boolean isProjectAvailable(Project project) {
		return findProjectById(project.getId()) != null || findProjectByName(project.getName()) != null;
	}

	private static List<Project> populateProjects() {
		List<Project> projects = new ArrayList<Project>();
		projects.add(new Project(counter.incrementAndGet(), "Project1", "Project1 Desc", null));
		projects.add(new Project(counter.incrementAndGet(), "Project2", "Project2 Desc", null));
		projects.add(new Project(counter.incrementAndGet(), "Project3", "Project3 Desc", null));
		/*projects.add(new Project(counter.incrementAndGet(),"google.com", "Open", "Browser", "Medium", "Bug_desc_1", "Fahim", "v1.0.5", null,
				"Fahim2", "Fix descrp 1"));
		projects.add(new Project(counter.incrementAndGet(),"yahoo.com", "Hold", "Application", "High", "Bug_desc_2", "Ghole", "v1.0.10", null,
				"Ghole2", "Fix descrp 2"));
		projects.add(new Project(counter.incrementAndGet(),"gmail.com", "Close", "Application", "Low", "Bug_desc_3", "Dummy", "v1.1.10", null,
				"Dummy 3", "Fix descrp 3"));*/
		/*projects.add(new Project(counter.incrementAndGet(), "Mobile", 25498.00, "google", "WIP", "Usability"));
		projects.add(new Project(counter.incrementAndGet(), "Desktop", 32658.00, "google", "WIP", "Usability"));
		projects.add(new Project(counter.incrementAndGet(), "Laptop", 52147.00,"google", "WIP", "Usability"));
		projects.add(new Project(counter.incrementAndGet(), "Tab", 18254.00, "google", "WIP", "Usability"));*/
		return projects;
	}

}
