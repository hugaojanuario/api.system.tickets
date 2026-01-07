package spring.boot.system.tickets.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.system.tickets.entity.Ticket;
import spring.boot.system.tickets.entity.User;
import spring.boot.system.tickets.enums.StatusTicket;
import spring.boot.system.tickets.repository.TicketRepository;
import spring.boot.system.tickets.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public Ticket create(Ticket ticket) {
        ticket.setStatusTicket(StatusTicket.ABERTO);
        ticket.setResponsible(null);
        return ticketRepository.save(ticket);
    }

    public List<Ticket> listAll() {
        return ticketRepository.findAll();
    }

    public Ticket findById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public Ticket update(Long id, Ticket data) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        ticket.setTitle(data.getTitle());
        ticket.setDescription(data.getDescription());
        ticket.setApplicant(data.getApplicant());
        ticket.setResponsible(data.getResponsible());

        if (data.getStatusTicket() == StatusTicket.FECHADO) {
            if (ticket.getResponsible() == null) {
                throw new RuntimeException("Chamado não pode ser fechado sem responsável");
            }
            if (ticket.getTitle().isBlank() || ticket.getDescription().isBlank()) {
                throw new RuntimeException("Título e descrição não podem estar vazios");
            }
        }

        ticket.setStatusTicket(data.getStatusTicket());
        ticket.setUpdatedIn(LocalDateTime.now());

        return ticketRepository.save(ticket);
    }

    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }

    public List<Ticket> listByStatus(StatusTicket status) {
        return ticketRepository.findByStatusTicket(status);
    }

    public List<Ticket> listByApplicant(Long idUser) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return ticketRepository.findByApplicant(user);
    }

    public List<Ticket> listByResponsible(Long idUser) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return ticketRepository.findByResponsible(user);
    }
}
