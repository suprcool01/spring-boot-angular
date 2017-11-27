package com.javacodegeeks.examples.service;

import java.util.List;

import com.javacodegeeks.dto.Bug;

public interface BugService {

	Bug findBugById(int id);

	Bug findBugByName(String name);

	void saveBug(Bug bug);

	void updateBug(Bug bug);

	void deleteBugById(int id);

	List<Bug> findAllBugs();

	void deleteAllBugs();

	public boolean isBugAvailable(Bug bug);

	List<Bug> findAllBugs(int bugId);

}
