package info.inetsolv.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import info.inetsolv.Model.Ticket;

public interface TicketBookingDao extends CrudRepository<Ticket, Integer> {


	Ticket findByEmail(String email);


}
