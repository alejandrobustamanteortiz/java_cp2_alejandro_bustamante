package com.example;

import com.example.entities.BankAccount;
import com.example.entities.Customer;
import com.example.enums.TipoCuenta;
import com.example.repositories.BankAccountRepository;
import com.example.repositories.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static com.example.enums.TipoCuenta.AHORRO;
import static com.example.enums.TipoCuenta.INVERSIONES;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);

        // CUSTOMER

        CustomerRepository customerRepository = context.getBean(CustomerRepository.class);

        Customer  customer1 = new Customer(1L, "s", null);

        customerRepository.save(customer1);


        // BANK

        BankAccountRepository bankAccountRepository = context.getBean(BankAccountRepository.class);

        BankAccount bank1 = new BankAccount(1L, 150.00, AHORRO, 200.00, 200.00, null);
        BankAccount bank2 = new BankAccount(2L, 150.00, INVERSIONES, 200.00, 200.00, null);

        bankAccountRepository.saveAll(List.of(bank1,bank2));

    }

}
