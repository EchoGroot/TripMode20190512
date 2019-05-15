package TripMode_2_Temp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Common {
    public Connection connection;
    public Common(Connection connection){
        this.connection=connection;
    }
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
        return pointQueue;
    }
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

    public void shortest(int start,int[] dist,int[] path) throws SQLException {
        for(int i=0;i<10000;i++){
            String sql="INSERT INTO shortest (START_POINT,END_POINT,DIST,PATH) VALUES('" +
                     start+"','"+i+"','"+dist[i]+"','"+path[i] +"')";
            System.out.println(sql);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("插入信息成功");
            //connection.close();
        }
    }

    public Shortest getShortest(int start, int end) throws SQLException {
        System.out.println("进入common.getShortest");
        Stack<Integer> shortest=new Stack<>();
        shortest.push(end);
        System.out.println("压栈");
        String sql="SELECT * FROM shortest WHERE POINT_ID='"+end+"'";
        System.out.println(sql);
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        int endDist=0;
        int startDist = 0;
        int tempPath=-1;
        while(resultSet.next()){
            endDist=resultSet.getInt("DIST");
            tempPath=resultSet.getInt("PATH");
        }
        System.out.println("endDist:"+endDist+"tempPath:"+tempPath);
        preparedStatement.close();
        resultSet.close();
        while(tempPath!=start){
            shortest.push(tempPath);
            int tempPoint=shortest.peek();
            String tempSql="SELECT * FROM shortest WHERE POINT_ID='"+tempPoint+"'";
            System.out.println(tempSql);
            PreparedStatement tempPreparedStatement=connection.prepareStatement(tempSql);
            ResultSet tempResultSet=tempPreparedStatement.executeQuery();
            tempPath=-1;
            while(tempResultSet.next()){
                tempPath=tempResultSet.getInt("PATH");
            }
            tempPreparedStatement.close();
            tempResultSet.close();
        }
        shortest.push(start);
        String finalSql="SELECT * FROM shortest WHERE POINT_ID='"+start+"'";
        PreparedStatement finalPreparedStatement=connection.prepareStatement(finalSql);
        System.out.println(finalSql);
        ResultSet finalResultSet=finalPreparedStatement.executeQuery();
        while(finalResultSet.next()){
            startDist=finalResultSet.getInt("DIST");
        }
        finalPreparedStatement.close();
        finalResultSet.close();
        Shortest shortest1=new Shortest();
        shortest1.setDist(endDist-startDist);
        shortest1.setPath(shortest);
        return shortest1;
    }
}
