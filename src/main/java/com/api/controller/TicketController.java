package com.api.controller;

import com.api.dto.TicketBookDto;
import com.api.entity.Station;
import com.api.entity.Ticket;
import com.api.repo.StationRepo;
import com.api.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketServiceImpl ticketService;

    @Autowired
    private StationRepo stationRepo;

    //Station
    // For creating station i did not make any service just calling by stationRepo
    @PostMapping("/createStation")
    public ResponseEntity<Station> CreateStation(@RequestBody Station station) {
        Station station1 =stationRepo.save(station);
        return ResponseEntity.status(HttpStatus.CREATED).body(station1);
    }
    @GetMapping("/station")
    public ResponseEntity <?> getStation() {
        List<Station> station1 =stationRepo.findAll();
        Map<String,Object> map = new HashMap<>();
        map.put("Station",station1);
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    // Booking Operation

    @PostMapping("/buy")
    public ResponseEntity<Ticket> buyTicket(@RequestBody TicketBookDto ticketBookDto) {
        Ticket ticket = ticketService.buyTicket(ticketBookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
    }

    @GetMapping("/enter/{ticketId}")
    public ResponseEntity<String> enterStation(@PathVariable String ticketId) {
        String message = ticketService.enterStation(ticketId);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/exit/{ticketId}")
    public ResponseEntity<String> exitStation(@PathVariable String ticketId) {
        String message = ticketService.exitStation(ticketId);
        return ResponseEntity.ok(message);
    }


}
