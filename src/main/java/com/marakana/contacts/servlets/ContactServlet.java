package com.marakana.contacts.servlets;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Contact;
import com.marakana.contacts.repositories.AddressRepository;
import com.marakana.contacts.repositories.ContactRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by SERGE on 31.08.2014.
 */

@WebServlet(urlPatterns = {"/contact"})
public class ContactServlet extends HttpServlet {

    private final AddressRepository addressRepository = new AddressRepository();

    private final ContactRepository contactRepository = new ContactRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("add") != null) {
            req.getRequestDispatcher("jsp/addContact.jsp").forward(req, resp);
        } else {
            //TODO
            super.doGet(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            if (req.getParameter("add") != null) {
                Address address = new Address(req.getParameter("street"),
                        req.getParameter("city"),
                        req.getParameter("state"),
                        req.getParameter("zip"));

                addressRepository.create(address);

                Contact contact = new Contact(req.getParameter("name"), address.getId());
                contactRepository.create(contact);

                resp.sendRedirect("contacts");
            } else {
                //TODO
                super.doGet(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
