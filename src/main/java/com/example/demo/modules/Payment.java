package com.example.demo.modules;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Payment extends BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private PaymentMethod paymentMethod;
    private Data timeOfPayment;
    private double amount;
    private String referenceID;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    @ManyToOne
    private Ticket ticket;

}
