package com.example.demo.modules;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Show extends BaseModel{


    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    List<Feature> features;

}
