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

import com.javacodegeeks.dto.Bug;
import com.javacodegeeks.examples.service.BugService;


@RestController
public class BugController {

	@Autowired
	private BugService bugService;

	@RequestMapping(value = "/bugs", method = RequestMethod.GET)
	public ResponseEntity<List<Bug>> getBugs() {
		List<Bug> bugs = bugService.findAllBugs();
		if (bugs.isEmpty()) {
			return new ResponseEntity<List<Bug>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Bug>>(bugs, HttpStatus.OK);
	}

	@RequestMapping(value = "/bug", method = RequestMethod.POST)
	public ResponseEntity<Void> saveBug(@RequestBody Bug bug, UriComponentsBuilder ucBuilder) {
		if (bug == null || bug.getName() == null || "".equals(bug.getName())) {
			//throw new RuntimeException("Bug Name and Price are required fields");
		}
		if (bugService.isBugAvailable(bug)) {
			System.out.println("A Bug with name " + bug.getName() + " already exist");
			//return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		bugService.saveBug(bug);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/bug/{id}").buildAndExpand(bug.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/bug", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateBug(@RequestBody Bug bug) {
		/*if (Bug == null || pBug.getName() == null || "".equals(pBug.getName()) || pBug.getId() <= 0) {
			throw new RuntimeException("Bug Name, Id, Price are required fields");
		}*/
		Bug currentBug = bugService.findBugById(bug.getId());
		if (currentBug == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		bugService.updateBug(bug);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/bug/{id}", method = RequestMethod.GET)
	public ResponseEntity<Bug> getBugByid(@PathVariable int id) {
		Bug bug = bugService.findBugById(id);
		if (bug == null) {
			return new ResponseEntity<Bug>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Bug>(bug, HttpStatus.OK);
	}

	@RequestMapping(value = "/bug/{name}", method = RequestMethod.GET)
	public ResponseEntity<Bug> getBugByName(@PathVariable String name) {
		Bug bug = bugService.findBugByName(name);
		if (bug == null) {
			return new ResponseEntity<Bug>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Bug>(bug, HttpStatus.OK);
	}

	@RequestMapping(value = "/bug/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBugByid(@PathVariable int id) {
		Bug currentBug = bugService.findBugById(id);

		if (currentBug == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		bugService.deleteBugById(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/bugs", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBugs() {
		bugService.deleteAllBugs();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
