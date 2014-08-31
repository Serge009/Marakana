package com.marakana.contacts.servlets;

import com.marakana.contacts.repositories.AddressRepository;
import com.marakana.contacts.repositories.ContactRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class Setup implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        AddressRepository addressRepository = new AddressRepository();
//        ContactRepository contactRepository = new ContactRepository();
        try {
            new AddressRepository().init();
            new ContactRepository().init();
//            Address address = new Address("150 West Tasman Dr.", "San Jose", "CA", "95134");
//
//            addressRepository.create(address);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
