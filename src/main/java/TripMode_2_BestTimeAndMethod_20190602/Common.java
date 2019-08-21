package TripMode_2_BestTimeAndMethod_20190602;

import TripMode_2_BestTimeAndMethod_20190602.model.Point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Common {
    public Connection connection;
    public Common(Connection connection){
        this.connection=connection;
    }

    public void addPoint(Point point) throws SQLException {
        String sql="INSERT INTO point_info(POINT_ID," +
                "LON_MIN,LON_MAX," +
                "LAT_MIN,LAT_MAX" +
                ") values('"+point.getPOINT_ID()+"','"
                +point.getLON_MIN()+"','"+point.getLON_MAX()+"','"
                +point.getLAT_MIN()+"','"+point.getLAT_MAX()+"')";
        System.out.println(sql);
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        System.out.println("插入信息成功");
        //connection.close();
    }

}
