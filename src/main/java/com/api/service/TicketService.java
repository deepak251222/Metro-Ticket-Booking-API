package com.api.service;

import com.api.dto.TicketBookDto;
import com.api.entity.Ticket;


public interface TicketService {

    public Ticket buyTicket(TicketBookDto ticketBookDto);
    public String enterStation(String ticketId);
    public String exitStation(String ticketId);
}
