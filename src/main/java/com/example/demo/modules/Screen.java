package com.example.demo.modules;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Data
@Entity
@Table(name = "screens")
public class Screen extends BaseModel{

    private String name;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "feature_ordinal")
    List<Feature> features;

    @ManyToOne
    private Theater theater;

}
