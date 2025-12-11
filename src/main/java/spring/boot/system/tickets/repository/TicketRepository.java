package spring.boot.system.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.system.tickets.entity.Ticket;
import spring.boot.system.tickets.entity.User;
import spring.boot.system.tickets.enums.StatusTicket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByStatusTicket(StatusTicket statusTicket);
    List<Ticket> findByApplicant(User user);
    List<Ticket> findByResponsible(User user);
}

