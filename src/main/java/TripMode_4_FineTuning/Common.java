package TripMode_4_FineTuning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class Common {
    public Connection connection;
    public Common(Connection connection){
        this.connection=connection;
    }

    //从数据库中提取出所有的地图信息
    public Queue<Point> selectAllPoint() throws SQLException {
        Queue<Point> pointQueue=new LinkedList<>();
        String sql="select * from map";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Point point=new Point();
            point.setPOINT_ID(resultSet.getInt("POINT_ID"));
            point.setPOINT_1(resultSet.getInt("POINT_1"));
            point.setPOINT_1_VALUE(resultSet.getInt("POINT_1_VALUE"));
            point.setPOINT_2(resultSet.getInt("POINT_2"));
            point.setPOINT_2_VALUE(resultSet.getInt("POINT_2_VALUE"));
            point.setPOINT_3(resultSet.getInt("POINT_3"));
            point.setPOINT_3_VALUE(resultSet.getInt("POINT_3_VALUE"));
            point.setPOINT_4(resultSet.getInt("POINT_4"));
            point.setPOINT_4_VALUE(resultSet.getInt("POINT_4_VALUE"));
            pointQueue.add(point);
        }
        preparedStatement.close();
        resultSet.close();
        connection.close();
        return pointQueue;
    }

    //向数据库添加地图信息
    public void addPoint(Point point) throws SQLException {
        String sql="INSERT INTO map(POINT_ID," +
                "POINT_1,POINT_1_VALUE," +
                "POINT_2,POINT_2_VALUE," +
                "POINT_3,POINT_3_VALUE," +
                "POINT_4,POINT_4_VALUE) values('"+point.getPOINT_ID()+"','"
                +point.getPOINT_1()+"','"+point.getPOINT_1_VALUE()+"','"
                +point.getPOINT_2()+"','"+point.getPOINT_2_VALUE()+"','"
                +point.getPOINT_3()+"','"+point.getPOINT_3_VALUE()+"','"
                +point.getPOINT_4()+"','"+point.getPOINT_4_VALUE()+"')";
        System.out.println(sql);
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        System.out.println("插入信息成功");
        connection.close();
    }

    //给点设置容量属性
    public void addPointCapacity(int point,int capacity) throws SQLException {
        String sql="UPDATE map SET POINT_CAPACITY = '"+capacity+"' WHERE POINT_ID = '"+point+"'";
        System.out.println(sql);
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        //需要多次使用，此处不用connection.close，在调用此方法的地方调用
    }

    //从数据库中读出所有点容量，并返回数组
    public int[] getPointCapacity() throws SQLException {
        int[] array=new int[10005];
        String sql="SELECT POINT_CAPACITY FROM map";
        System.out.println(sql);
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        int i=0;
        while (resultSet.next()){
            array[i]=resultSet.getInt("POINT_CAPACITY");
            i++;
        }
        return array;
    }

    //向数据库存储最短路径坐标
    public void addShortest(int shortestId,int pointX,int pointY) throws SQLException {
        String sql="INSERT INTO shortest_to_excel(SHORTEST_ID,POINT_X,POINT_Y) " +
                "VALUES ('"+shortestId+"','"+pointX+"','"+pointY+"')";
        System.out.println(sql);
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        //需要多次使用，此处不用connection.close，在调用此方法的地方调用
    }

    //向数据库存储微调后的路径坐标
    public void addUpdateShortest(int shortestId,int pointX,int pointY) throws SQLException {
        String sql="INSERT INTO shortest_update_to_excel(SHORTEST_ID,POINT_X,POINT_Y) " +
                "VALUES ('"+shortestId+"','"+pointX+"','"+pointY+"')";
        System.out.println(sql);
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        //需要多次使用，此处不用connection.close，在调用此方法的地方调用
    }

    //从数据库读取全部路线
    public int[][] getAllShortest() throws SQLException {
        int[][] allShortest=new int[50][];
        String sql="SELECT * FROM shortest_to_excel";
        System.out.println(sql);
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        int k=0;
        int tempX=0;
        int tempY=0;
        int tempShortestId=0;
        allShortest[tempShortestId]=new int[10005];
        while (resultSet.next()){
            if (resultSet.getInt("SHORTEST_ID")!=tempShortestId){
                k=0;
                allShortest[resultSet.getInt("SHORTEST_ID")]=new int[10005];
            }
            tempX=resultSet.getInt("POINT_X");
            tempY=resultSet.getInt("POINT_Y");
            tempShortestId=resultSet.getInt("SHORTEST_ID");
            allShortest[tempShortestId][k]=tempY*100+tempX;
            k++;
        }
        preparedStatement.close();
        resultSet.close();
        connection.close();
        return allShortest;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
