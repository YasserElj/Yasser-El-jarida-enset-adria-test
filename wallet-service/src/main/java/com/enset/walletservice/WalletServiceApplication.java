package com.enset.walletservice;

import com.enset.walletservice.entities.Client;
import com.enset.walletservice.entities.Wallet;
import com.enset.walletservice.repositories.ClientRepository;
import com.enset.walletservice.repositories.WalletRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class WalletServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WalletServiceApplication.class, args);

        // Access the repositories
        ClientRepository clientRepository = context.getBean(ClientRepository.class);
        WalletRepository walletRepository = context.getBean(WalletRepository.class);

        // Create a Client
        Client client = new Client();
        client.setName("John Doe");
        client.setEmail("john.doe@example.com");

        // Create a Wallet
        Wallet wallet = new Wallet();
        wallet.setId(UUID.randomUUID());
        wallet.setSolde(1000.0);
        wallet.setDateCreation(new Date());
        wallet.setDevise("USD");
        wallet.setClient(client);

        // Save the Client and Wallet to the database
        clientRepository.save(client);
        walletRepository.save(wallet);

        // Fetch the Client and its Wallets
        Client fetchedClient = clientRepository.findById(client.getId()).orElse(null);
        List<Wallet> clientWallets = fetchedClient.getWallets();

        // Display the Client and Wallet information
        System.out.println("Client: " + fetchedClient.getName());
        System.out.println("Wallets for the Client:");
        for (Wallet w : clientWallets) {
            System.out.println("Wallet ID: " + w.getId());
            System.out.println("Solde: " + w.getSolde());
            System.out.println("Date de création: " + w.getDateCreation());
            System.out.println("Devise: " + w.getDevise());
        }

        // Close the application context
        context.close();
    }
}