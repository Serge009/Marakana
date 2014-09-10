package com.marakana.contacts.repositories;

import com.marakana.contacts.entities.Contact;

/**
 * Created by SERGE on 31.08.2014.
 */
public class ContactRepository extends Repository<Contact> {

    public ContactRepository() {
        super(Contact.class);
    }
}
