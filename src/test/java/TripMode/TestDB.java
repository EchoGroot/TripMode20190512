package TripMode;

import TripMode.dao.IniDB;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) throws Exception {
        IniDB iniDB=new IniDB();
        Connection connection=iniDB.getConnection();
    }

}
