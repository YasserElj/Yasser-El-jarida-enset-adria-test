package com.enset.transferservice.entities;

import com.enset.transferservice.model.Wallet;
import com.enset.transferservice.enums.TransferStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @Transient
    private Wallet sourceWallet;
    @Transient
    private Wallet destinationWallet;
    private double amount;
    private TransferStatus status;

    @OneToMany(mappedBy = "sourceWallet")
    private List<Transfer> outgoingTransfers;

    @OneToMany(mappedBy = "destinationWallet")
    private List<Transfer> incomingTransfers;


}