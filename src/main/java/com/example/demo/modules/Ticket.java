package com.example.demo.modules;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Ticket {
    @ManyToOne
    private User bookedBy;
    @ManyToOne
    private Show show;
    @ManyToOne
    private List<ShowSeats> showSeats;
    private double totalAmount;
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;
    private Date timeOfBooking;
    @OneToMany(mappedBy = "ticket")
    private List<Payment> payments;

}

