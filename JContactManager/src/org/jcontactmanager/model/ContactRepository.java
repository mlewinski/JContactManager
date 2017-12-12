package org.jcontactmanager.model;

import java.nio.file.*;
import java.sql.*;
import java.io.*;
import java.util.*;


public class ContactRepository {

    private static Connection getConnection() throws SQLException, IOException{
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get(".","resources", "database.properties").normalize())){
            props.load(in);
        }
        String drivers = props.getProperty("jdbc.drivers");
        if(drivers!=null) System.setProperty("jdbc.drivers", drivers);
        String url = props.getProperty("jdbc.url");
        String uname = props.getProperty("jdbc.username");
        String pass = props.getProperty("jdbc.password");
        return DriverManager.getConnection(url, uname, pass);
    }
}
