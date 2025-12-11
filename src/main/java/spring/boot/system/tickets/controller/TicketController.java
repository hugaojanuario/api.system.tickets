package spring.boot.system.tickets.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import spring.boot.system.tickets.entity.Ticket;
import spring.boot.system.tickets.enums.StatusTicket;
import spring.boot.system.tickets.service.TicketService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket create(@RequestBody Ticket ticket) {
        return ticketService.create(ticket);
    }

    @GetMapping
    public List<Ticket> listAll() {
        return ticketService.listAll();
    }

    @GetMapping("/{id}")
    public Ticket findById(@PathVariable Long id) {
        return ticketService.findById(id);
    }

    @PutMapping("/{id}")
    public Ticket update(@PathVariable Long id, @RequestBody Ticket data) {
        return ticketService.update(id, data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ticketService.delete(id);
    }

    @GetMapping("/status/{status}")
    public List<Ticket> listByStatus(@PathVariable StatusTicket status) {
        return ticketService.listByStatus(status);
    }

    @GetMapping("/applicant/{id}")
    public List<Ticket> listByApplicant(@PathVariable Long id) {
        return ticketService.listByApplicant(id);
    }

    @GetMapping("/responsible/{id}")
    public List<Ticket> listByResponsible(@PathVariable Long id) {
        return ticketService.listByResponsible(id);
    }
}
