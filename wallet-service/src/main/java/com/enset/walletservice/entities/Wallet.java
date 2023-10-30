package com.enset.walletservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Wallet {
    @Id
    @GeneratedValue
    private UUID id;
    private double solde;
    private Date dateCreation;
    private String devise;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
