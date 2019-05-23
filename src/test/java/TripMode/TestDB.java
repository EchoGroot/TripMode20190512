package TripMode;


import TripMode.dao.TripModeDao;
import TripMode.model.Crossing;
import TripMode.model.Osm;
import TripMode.po.CrossingPo;
import TripMode.service.XmlToJavaBean;
import TripMode.util.MyBatisUtil;
import TripMode_1_Shortest_20190515.DijkstraHeap;
import TripMode_1_Shortest_20190515.MakeData;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class TestDB {
    public static void main(String[] args) throws IOException {
        SqlSession session = MyBatisUtil.getSession();
        TripModeDao tripModeDao=session.getMapper(TripModeDao.class);
        List<CrossingPo> theCrossings = tripModeDao.selectAll();

        MakeData makeData=new MakeData();
        int count=theCrossings.size();
        int[][] arr=new int[count][count];
        arr=makeData.createData(theCrossings);

        //起末点关联路口
        //makeData.judgeCrossing(106.712406+"",26.584407+"",tripModeDao);
        int[] arrLocation=new int[2];
        arrLocation=makeData.connectStartAndEnd(
                new Crossing(106.700342,26.581504),
                new Crossing(106.713668,26.583682),
                tripModeDao);

        DijkstraHeap dijkstraHeap=new DijkstraHeap();
        dijkstraHeap.dijkstra(arr,arrLocation[0],arrLocation[1],count,tripModeDao);


        session.close();
    }

}
