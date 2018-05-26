package com.javacodegeeks.examples.dal;

import java.util.List;

import com.javacodegeeks.examples.model.Ticket;

public interface TicketDAL {

	Ticket getTicketById(String ticketId);

	Ticket addNewTicket(Ticket ticket);

	List<Ticket> getAllTickets();

	Ticket getTicketByName(String ticketName);

	Ticket updateTicket(Ticket ticket);
	
}
