package com.example.demo.Repositories;

import com.example.demo.modules.Ticket;
import com.example.demo.modules.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket save(Ticket ticket);
}
