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

import com.javacodegeeks.examples.model.Ticket;
import com.javacodegeeks.examples.service.TicketService;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public ResponseEntity<List<Ticket>> getTickets() {
		List<Ticket> tickets = ticketService.findAllTickets();
		if (tickets.isEmpty()) {
			return new ResponseEntity<List<Ticket>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
	}

	@RequestMapping(value = "/ticket", method = RequestMethod.POST)
	public ResponseEntity<Void> saveTicket(@RequestBody Ticket ticket, UriComponentsBuilder ucBuilder) {
		if (ticket == null || ticket.getName() == null || "".equals(ticket.getName())) {
			//throw new RuntimeException("Ticket Name and Price are required fields");
		}
		if (ticketService.isTicketAvailable(ticket)) {
			System.out.println("A Ticket with name " + ticket.getName() + " already exist");
			//return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		ticketService.saveTicket(ticket);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/ticket/{id}").buildAndExpand(ticket.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/ticket", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateTicket(@RequestBody Ticket ticket) {
		/*if (ticket == null || ticket.getName() == null || "".equals(ticket.getName()) || ticket.getId() <= 0) {
			throw new RuntimeException("Ticket Name, Id, Price are required fields");
		}*/
		Ticket currentTicket = ticketService.findTicketById(ticket.getId());
		if (currentTicket == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		ticketService.updateTicket(ticket);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/ticket/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Ticket> getTicketByid(@PathVariable String id) {
		Ticket ticket = ticketService.findTicketById(id);
		if (ticket == null) {
			return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}

	@RequestMapping(value = "/ticket/{name}", method = RequestMethod.GET)
	public ResponseEntity<Ticket> getTicketByName(@PathVariable String name) {
		Ticket ticket = ticketService.findTicketByName(name);
		if (ticket == null) {
			return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}

	@RequestMapping(value = "/ticket/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTicketByid(@PathVariable int id) {
		Ticket currentTicket = ticketService.findTicketById(id);

		if (currentTicket == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		ticketService.deleteTicketById(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/tickets", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTickets() {
		ticketService.deleteAllTickets();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
