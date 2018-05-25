package com.javacodegeeks.examples.service;

import java.util.List;

import com.javacodegeeks.examples.model.Ticket;

public interface TicketService {
	Ticket findTicketById(int id);

	Ticket findTicketByName(String name);

	void saveTicket(Ticket ticket);

	void updateTicket(Ticket ticket);

	void deleteTicketById(int id);

	List<Ticket> findAllTickets();

	void deleteAllTickets();

	public boolean isTicketAvailable(Ticket ticket);

	Ticket findTicketById(String ticketId);

}
