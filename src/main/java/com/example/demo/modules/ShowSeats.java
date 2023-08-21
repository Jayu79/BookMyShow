package com.example.demo.modules;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ShowSeats extends BaseModel{
     @ManyToOne
     private Show show;
     @ManyToOne
     private Seat seat;
     private SeatStatus seatStatus;
}
