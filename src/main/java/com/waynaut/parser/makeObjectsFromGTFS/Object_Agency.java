package com.waynaut.parser.makeObjectsFromGTFS;

import com.waynaut.parser.model.Agency;
import com.waynaut.parser.saveCsvToSQLDatabase.MySQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static sun.plugin2.util.PojoUtil.toJson;

public class Object_Agency
{
    private Agency agency_objects[];
    private static String table_name="agency";

    public Agency[] getAgencyObjects()
    {
        initialise_agency_objects();
        makeObjectsFromDatabaseTable();
        return agency_objects;
    }

    public String getAgencyObjectsInJsonString()
    {
        return toJson(getAgencyObjects());
    }

    public void initialise_agency_objects()
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
        agency_objects=new Agency[rowCount];
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
                Agency agency=new Agency();
                agency.setAgency_id(rslt.getString("agency_id"));
                agency.setAgency_name(rslt.getString("agency_name"));
                agency.setAgency_url(rslt.getString("agency_url"));
                agency.setAgency_timezone(rslt.getString("agency_timezone"));
                agency.setAgency_lang(rslt.getString("agency_lang"));
                agency.setAgency_phone(rslt.getString("agency_phone"));
                agency_objects[index++]=agency;
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
        return toJson(getAgencyObjects());
    }
}
