package com.javacodegeeks.examples.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacodegeeks.examples.dal.TicketDAL;
import com.javacodegeeks.examples.model.Ticket;


@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDAL ticketDAL;
	
	@Override
	public Ticket findTicketById(int id) {
		return ticketDAL.getTicketById(id+"");
	}

	@Override
	public Ticket findTicketByName(String name) {
		return ticketDAL.getTicketByName(name);// TODO Auto-generated method stub
	}

	@Override
	public void saveTicket(Ticket ticket) {
		ticketDAL.addNewTicket(ticket);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		Ticket dbTicket = ticketDAL.getTicketById(ticket.getId());
		if(dbTicket != null) {
			ticket.setId(dbTicket.getId());
			ticketDAL.updateTicket(ticket);
		}
	}

	@Override
	public void deleteTicketById(int id) {
		
	}

	@Override
	public List<Ticket> findAllTickets() {
		return ticketDAL.getAllTickets();
	}

	@Override
	public void deleteAllTickets() {
		
	}

	@Override
	public boolean isTicketAvailable(Ticket ticket) {
		return findTicketById(ticket.getId()) != null;
	}

	@Override
	public Ticket findTicketById(String ticketId) {
		return ticketDAL.getTicketById(ticketId);
	}

}
