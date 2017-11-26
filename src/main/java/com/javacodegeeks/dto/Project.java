package com.javacodegeeks.dto;

import java.util.List;

public class Project {

	private int id;
	private String name;
	private String description;
	private List<Bug> bugs;
	
	public Project(){
		
	}
	
	public Project(int id, String name, String description, List<Bug> bugs) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.bugs = bugs;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Bug> getBugs() {
		return bugs;
	}
	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}
	
	
}
