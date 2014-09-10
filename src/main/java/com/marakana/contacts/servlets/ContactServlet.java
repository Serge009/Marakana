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
                long id = Long.parseLong(req.getParameter("id"));

                Contact contact = contactRepository.find(id);
                Address address = addressRepository.find(contact.getAddressId());
                req.setAttribute("contact", contact);
                req.setAttribute("address", address);

                if(req.getParameter("edit") != null){
                    req.getRequestDispatcher("jsp/editContact.jsp").forward(req, resp);

                }else if(req.getParameter("delete") != null) {


                    contactRepository.delete(contact);
                    addressRepository.delete(address);

                    resp.sendRedirect("contacts");
                } else {
                    req.getRequestDispatcher("jsp/viewContact.jsp").forward(req, resp);
                }


            }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            if (req.getParameter("add") != null) {
                Address address = new Address(req.getParameter("street"),
                        req.getParameter("city"),
                        req.getParameter("state"),
                        req.getParameter("zip"));

                addressRepository.save(address);

                Contact contact = new Contact(req.getParameter("name"), address.getId());
                contactRepository.save(contact);

                resp.sendRedirect("contact?id=" + contact.getId());
            } else if (req.getParameter("edit") != null) {
                long id = Long.parseLong(req.getParameter("id"));

                Contact contact = contactRepository.find(id);
                Address address = addressRepository.find(contact.getAddressId());

                contact.setName(req.getParameter("name"));
                address.setStreet(req.getParameter("street"));
                address.setState(req.getParameter("state"));
                address.setZip(req.getParameter("zip"));
                address.setCity(req.getParameter("city"));

                contactRepository.save(contact);
                addressRepository.save(address);

                resp.sendRedirect("contact?id=" + contact.getId());
            }  else {
                super.doPost(req, resp);
            }


    }
}
