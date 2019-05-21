package TripMode.dao;

import TripMode.model.Crossing;
import TripMode.model.Way;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Store {
    public Connection connection;
    public Store(Connection connection){
        this.connection=connection;
    }

    public void addCrossing(Crossing crossing) throws SQLException {
        int size=crossing.getConnections().size();
        switch (size){
            case 0:
                String sql="INSERT INTO tripmode_crossing(ID," +
                        "LAT," +
                        "LON," +
                        ") values('"+crossing.getId()+"','"
                        +crossing.getLat()+"','"
                        +crossing.getLon()
                        +"')";
                System.out.println(sql);
                PreparedStatement preparedStatement=connection.prepareStatement(sql);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                System.out.println("插入信息成功");
                //connection.close();
                break;
            case 1:
                String sql1="INSERT INTO tripmode_crossing(ID," +
                        "LAT," +
                        "LON," +
                        "CROSSING_1_ID,"+
                        "CROSSING_1_LAT,"+
                        "CROSSING_1_LON,"+
                        "CROSSING_1_VALUE"+
                        ") values('"+crossing.getId()+"','"
                        +crossing.getLat()+"','"
                        +crossing.getLon()+"','"
                        +crossing.getConnections().get(0).getConnectionId()+"','"
                        +crossing.getConnections().get(0).getConnectionLat()+"','"
                        +crossing.getConnections().get(0).getConnectionLon()+"','"
                        +crossing.getConnections().get(0).getConnectionValue()
                        +"')";
                System.out.println(sql1);
                PreparedStatement preparedStatement1=connection.prepareStatement(sql1);
                preparedStatement1.executeUpdate();
                preparedStatement1.close();
                System.out.println("插入信息成功");
                //connection.close();
                break;
            case 2:
                String sql2="INSERT INTO tripmode_crossing(ID," +
                        "LAT," +
                        "LON," +
                        "CROSSING_1_ID,"+
                        "CROSSING_1_LAT,"+
                        "CROSSING_1_LON,"+
                        "CROSSING_1_VALUE,"+
                        "CROSSING_2_ID,"+
                        "CROSSING_2_LAT,"+
                        "CROSSING_2_LON,"+
                        "CROSSING_2_VALUE"+
                        ") values('"+crossing.getId()+"','"
                        +crossing.getLat()+"','"
                        +crossing.getLon()+"','"
                        +crossing.getConnections().get(0).getConnectionId()+"','"
                        +crossing.getConnections().get(0).getConnectionLat()+"','"
                        +crossing.getConnections().get(0).getConnectionLon()+"','"
                        +crossing.getConnections().get(0).getConnectionValue()+"','"
                        +crossing.getConnections().get(1).getConnectionId()+"','"
                        +crossing.getConnections().get(1).getConnectionLat()+"','"
                        +crossing.getConnections().get(1).getConnectionLon()+"','"
                        +crossing.getConnections().get(1).getConnectionValue()
                        +"')";
                System.out.println(sql2);
                PreparedStatement preparedStatement2=connection.prepareStatement(sql2);
                preparedStatement2.executeUpdate();
                preparedStatement2.close();
                System.out.println("插入信息成功");
                //connection.close();
                break;
            case 3:
                String sql3="INSERT INTO tripmode_crossing(ID," +
                        "LAT," +
                        "LON," +
                        "CROSSING_1_ID,"+
                        "CROSSING_1_LAT,"+
                        "CROSSING_1_LON,"+
                        "CROSSING_1_VALUE,"+
                        "CROSSING_2_ID,"+
                        "CROSSING_2_LAT,"+
                        "CROSSING_2_LON,"+
                        "CROSSING_2_VALUE,"+
                        "CROSSING_3_ID,"+
                        "CROSSING_3_LAT,"+
                        "CROSSING_3_LON,"+
                        "CROSSING_3_VALUE"+
                        ") values('"+crossing.getId()+"','"
                        +crossing.getLat()+"','"
                        +crossing.getLon()+"','"
                        +crossing.getConnections().get(0).getConnectionId()+"','"
                        +crossing.getConnections().get(0).getConnectionLat()+"','"
                        +crossing.getConnections().get(0).getConnectionLon()+"','"
                        +crossing.getConnections().get(0).getConnectionValue()+"','"
                        +crossing.getConnections().get(1).getConnectionId()+"','"
                        +crossing.getConnections().get(1).getConnectionLat()+"','"
                        +crossing.getConnections().get(1).getConnectionLon()+"','"
                        +crossing.getConnections().get(1).getConnectionValue()+"','"
                        +crossing.getConnections().get(2).getConnectionId()+"','"
                        +crossing.getConnections().get(2).getConnectionLat()+"','"
                        +crossing.getConnections().get(2).getConnectionLon()+"','"
                        +crossing.getConnections().get(2).getConnectionValue()
                        +"')";
                System.out.println(sql3);
                PreparedStatement preparedStatement3=connection.prepareStatement(sql3);
                preparedStatement3.executeUpdate();
                preparedStatement3.close();
                System.out.println("插入信息成功");
                //connection.close();
                break;
            case 4:
                String sql4="INSERT INTO tripmode_crossing(ID," +
                        "LAT," +
                        "LON," +
                        "CROSSING_1_ID,"+
                        "CROSSING_1_LAT,"+
                        "CROSSING_1_LON,"+
                        "CROSSING_1_VALUE,"+
                        "CROSSING_2_ID,"+
                        "CROSSING_2_LAT,"+
                        "CROSSING_2_LON,"+
                        "CROSSING_2_VALUE,"+
                        "CROSSING_3_ID,"+
                        "CROSSING_3_LAT,"+
                        "CROSSING_3_LON,"+
                        "CROSSING_3_VALUE,"+
                        "CROSSING_4_ID,"+
                        "CROSSING_4_LAT,"+
                        "CROSSING_4_LON,"+
                        "CROSSING_4_VALUE"+
                        ") values('"+crossing.getId()+"','"
                        +crossing.getLat()+"','"
                        +crossing.getLon()+"','"
                        +crossing.getConnections().get(0).getConnectionId()+"','"
                        +crossing.getConnections().get(0).getConnectionLat()+"','"
                        +crossing.getConnections().get(0).getConnectionLon()+"','"
                        +crossing.getConnections().get(0).getConnectionValue()+"','"
                        +crossing.getConnections().get(1).getConnectionId()+"','"
                        +crossing.getConnections().get(1).getConnectionLat()+"','"
                        +crossing.getConnections().get(1).getConnectionLon()+"','"
                        +crossing.getConnections().get(1).getConnectionValue()+"','"
                        +crossing.getConnections().get(2).getConnectionId()+"','"
                        +crossing.getConnections().get(2).getConnectionLat()+"','"
                        +crossing.getConnections().get(2).getConnectionLon()+"','"
                        +crossing.getConnections().get(2).getConnectionValue()+"','"
                        +crossing.getConnections().get(3).getConnectionId()+"','"
                        +crossing.getConnections().get(3).getConnectionLat()+"','"
                        +crossing.getConnections().get(3).getConnectionLon()+"','"
                        +crossing.getConnections().get(3).getConnectionValue()
                        +"')";
                System.out.println(sql4);
                PreparedStatement preparedStatement4=connection.prepareStatement(sql4);
                preparedStatement4.executeUpdate();
                preparedStatement4.close();
                System.out.println("插入信息成功");
                //connection.close();
                break;
            case 5:
                String sql5="INSERT INTO tripmode_crossing(ID," +
                        "LAT," +
                        "LON," +
                        "CROSSING_1_ID,"+
                        "CROSSING_1_LAT,"+
                        "CROSSING_1_LON,"+
                        "CROSSING_1_VALUE,"+
                        "CROSSING_2_ID,"+
                        "CROSSING_2_LAT,"+
                        "CROSSING_2_LON,"+
                        "CROSSING_2_VALUE,"+
                        "CROSSING_3_ID,"+
                        "CROSSING_3_LAT,"+
                        "CROSSING_3_LON,"+
                        "CROSSING_3_VALUE,"+
                        "CROSSING_4_ID,"+
                        "CROSSING_4_LAT,"+
                        "CROSSING_4_LON,"+
                        "CROSSING_4_VALUE,"+
                        "CROSSING_5_ID,"+
                        "CROSSING_5_LAT,"+
                        "CROSSING_5_LON,"+
                        "CROSSING_5_VALUE"+
                        ") values('"+crossing.getId()+"','"
                        +crossing.getLat()+"','"
                        +crossing.getLon()+"','"
                        +crossing.getConnections().get(0).getConnectionId()+"','"
                        +crossing.getConnections().get(0).getConnectionLat()+"','"
                        +crossing.getConnections().get(0).getConnectionLon()+"','"
                        +crossing.getConnections().get(0).getConnectionValue()+"','"
                        +crossing.getConnections().get(1).getConnectionId()+"','"
                        +crossing.getConnections().get(1).getConnectionLat()+"','"
                        +crossing.getConnections().get(1).getConnectionLon()+"','"
                        +crossing.getConnections().get(1).getConnectionValue()+"','"
                        +crossing.getConnections().get(2).getConnectionId()+"','"
                        +crossing.getConnections().get(2).getConnectionLat()+"','"
                        +crossing.getConnections().get(2).getConnectionLon()+"','"
                        +crossing.getConnections().get(2).getConnectionValue()+"','"
                        +crossing.getConnections().get(3).getConnectionId()+"','"
                        +crossing.getConnections().get(3).getConnectionLat()+"','"
                        +crossing.getConnections().get(3).getConnectionLon()+"','"
                        +crossing.getConnections().get(3).getConnectionValue()+"','"
                        +crossing.getConnections().get(4).getConnectionId()+"','"
                        +crossing.getConnections().get(4).getConnectionLat()+"','"
                        +crossing.getConnections().get(4).getConnectionLon()+"','"
                        +crossing.getConnections().get(4).getConnectionValue()
                        +"')";
                System.out.println(sql5);
                PreparedStatement preparedStatement5=connection.prepareStatement(sql5);
                preparedStatement5.executeUpdate();
                preparedStatement5.close();
                System.out.println("插入信息成功");
                //connection.close();
                break;
            case 6:
                String sql6="INSERT INTO tripmode_crossing(ID," +
                        "LAT," +
                        "LON," +
                        "CROSSING_1_ID,"+
                        "CROSSING_1_LAT,"+
                        "CROSSING_1_LON,"+
                        "CROSSING_1_VALUE,"+
                        "CROSSING_2_ID,"+
                        "CROSSING_2_LAT,"+
                        "CROSSING_2_LON,"+
                        "CROSSING_2_VALUE,"+
                        "CROSSING_3_ID,"+
                        "CROSSING_3_LAT,"+
                        "CROSSING_3_LON,"+
                        "CROSSING_3_VALUE,"+
                        "CROSSING_4_ID,"+
                        "CROSSING_4_LAT,"+
                        "CROSSING_4_LON,"+
                        "CROSSING_4_VALUE,"+
                        "CROSSING_5_ID,"+
                        "CROSSING_5_LAT,"+
                        "CROSSING_5_LON,"+
                        "CROSSING_5_VALUE,"+
                        "CROSSING_6_ID,"+
                        "CROSSING_6_LAT,"+
                        "CROSSING_6_LON,"+
                        "CROSSING_6_VALUE"+
                        ") values('"+crossing.getId()+"','"
                        +crossing.getLat()+"','"
                        +crossing.getLon()+"','"
                        +crossing.getConnections().get(0).getConnectionId()+"','"
                        +crossing.getConnections().get(0).getConnectionLat()+"','"
                        +crossing.getConnections().get(0).getConnectionLon()+"','"
                        +crossing.getConnections().get(0).getConnectionValue()+"','"
                        +crossing.getConnections().get(1).getConnectionId()+"','"
                        +crossing.getConnections().get(1).getConnectionLat()+"','"
                        +crossing.getConnections().get(1).getConnectionLon()+"','"
                        +crossing.getConnections().get(1).getConnectionValue()+"','"
                        +crossing.getConnections().get(2).getConnectionId()+"','"
                        +crossing.getConnections().get(2).getConnectionLat()+"','"
                        +crossing.getConnections().get(2).getConnectionLon()+"','"
                        +crossing.getConnections().get(2).getConnectionValue()+"','"
                        +crossing.getConnections().get(3).getConnectionId()+"','"
                        +crossing.getConnections().get(3).getConnectionLat()+"','"
                        +crossing.getConnections().get(3).getConnectionLon()+"','"
                        +crossing.getConnections().get(3).getConnectionValue()+"','"
                        +crossing.getConnections().get(4).getConnectionId()+"','"
                        +crossing.getConnections().get(4).getConnectionLat()+"','"
                        +crossing.getConnections().get(4).getConnectionLon()+"','"
                        +crossing.getConnections().get(4).getConnectionValue()+"','"
                        +crossing.getConnections().get(5).getConnectionId()+"','"
                        +crossing.getConnections().get(5).getConnectionLat()+"','"
                        +crossing.getConnections().get(5).getConnectionLon()+"','"
                        +crossing.getConnections().get(5).getConnectionValue()
                        +"')";
                System.out.println(sql6);
                PreparedStatement preparedStatement6=connection.prepareStatement(sql6);
                preparedStatement6.executeUpdate();
                preparedStatement6.close();
                System.out.println("插入信息成功");
                //connection.close();
                break;
            case 7:
                String sql7="INSERT INTO tripmode_crossing(ID," +
                        "LAT," +
                        "LON," +
                        "CROSSING_1_ID,"+
                        "CROSSING_1_LAT,"+
                        "CROSSING_1_LON,"+
                        "CROSSING_1_VALUE,"+
                        "CROSSING_2_ID,"+
                        "CROSSING_2_LAT,"+
                        "CROSSING_2_LON,"+
                        "CROSSING_2_VALUE,"+
                        "CROSSING_3_ID,"+
                        "CROSSING_3_LAT,"+
                        "CROSSING_3_LON,"+
                        "CROSSING_3_VALUE,"+
                        "CROSSING_4_ID,"+
                        "CROSSING_4_LAT,"+
                        "CROSSING_4_LON,"+
                        "CROSSING_4_VALUE,"+
                        "CROSSING_5_ID,"+
                        "CROSSING_5_LAT,"+
                        "CROSSING_5_LON,"+
                        "CROSSING_5_VALUE,"+
                        "CROSSING_6_ID,"+
                        "CROSSING_6_LAT,"+
                        "CROSSING_6_LON,"+
                        "CROSSING_6_VALUE,"+
                        "CROSSING_7_ID,"+
                        "CROSSING_7_LAT,"+
                        "CROSSING_7_LON,"+
                        "CROSSING_7_VALUE"+
                        ") values('"+crossing.getId()+"','"
                        +crossing.getLat()+"','"
                        +crossing.getLon()+"','"
                        +crossing.getConnections().get(0).getConnectionId()+"','"
                        +crossing.getConnections().get(0).getConnectionLat()+"','"
                        +crossing.getConnections().get(0).getConnectionLon()+"','"
                        +crossing.getConnections().get(0).getConnectionValue()+"','"
                        +crossing.getConnections().get(1).getConnectionId()+"','"
                        +crossing.getConnections().get(1).getConnectionLat()+"','"
                        +crossing.getConnections().get(1).getConnectionLon()+"','"
                        +crossing.getConnections().get(1).getConnectionValue()+"','"
                        +crossing.getConnections().get(2).getConnectionId()+"','"
                        +crossing.getConnections().get(2).getConnectionLat()+"','"
                        +crossing.getConnections().get(2).getConnectionLon()+"','"
                        +crossing.getConnections().get(2).getConnectionValue()+"','"
                        +crossing.getConnections().get(3).getConnectionId()+"','"
                        +crossing.getConnections().get(3).getConnectionLat()+"','"
                        +crossing.getConnections().get(3).getConnectionLon()+"','"
                        +crossing.getConnections().get(3).getConnectionValue()+"','"
                        +crossing.getConnections().get(4).getConnectionId()+"','"
                        +crossing.getConnections().get(4).getConnectionLat()+"','"
                        +crossing.getConnections().get(4).getConnectionLon()+"','"
                        +crossing.getConnections().get(4).getConnectionValue()+"','"
                        +crossing.getConnections().get(5).getConnectionId()+"','"
                        +crossing.getConnections().get(5).getConnectionLat()+"','"
                        +crossing.getConnections().get(5).getConnectionLon()+"','"
                        +crossing.getConnections().get(5).getConnectionValue()+"','"
                        +crossing.getConnections().get(6).getConnectionId()+"','"
                        +crossing.getConnections().get(6).getConnectionLat()+"','"
                        +crossing.getConnections().get(6).getConnectionLon()+"','"
                        +crossing.getConnections().get(6).getConnectionValue()
                        +"')";
                System.out.println(sql7);
                PreparedStatement preparedStatement7=connection.prepareStatement(sql7);
                preparedStatement7.executeUpdate();
                preparedStatement7.close();
                System.out.println("插入信息成功");
                //connection.close();
                break;
            case 8:
                String sql8="INSERT INTO tripmode_crossing(ID," +
                        "LAT," +
                        "LON," +
                        "CROSSING_1_ID,"+
                        "CROSSING_1_LAT,"+
                        "CROSSING_1_LON,"+
                        "CROSSING_1_VALUE,"+
                        "CROSSING_2_ID,"+
                        "CROSSING_2_LAT,"+
                        "CROSSING_2_LON,"+
                        "CROSSING_2_VALUE,"+
                        "CROSSING_3_ID,"+
                        "CROSSING_3_LAT,"+
                        "CROSSING_3_LON,"+
                        "CROSSING_3_VALUE,"+
                        "CROSSING_4_ID,"+
                        "CROSSING_4_LAT,"+
                        "CROSSING_4_LON,"+
                        "CROSSING_4_VALUE,"+
                        "CROSSING_5_ID,"+
                        "CROSSING_5_LAT,"+
                        "CROSSING_5_LON,"+
                        "CROSSING_5_VALUE,"+
                        "CROSSING_6_ID,"+
                        "CROSSING_6_LAT,"+
                        "CROSSING_6_LON,"+
                        "CROSSING_6_VALUE,"+
                        "CROSSING_7_ID,"+
                        "CROSSING_7_LAT,"+
                        "CROSSING_7_LON,"+
                        "CROSSING_7_VALUE,"+
                        "CROSSING_8_ID,"+
                        "CROSSING_8_LAT,"+
                        "CROSSING_8_LON,"+
                        "CROSSING_8_VALUE"+
                        ") values('"+crossing.getId()+"','"
                        +crossing.getLat()+"','"
                        +crossing.getLon()+"','"
                        +crossing.getConnections().get(0).getConnectionId()+"','"
                        +crossing.getConnections().get(0).getConnectionLat()+"','"
                        +crossing.getConnections().get(0).getConnectionLon()+"','"
                        +crossing.getConnections().get(0).getConnectionValue()+"','"
                        +crossing.getConnections().get(1).getConnectionId()+"','"
                        +crossing.getConnections().get(1).getConnectionLat()+"','"
                        +crossing.getConnections().get(1).getConnectionLon()+"','"
                        +crossing.getConnections().get(1).getConnectionValue()+"','"
                        +crossing.getConnections().get(2).getConnectionId()+"','"
                        +crossing.getConnections().get(2).getConnectionLat()+"','"
                        +crossing.getConnections().get(2).getConnectionLon()+"','"
                        +crossing.getConnections().get(2).getConnectionValue()+"','"
                        +crossing.getConnections().get(3).getConnectionId()+"','"
                        +crossing.getConnections().get(3).getConnectionLat()+"','"
                        +crossing.getConnections().get(3).getConnectionLon()+"','"
                        +crossing.getConnections().get(3).getConnectionValue()+"','"
                        +crossing.getConnections().get(4).getConnectionId()+"','"
                        +crossing.getConnections().get(4).getConnectionLat()+"','"
                        +crossing.getConnections().get(4).getConnectionLon()+"','"
                        +crossing.getConnections().get(4).getConnectionValue()+"','"
                        +crossing.getConnections().get(5).getConnectionId()+"','"
                        +crossing.getConnections().get(5).getConnectionLat()+"','"
                        +crossing.getConnections().get(5).getConnectionLon()+"','"
                        +crossing.getConnections().get(5).getConnectionValue()+"','"
                        +crossing.getConnections().get(6).getConnectionId()+"','"
                        +crossing.getConnections().get(6).getConnectionLat()+"','"
                        +crossing.getConnections().get(6).getConnectionLon()+"','"
                        +crossing.getConnections().get(6).getConnectionValue()+"','"
                        +crossing.getConnections().get(7).getConnectionId()+"','"
                        +crossing.getConnections().get(7).getConnectionLat()+"','"
                        +crossing.getConnections().get(7).getConnectionLon()+"','"
                        +crossing.getConnections().get(7).getConnectionValue()
                        +"')";
                System.out.println(sql8);
                PreparedStatement preparedStatement8=connection.prepareStatement(sql8);
                preparedStatement8.executeUpdate();
                preparedStatement8.close();
                System.out.println("插入信息成功");
                //connection.close();
                break;
            case 9:
                String sql9="INSERT INTO tripmode_crossing(ID," +
                        "LAT," +
                        "LON," +
                        "CROSSING_1_ID,"+
                        "CROSSING_1_LAT,"+
                        "CROSSING_1_LON,"+
                        "CROSSING_1_VALUE,"+
                        "CROSSING_2_ID,"+
                        "CROSSING_2_LAT,"+
                        "CROSSING_2_LON,"+
                        "CROSSING_2_VALUE,"+
                        "CROSSING_3_ID,"+
                        "CROSSING_3_LAT,"+
                        "CROSSING_3_LON,"+
                        "CROSSING_3_VALUE,"+
                        "CROSSING_4_ID,"+
                        "CROSSING_4_LAT,"+
                        "CROSSING_4_LON,"+
                        "CROSSING_4_VALUE,"+
                        "CROSSING_5_ID,"+
                        "CROSSING_5_LAT,"+
                        "CROSSING_5_LON,"+
                        "CROSSING_5_VALUE,"+
                        "CROSSING_6_ID,"+
                        "CROSSING_6_LAT,"+
                        "CROSSING_6_LON,"+
                        "CROSSING_6_VALUE,"+
                        "CROSSING_7_ID,"+
                        "CROSSING_7_LAT,"+
                        "CROSSING_7_LON,"+
                        "CROSSING_7_VALUE,"+
                        "CROSSING_8_ID,"+
                        "CROSSING_8_LAT,"+
                        "CROSSING_8_LON,"+
                        "CROSSING_8_VALUE,"+
                        "CROSSING_9_ID,"+
                        "CROSSING_9_LAT,"+
                        "CROSSING_9_LON,"+
                        "CROSSING_9_VALUE"+
                        ") values('"+crossing.getId()+"','"
                        +crossing.getLat()+"','"
                        +crossing.getLon()+"','"
                        +crossing.getConnections().get(0).getConnectionId()+"','"
                        +crossing.getConnections().get(0).getConnectionLat()+"','"
                        +crossing.getConnections().get(0).getConnectionLon()+"','"
                        +crossing.getConnections().get(0).getConnectionValue()+"','"
                        +crossing.getConnections().get(1).getConnectionId()+"','"
                        +crossing.getConnections().get(1).getConnectionLat()+"','"
                        +crossing.getConnections().get(1).getConnectionLon()+"','"
                        +crossing.getConnections().get(1).getConnectionValue()+"','"
                        +crossing.getConnections().get(2).getConnectionId()+"','"
                        +crossing.getConnections().get(2).getConnectionLat()+"','"
                        +crossing.getConnections().get(2).getConnectionLon()+"','"
                        +crossing.getConnections().get(2).getConnectionValue()+"','"
                        +crossing.getConnections().get(3).getConnectionId()+"','"
                        +crossing.getConnections().get(3).getConnectionLat()+"','"
                        +crossing.getConnections().get(3).getConnectionLon()+"','"
                        +crossing.getConnections().get(3).getConnectionValue()+"','"
                        +crossing.getConnections().get(4).getConnectionId()+"','"
                        +crossing.getConnections().get(4).getConnectionLat()+"','"
                        +crossing.getConnections().get(4).getConnectionLon()+"','"
                        +crossing.getConnections().get(4).getConnectionValue()+"','"
                        +crossing.getConnections().get(5).getConnectionId()+"','"
                        +crossing.getConnections().get(5).getConnectionLat()+"','"
                        +crossing.getConnections().get(5).getConnectionLon()+"','"
                        +crossing.getConnections().get(5).getConnectionValue()+"','"
                        +crossing.getConnections().get(6).getConnectionId()+"','"
                        +crossing.getConnections().get(6).getConnectionLat()+"','"
                        +crossing.getConnections().get(6).getConnectionLon()+"','"
                        +crossing.getConnections().get(6).getConnectionValue()+"','"
                        +crossing.getConnections().get(7).getConnectionId()+"','"
                        +crossing.getConnections().get(7).getConnectionLat()+"','"
                        +crossing.getConnections().get(7).getConnectionLon()+"','"
                        +crossing.getConnections().get(7).getConnectionValue()+"','"
                        +crossing.getConnections().get(8).getConnectionId()+"','"
                        +crossing.getConnections().get(8).getConnectionLat()+"','"
                        +crossing.getConnections().get(8).getConnectionLon()+"','"
                        +crossing.getConnections().get(8).getConnectionValue()
                        +"')";
                System.out.println(sql9);
                PreparedStatement preparedStatement9=connection.prepareStatement(sql9);
                preparedStatement9.executeUpdate();
                preparedStatement9.close();
                System.out.println("插入信息成功");
                //connection.close();
                break;
            case 10:
                String sql10="INSERT INTO tripmode_crossing(ID," +
                        "LAT," +
                        "LON," +
                        "CROSSING_1_ID,"+
                        "CROSSING_1_LAT,"+
                        "CROSSING_1_LON,"+
                        "CROSSING_1_VALUE,"+
                        "CROSSING_2_ID,"+
                        "CROSSING_2_LAT,"+
                        "CROSSING_2_LON,"+
                        "CROSSING_2_VALUE,"+
                        "CROSSING_3_ID,"+
                        "CROSSING_3_LAT,"+
                        "CROSSING_3_LON,"+
                        "CROSSING_3_VALUE,"+
                        "CROSSING_4_ID,"+
                        "CROSSING_4_LAT,"+
                        "CROSSING_4_LON,"+
                        "CROSSING_4_VALUE,"+
                        "CROSSING_5_ID,"+
                        "CROSSING_5_LAT,"+
                        "CROSSING_5_LON,"+
                        "CROSSING_5_VALUE,"+
                        "CROSSING_6_ID,"+
                        "CROSSING_6_LAT,"+
                        "CROSSING_6_LON,"+
                        "CROSSING_6_VALUE,"+
                        "CROSSING_7_ID,"+
                        "CROSSING_7_LAT,"+
                        "CROSSING_7_LON,"+
                        "CROSSING_7_VALUE,"+
                        "CROSSING_8_ID,"+
                        "CROSSING_8_LAT,"+
                        "CROSSING_8_LON,"+
                        "CROSSING_8_VALUE,"+
                        "CROSSING_9_ID,"+
                        "CROSSING_9_LAT,"+
                        "CROSSING_9_LON,"+
                        "CROSSING_9_VALUE,"+
                        "CROSSING_10_ID,"+
                        "CROSSING_10_LAT,"+
                        "CROSSING_10_LON,"+
                        "CROSSING_10_VALUE"+
                        ") values('"+crossing.getId()+"','"
                        +crossing.getLat()+"','"
                        +crossing.getLon()+"','"
                        +crossing.getConnections().get(0).getConnectionId()+"','"
                        +crossing.getConnections().get(0).getConnectionLat()+"','"
                        +crossing.getConnections().get(0).getConnectionLon()+"','"
                        +crossing.getConnections().get(0).getConnectionValue()+"','"
                        +crossing.getConnections().get(1).getConnectionId()+"','"
                        +crossing.getConnections().get(1).getConnectionLat()+"','"
                        +crossing.getConnections().get(1).getConnectionLon()+"','"
                        +crossing.getConnections().get(1).getConnectionValue()+"','"
                        +crossing.getConnections().get(2).getConnectionId()+"','"
                        +crossing.getConnections().get(2).getConnectionLat()+"','"
                        +crossing.getConnections().get(2).getConnectionLon()+"','"
                        +crossing.getConnections().get(2).getConnectionValue()+"','"
                        +crossing.getConnections().get(3).getConnectionId()+"','"
                        +crossing.getConnections().get(3).getConnectionLat()+"','"
                        +crossing.getConnections().get(3).getConnectionLon()+"','"
                        +crossing.getConnections().get(3).getConnectionValue()+"','"
                        +crossing.getConnections().get(4).getConnectionId()+"','"
                        +crossing.getConnections().get(4).getConnectionLat()+"','"
                        +crossing.getConnections().get(4).getConnectionLon()+"','"
                        +crossing.getConnections().get(4).getConnectionValue()+"','"
                        +crossing.getConnections().get(5).getConnectionId()+"','"
                        +crossing.getConnections().get(5).getConnectionLat()+"','"
                        +crossing.getConnections().get(5).getConnectionLon()+"','"
                        +crossing.getConnections().get(5).getConnectionValue()+"','"
                        +crossing.getConnections().get(6).getConnectionId()+"','"
                        +crossing.getConnections().get(6).getConnectionLat()+"','"
                        +crossing.getConnections().get(6).getConnectionLon()+"','"
                        +crossing.getConnections().get(6).getConnectionValue()+"','"
                        +crossing.getConnections().get(7).getConnectionId()+"','"
                        +crossing.getConnections().get(7).getConnectionLat()+"','"
                        +crossing.getConnections().get(7).getConnectionLon()+"','"
                        +crossing.getConnections().get(7).getConnectionValue()+"','"
                        +crossing.getConnections().get(8).getConnectionId()+"','"
                        +crossing.getConnections().get(8).getConnectionLat()+"','"
                        +crossing.getConnections().get(8).getConnectionLon()+"','"
                        +crossing.getConnections().get(8).getConnectionValue()+"','"
                        +crossing.getConnections().get(9).getConnectionId()+"','"
                        +crossing.getConnections().get(9).getConnectionLat()+"','"
                        +crossing.getConnections().get(9).getConnectionLon()+"','"
                        +crossing.getConnections().get(9).getConnectionValue()
                        +"')";
                System.out.println(sql10);
                PreparedStatement preparedStatement10=connection.prepareStatement(sql10);
                preparedStatement10.executeUpdate();
                preparedStatement10.close();
                System.out.println("插入信息成功");
                //connection.close();
                break;
        }

    }

    public void addWay(String wayId,String nodeOfWayStr) throws SQLException {
        String sql="insert into tripmode_way (WAY_ID,NODE)values('"+wayId+"','"+nodeOfWayStr+"');";
        System.out.println(sql);
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        System.out.println("插入信息成功");
    }
}
