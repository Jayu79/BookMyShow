package com.example.demo.modules;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SeatTypeShow extends BaseModel{

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
    @ManyToOne
    private Show show;

    double price;


}
