package com.example.demo.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class BookTicketRequestDTO {

    private List<Long> ShowSeatIDs;
    private long ShowID;
    private long userID;


}
