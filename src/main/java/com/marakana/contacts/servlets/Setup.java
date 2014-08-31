package com.marakana.contacts.servlets;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.repositories.AddressRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class Setup implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        AddressRepository addressRepository = new AddressRepository();
        try {
            addressRepository.init();
            Address address = new Address("150 West Tasman Dr.", "San Jose", "CA", "95134");
            addressRepository.create(address);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
