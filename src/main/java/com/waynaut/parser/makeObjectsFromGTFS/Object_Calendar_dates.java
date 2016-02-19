package com.waynaut.parser.makeObjectsFromGTFS;

import com.waynaut.parser.model.Calendar_dates;
import com.waynaut.parser.saveCsvToSQLDatabase.MySQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static sun.plugin2.util.PojoUtil.toJson;

public class Object_Calendar_dates
{
    private Calendar_dates calendar_dates_objects[];
    private static String table_name="calendar_dates";

    public Calendar_dates[] getCalendar_datesObjects()
    {
        initialise_calendar_dates_objects();
        makeObjectsFromDatabaseTable();
        return calendar_dates_objects;
    }

    public String getCalendar_datesObjectsInJsonString()
    {
        return toJson(getCalendar_datesObjects());
    }

    public void initialise_calendar_dates_objects()
    {
        Connection conn=null;
        int rowCount=0;
        try {
            conn= MySQLConnection.getConnectionToMYSQL();
            String query="SELECT COUNT(*) FROM "+table_name;
            Statement stmt = conn.createStatement();
            stmt.executeQuery(query);
            ResultSet rslt = stmt.getResultSet();
            rslt.next();
            rowCount = rslt.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        calendar_dates_objects=new Calendar_dates[rowCount];
    }

    public void makeObjectsFromDatabaseTable()
    {
        Connection conn=null;
        try {
            conn= MySQLConnection.getConnectionToMYSQL();
            String query="SELECT * FROM "+table_name;
            executeQueryAndMakeObjects(conn, query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean executeQueryAndMakeObjects(Connection conn, String command) throws SQLException {
        Statement stmt= null;
        ResultSet rslt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeQuery(command);
            rslt=stmt.getResultSet();
            int index=0;
            while(rslt.next())
            {
                Calendar_dates calendar_dates=new Calendar_dates();
                calendar_dates.setService_id(rslt.getString("service_id"));
                calendar_dates.setDate(rslt.getString("date"));
                calendar_dates.setException_type(rslt.getString("exception_type"));
                calendar_dates_objects[index++]=calendar_dates;
            }
            return true;
        } finally {
            if (rslt != null) { rslt.close(); }
            if (stmt != null) { stmt.close(); }
        }
    }

    @Override
    public String toString()
    {
        return toJson(getCalendar_datesObjects());
    }
}
