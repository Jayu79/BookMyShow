package com.example.demo.modules;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
//@NoArgsConstructor
public class City extends BaseModel{

    private String name;

    @OneToMany(mappedBy = "city")
    List<Theater> theaters;

}
