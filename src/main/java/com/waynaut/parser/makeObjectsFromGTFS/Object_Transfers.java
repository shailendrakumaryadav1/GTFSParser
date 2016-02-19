package com.waynaut.parser.makeObjectsFromGTFS;

import com.waynaut.parser.model.Transfers;
import com.waynaut.parser.saveCsvToSQLDatabase.MySQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static sun.plugin2.util.PojoUtil.toJson;

public class Object_Transfers
{
    private Transfers transfers_objects[];
    private static String table_name="transfers";

    public Transfers[] getTransfersObjects()
    {
        initialise_transfers_objects();
        makeObjectsFromDatabaseTable();
        return transfers_objects;
    }

    public String getTransfersObjectsInJsonString()
    {
        return toJson(getTransfersObjects());
    }

    public void initialise_transfers_objects()
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
        transfers_objects=new Transfers[rowCount];
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
                Transfers transfers=new Transfers();
                transfers.setFrom_stop_id(rslt.getString("from_stop_id"));
                transfers.setTo_stop_id(rslt.getString("to_stop_id"));
                transfers.setTransfer_type(rslt.getString("transfer_type"));
                transfers.setMin_transfer_time(rslt.getString("min_transfer_time"));
                transfers_objects[index++]=transfers;
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
        return toJson(getTransfersObjects());
    }
}
