package com.marakana.contacts.repositories;

import com.marakana.contacts.entities.Contact;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SERGE on 31.08.2014.
 */
public class ContactRepository {

    private final DataSource dataSource;

    public ContactRepository() {
        try {
            Context context = new InitialContext();
            try {
                dataSource = (DataSource) context.lookup("java:comp/env/jdbc/trainingdb");
            } finally {
                context.close();
            }

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

    }

    public void init() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("create table contact (id integer generated by default as identity primary key, name varchar(255), address_id integer, foreign key(address_id) constraint address)");
            }
        }
    }

    public List<Contact> findAll() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet result = statement.executeQuery("select * from contact where ")) {

                    List<Contact> contacts = new ArrayList<>();

                    while (result.next()) {
                        contacts.add(unmarshal(result));
                    }
                    return contacts;

                }

            }
        }
    }

    public Contact find(long id) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet result = statement.executeQuery("select * from contact where id = " + id)) {
                    if (!result.next()) {
                        return null;
                    } else {
                        return unmarshal(result);
                    }
                }

            }
        }

    }

    public void create(Contact contact) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("insert into contact (name, address_id) values ('"
                                + contact.getName() + "', '" + contact.getAddressId() + "')",
                        Statement.RETURN_GENERATED_KEYS);

                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    if (resultSet.next())
                        contact.setId(resultSet.getLong("id"));
                }

            }
        }
    }

    public void update(Contact contact) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("update contact set name = '"
                        + contact.getName() + "', address_id = '"
                        + contact.getAddressId() + "') where id = "
                        + contact.getId());
            }
        }
    }

    public void delete(Contact contact) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("delete from contact where id = " + contact.getId());
            }
        }
    }

    private static Contact unmarshal(ResultSet results) throws SQLException {
        Contact contact = new Contact();
        contact.setId(results.getLong("id"));
        contact.setName(results.getString("name"));
        contact.setAddressId(results.getLong("address_id"));

        return contact;
    }


}
