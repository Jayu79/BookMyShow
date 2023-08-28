package com.example.demo.DTOs;
import com.example.demo.modules.Ticket;
import lombok.Data;

@Data
public class BookTicketResponseDTO {

    private Response response;
    private Ticket ticket;

}
