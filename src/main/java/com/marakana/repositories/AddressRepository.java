package com.marakana.repositories;

import com.marakana.contacts.Address;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by SERGE on 31.08.2014.
 */
public class AddressRepository {

    private final DataSource dataSource;

    public AddressRepository() {
        try {
            Context context = new InitialContext();
            try {
                this.dataSource = (DataSource) context.lookup("java:comp/env/jdbc/trainingdb");
            } finally {
                context.close();
            }

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

    }

    public void init(){

    }

    public Address find(long id){
        return null; //TODO
    }

    public void create(Address address){

    }

    public void delete(Address address){

    }



}
