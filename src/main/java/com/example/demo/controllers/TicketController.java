package com.example.demo.controllers;

import com.example.demo.DTOs.BookTicketRequestDTO;
import com.example.demo.DTOs.BookTicketResponseDTO;
import com.example.demo.DTOs.Response;
import com.example.demo.DTOs.ResponseStatus;
import com.example.demo.Services.TicketService;
import com.example.demo.exceptions.SeatNotAvailableException;
import com.example.demo.exceptions.ShowDoesNotExistException;
import com.example.demo.modules.Ticket;
import com.example.demo.modules.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController  {

    private TicketService ticketService;

    @Autowired  //Used to inject the dependency
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public BookTicketResponseDTO BookTicket(BookTicketRequestDTO requestDTO){

        try {
            Ticket ticket = ticketService.bookTicket(requestDTO.getShowSeatIDs(), requestDTO.getShowID(),requestDTO.getUserID());
            Response successResponse = new Response();
            successResponse.setStatus(ResponseStatus.SUCCESS);
            successResponse.setMessage("Ticket is created successfully");
            BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();
            responseDTO.setResponse(successResponse);
            return responseDTO;
        } catch (SeatNotAvailableException | ShowDoesNotExistException e) {
            Response errResponse = new Response();
            errResponse.setStatus(ResponseStatus.FAILED);
            errResponse.setMessage(e.getMessage());
            BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();
            responseDTO.setResponse(errResponse);
            return responseDTO;
        }

    }

}
