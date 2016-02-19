package com.waynaut.parser.saveCsvToSQLDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MySQLConnection
{
    private static final String userName = "root";
    private static final String password = "";
    private static final String serverName = "localhost";
    private static final int portNumber = 3306;
    private static final String dbName = "GTFS";

    private static Connection conn = null;

    public static Connection getConnectionToMYSQL() throws SQLException
    {
        if(conn!=null)
        {
            return conn;
        }

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        Properties connectionProps = new Properties();
        connectionProps.put("user", userName);
        connectionProps.put("password", password);
        conn = DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + portNumber ,
                connectionProps);
        Statement s = conn.createStatement();
        s.executeUpdate("CREATE DATABASE IF NOT EXISTS "+dbName);
        s.executeUpdate("USE "+dbName);
        return conn;
    }
}
