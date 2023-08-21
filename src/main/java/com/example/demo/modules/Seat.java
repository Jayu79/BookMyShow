package com.example.demo.modules;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Scanner;

@Data
@Entity
public class Seat extends BaseModel{

    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    private String name;
    private int row;
    private int column;
    @ManyToOne
    private Screen screen;
}
