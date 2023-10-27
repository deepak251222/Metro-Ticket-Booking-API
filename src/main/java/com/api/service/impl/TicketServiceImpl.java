package com.api.service.impl;

import com.api.dto.TicketBookDto;
import com.api.entity.Station;
import com.api.entity.Ticket;
import com.api.exception.TicketNotFoundException;
import com.api.repo.StationRepo;
import com.api.repo.TicketRepo;
import com.api.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private StationRepo stationRepo;

    @Override
    public Ticket buyTicket(TicketBookDto ticketBookDto) {
        String sourceStation = ticketBookDto.getStartStation();
        String destinationStation = ticketBookDto.getDestinationStation();
        Station source = stationRepo.findById(sourceStation)
                .orElseThrow(() -> new TicketNotFoundException("Source station not found"));
        Station destination = stationRepo.findById(destinationStation)
                .orElseThrow(() -> new TicketNotFoundException("Destination station not found"));
        int price = Math.abs(destination.getPrice() - source.getPrice());
        Ticket ticket = new Ticket();
        ticket.setTicketId(generateRandamString());
        ticket.setSourceStation(sourceStation);
        ticket.setDestinationStation(destinationStation);
        ticket.setExpirationTime(LocalDateTime.now().plusHours(18));
        ticket.setUsagesLeft(2);
        ticket.setPrice(price);
        return ticketRepo.save(ticket);
    }
    @Override
    public String enterStation(String ticketId) {
        Ticket ticket = ticketRepo.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException("Ticket not found"));
        if (ticket.getUsagesLeft() > 0) {
            if (LocalDateTime.now().isBefore(ticket.getExpirationTime())) {
                ticket.setUsagesLeft(ticket.getUsagesLeft() - 1);
                ticketRepo.save(ticket);
                return "Entered station successfully!";
            } else {return "Ticket is Expired";}} else {
            return "Invalid ticket for entering the station.";}
    }
    @Override
    public String exitStation(String ticketId) {
        Ticket ticket = ticketRepo.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException("Ticket not found"));
        if (ticket.getUsagesLeft() > 0){
            if(LocalDateTime.now().isBefore(ticket.getExpirationTime())) {
                ticket.setUsagesLeft(ticket.getUsagesLeft() - 1);
                ticketRepo.save(ticket);
                return "Exited station successfully!";}
            else {return "Ticket is Expired";}
        } else {return "Invalid ticket for exiting the station.";}
    }
    public String generateRandamString(){
        String str = UUID.randomUUID().toString();
        return str;
    }
}
