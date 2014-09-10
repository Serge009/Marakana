package com.marakana.contacts.servlets;

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

@WebServlet(urlPatterns = {"/contacts"})
public class ContactListServlet extends HttpServlet {

    private final ContactRepository contactRepository = new ContactRepository();

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

            httpServletRequest.setAttribute("contacts", contactRepository.findAll());
            httpServletRequest.getRequestDispatcher("jsp/contacts.jsp").forward(httpServletRequest, httpServletResponse);

    }
}
