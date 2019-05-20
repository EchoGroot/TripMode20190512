package TripMode;


import TripMode.dao.TripModeDao;
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

        XmlToJavaBean xmlToJavaBean=new XmlToJavaBean();
        xmlToJavaBean.correct("src/main/resources/data/map.xml");
        Osm osm=xmlToJavaBean.getOsm();

        DijkstraHeap dijkstraHeap=new DijkstraHeap();
        dijkstraHeap.dijkstra(arr,139,310,count,tripModeDao);

        CrossingPo crossingPo=tripModeDao.getLocation("1140340365");
        System.out.println(crossingPo);

        session.close();
    }

}
