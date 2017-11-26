package com.javacodegeeks.examples.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.javacodegeeks.dto.Bug;


@Service
public class BugServiceImpl implements BugService {

	private static AtomicInteger counter = new AtomicInteger();

	private static List<Bug> bugs;

	static {
		bugs = populateBugs();
	}

	@Override
	public Bug findBugById(int id) {
		for (Bug bug : bugs) {
			if (id == bug.getId()) {
				return bug;
			}
		}
		return null;
	}

	@Override
	public Bug findBugByName(String name) {
		for (Bug bug : bugs) {
			if (name.equalsIgnoreCase(bug.getName())) {
				return bug;
			}
		}
		return null;
	}

	@Override
	public void saveBug(Bug bug) {
		bug.setId(counter.incrementAndGet());
		bugs.add(bug);
	}

	@Override
	public void updateBug(Bug bug) {
		int index = bugs.indexOf(bug);
		bugs.set(index, bug);
	}

	@Override
	public void deleteBugById(int id) {
		Iterator<Bug> it = bugs.iterator();
		while (it.hasNext()) {
			Bug bug = it.next();
			if (id == bug.getId()) {
				it.remove();
			}
		}
	}

	@Override
	public List<Bug> findAllBugs() {
		return bugs;
	}

	@Override
	public void deleteAllBugs() {
		bugs.clear();
	}

	@Override
	public boolean isBugAvailable(Bug bug) {
		return findBugById(bug.getId()) != null || findBugByName(bug.getName()) != null;
	}

	private static List<Bug> populateBugs() {
		List<Bug> bugs = new ArrayList<Bug>();
		bugs.add(new Bug(counter.incrementAndGet(),"google.com", "Open", "Browser", "Medium", "Bug_desc_1", "Fahim", "v1.0.5", null,
				"Fahim2", "Fix descrp 1"));
		bugs.add(new Bug(counter.incrementAndGet(),"yahoo.com", "Hold", "Application", "High", "Bug_desc_2", "Ghole", "v1.0.10", null,
				"Ghole2", "Fix descrp 2"));
		bugs.add(new Bug(counter.incrementAndGet(),"gmail.com", "Close", "Application", "Low", "Bug_desc_3", "Dummy", "v1.1.10", null,
				"Dummy 3", "Fix descrp 3"));
		/*Bugs.add(new Bug(counter.incrementAndGet(), "Mobile", 25498.00, "google", "WIP", "Usability"));
		Bugs.add(new Bug(counter.incrementAndGet(), "Desktop", 32658.00, "google", "WIP", "Usability"));
		Bugs.add(new Bug(counter.incrementAndGet(), "Laptop", 52147.00,"google", "WIP", "Usability"));
		Bugs.add(new Bug(counter.incrementAndGet(), "Tab", 18254.00, "google", "WIP", "Usability"));*/
		return bugs;
	}

}
