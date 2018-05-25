package com.javacodegeeks.examples.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.javacodegeeks.examples.model.Ticket;


@Repository
public class TicketDALImpl implements TicketDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Ticket> getAllTickets() {
		return mongoTemplate.findAll(Ticket.class);
	}

	@Override
	public Ticket getTicketById(String ticketId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(ticketId));
		return mongoTemplate.findOne(query, Ticket.class);
	}
	
	@Override
	public Ticket getTicketByName(String ticketName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(ticketName));
		return mongoTemplate.findOne(query, Ticket.class);
	}

	@Override
	public Ticket addNewTicket(Ticket ticket) {
		mongoTemplate.save(ticket);
		// Now, ticket object will contain the ID as well
		return ticket;
	}


	public String saveDummy() {
		Ticket us = new Ticket();
		us.setCustomer("Aamir");
		us.setDateAndTime("11/11/11");
		//mongoTemplate.save(us);
		return null;
	}
	
	
}
