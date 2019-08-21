package TripMode_2_BestTimeAndMethod_20190602;

import TripMode.util.MyBatisUtil;
import TripMode_2_BestTimeAndMethod_20190602.dao.TimeInfoDao;
import TripMode_2_BestTimeAndMethod_20190602.model.Result;
import TripMode_2_BestTimeAndMethod_20190602.model.TimeInfo;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDateTime;

public class AppTest {
    public static void main(String[] arg) throws Exception {
        CreateData createData=new CreateData();
        //**************
        //createData.createTableOne();

        //**************
        /*SqlSession sqlSession= MyBatisUtil.getSession();
        TimeInfoDao timeInfoDao=sqlSession.getMapper(TimeInfoDao.class);
        String temp=LocalDateTime.now().toString();
        System.out.println(temp);
        TimeInfo timeInfo=new TimeInfo(1,100,55, temp,"Bus");
        System.out.println(timeInfo);
        Integer count=timeInfoDao.addTimeInfo(timeInfo);
        sqlSession.commit();
        sqlSession.close();*/

        //**************
        //createData.createTableTwo();

        //**************
        //范围为经度106.622174-106.641013,维度26.633828-26.657188
        Result result=createData.getResult(
                106.629174,26.642828,"2019-6-3");
        System.out.println(result);

    }
}
