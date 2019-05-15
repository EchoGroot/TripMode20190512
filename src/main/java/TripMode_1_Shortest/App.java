package TripMode_1_Shortest;

import java.sql.Connection;

public class App {
    public static void main(String args[]) throws Exception {
//        MakeData2 makeData2=new MakeData2();
//        int arr[][]=new int[10005][10005];
//        Vector<PointVector> pointVectors=new Vector<>();
//        向数据库插入数据
//        makeData2.makeData();
//        从数据库取出数据，构造二维数组
//        arr=makeData2.useData()

        //测试dijkstra计算两点

        IniDB iniDB=new IniDB();
        Connection connection=iniDB.getConnection();

    }
}
