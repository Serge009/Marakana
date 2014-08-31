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
        AddressRepository addressRepository = new AddressRepository();
        ContactRepository contactRepository = new ContactRepository();
        try {
            addressRepository.init();
            contactRepository.init();
/*

            addressRepository.create(new Address("150 West Tasman Dr.", "San Jose", "CA", "95134"));
            addressRepository.create(new Address("Evergreen Tr.", "Springfield", "??", "??"));

            contactRepository.create(new Contact("Serge", 0L));
            contactRepository.create(new Contact("Homer", 0L));
            contactRepository.create(new Contact("Bard", 0L));
*/

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
