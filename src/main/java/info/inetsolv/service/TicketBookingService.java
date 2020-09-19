package info.inetsolv.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import info.inetsolv.Model.Ticket;
import info.inetsolv.dao.TicketBookingDao;

@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingDao ticketBookingDao;
	
	public Ticket createTicket(Ticket ticket) {
		return ticketBookingDao.save(ticket);
	}
	public Optional<Ticket> getTicketById(Integer ticketId) {
		return ticketBookingDao.findById(ticketId);
	}
	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingDao.findAll();
	}
	public void deleteTicket(Integer ticketId) {
		ticketBookingDao.deleteById(ticketId);
	}
	public Ticket updateTicket(@RequestBody Integer ticketId, String newEmail) {
		Optional<Ticket> ticketFromDb = ticketBookingDao.findById(ticketId);
		if (ticketFromDb.isPresent()) {
			Ticket ticket = ticketFromDb.get();
			ticket.setEmail(newEmail);
			Ticket updatedTicket = ticketBookingDao.save(ticket);
			return updatedTicket;
		}
			return null;
		
	}
	public Ticket getTicketByEmail(String email) {
		return ticketBookingDao.findByEmail(email);
	}
	
}