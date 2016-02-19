package com.waynaut.parser.makeObjectsFromGTFS;

import com.waynaut.parser.model.Frequencies;
import com.waynaut.parser.saveCsvToSQLDatabase.MySQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static sun.plugin2.util.PojoUtil.toJson;

public class Object_Frequencies
{
    private Frequencies frequencies_objects[];
    private static String table_name="frequencies";

    public Frequencies[] getFrequenciesObjects()
    {
        initialise_frequencies_objects();
        makeObjectsFromDatabaseTable();
        return frequencies_objects;
    }

    public String getFrequenciesObjectsInJsonString()
    {
        return toJson(getFrequenciesObjects());
    }

    public void initialise_frequencies_objects()
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
        frequencies_objects=new Frequencies[rowCount];
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
                Frequencies frequencies=new Frequencies();
                frequencies.setTrip_id(rslt.getString("trip_id"));
                frequencies.setStart_time(rslt.getString("start_time"));
                frequencies.setEnd_time(rslt.getString("end_time"));
                frequencies.setHeadway_secs(rslt.getString("headway_secs"));
                frequencies_objects[index++]=frequencies;
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
        return toJson(getFrequenciesObjects());
    }
}
