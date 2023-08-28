package com.example.demo.Services;

import com.example.demo.Repositories.ShowRepository;
import com.example.demo.Repositories.ShowSeatRepository;
import com.example.demo.Repositories.TicketRepository;
import com.example.demo.exceptions.SeatNotAvailableException;
import com.example.demo.exceptions.ShowDoesNotExistException;
import com.example.demo.modules.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class TicketService {

    private ShowSeatRepository showSeatRepository;
    private ShowRepository showRepository;
    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(ShowSeatRepository showSeatRepository, ShowRepository showRepository,TicketRepository ticketRepository){
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
        this.ticketRepository = ticketRepository;
    }

    /*
        1. Get the list of tickets to be booked
        2. Check if all seats are available
        3. If any of the seats are unavailable, Throw an exception
        4. Lock the seats via select for update
        5. We need to check if all the seats are available since will be doing a DCL
        6. If all the seats are available then only update the status as locked
        7. else throw an exception
        8. Generate the ticket.

      These are the steps to be followed in production
     */

//    @Transactional(Isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Long> showSeatIDs,long showID, long userID) throws SeatNotAvailableException, ShowDoesNotExistException {

//        Code goes here to handle the concurrency for booking multiple tickets

//        1. Read Seats with select for update
        List<ShowSeats> showSeats = showSeatRepository.findAllByIdIn(showSeatIDs);

//        2. Check if any of the seats are unavailable
        for (ShowSeats showSeat: showSeats){
            if(!showSeat.getSeat().equals(SeatStatus.AVAILABLE)){
                throw new SeatNotAvailableException(showSeat.getId()+" is not available ");
            }
        }

//        3. Update Seat status to locked
        for(ShowSeats showSeat: showSeats){
            showSeat.setSeatStatus(SeatStatus.LOCKED);
            showSeatRepository.save(showSeat);
        }

//         Generate Ticket
        Ticket ticket = new Ticket();
        ticket.setShowSeats(showSeats);
        Optional<Show> show = showRepository.findById(showID);
        if(show.isEmpty()){
            throw new ShowDoesNotExistException("Show does not exists");
        }
        ticket.setShow(show.get());
//        Set all the other attributes of ticket
        ticket.setTicketStatus(TicketStatus.PENDING);

        return ticketRepository.save(ticket);


    }


}
