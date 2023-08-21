package com.example.demo.modules;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Data
@Entity
public class Screen extends BaseModel{

    private String name;
//    @OneToMany
//    List<Seat> seats;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    List<Feature> features;

    @ManyToOne
    private Theater theater;

}
