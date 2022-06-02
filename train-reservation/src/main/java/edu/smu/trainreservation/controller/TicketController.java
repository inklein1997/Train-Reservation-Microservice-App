package edu.smu.trainreservation.controller;

import edu.smu.trainreservation.dto.Ticket;
import edu.smu.trainreservation.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RefreshScope
public class TicketController {
    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping("/tickets")
    @ResponseStatus(HttpStatus.OK)
    public List<Ticket> getAllTickets() {
        return serviceLayer.getAllTickets();
    }

    @GetMapping("/tickets/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Ticket> getTicketById(@PathVariable Integer id) {
        return serviceLayer.getTicketById(id);
    }

    @PostMapping("/tickets")
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket addTicket(@RequestBody Ticket ticket) {
        return serviceLayer.createTicket(ticket);
    }

    @PutMapping("/tickets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTicket(@RequestBody Ticket ticket, @PathVariable Integer id) {
        if (id.equals(ticket.getTicketId())) {
            serviceLayer.updateTicket(ticket);
        }
        if (ticket.getTicketId().equals(null)) {
            ticket.setTicketId(id);
            serviceLayer.updateTicket(ticket);
        }
    }

    @DeleteMapping("/tickets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTicket(@PathVariable Integer id) {
        serviceLayer.deleteTicket(id);
    }
}
