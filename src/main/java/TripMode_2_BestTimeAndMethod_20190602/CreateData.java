package TripMode_2_BestTimeAndMethod_20190602;

import TripMode.util.MyBatisUtil;
import TripMode_2_BestTimeAndMethod_20190527.BestTimeAndMethod;
import TripMode_2_BestTimeAndMethod_20190602.dao.TimeInfoDao;
import TripMode_2_BestTimeAndMethod_20190602.model.Point;
import TripMode_2_BestTimeAndMethod_20190602.model.Result;
import TripMode_2_BestTimeAndMethod_20190602.model.TimeInfo;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CreateData {

    /**
     * 构造point_info表
     * 范围为经度106.622174-106.641013,维度26.633828-26.657188
     * 方块大小约为200m 经纬度0.002
     * @throws Exception
     */
    public void createTableOne() throws Exception {
        int k=0;
        IniDB iniDB=new IniDB();
        Common common=new Common(iniDB.getConnection());
        for (double i = 26.657188; i >26.633828 ; i-=0.002) {
            for (double j = 106.622174; j < 106.641013; j+=0.002) {
                k++;
                String tempJ=j+"";
                for (int i1 = 0; i1 < tempJ.length(); i1++) {
                    if (tempJ.charAt(i1)=='.'){
                        tempJ=tempJ.substring(0,i1+7);
                    }
                }
                String tempJ1=j+0.002+"";
                for (int i1 = 0; i1 < tempJ1.length(); i1++) {
                    if (tempJ1.charAt(i1)=='.'){
                        tempJ1=tempJ1.substring(0,i1+7);
                    }
                }
                String tempI=i+"";
                for (int i1 = 0; i1 < tempI.length(); i1++) {
                    if (tempI.charAt(i1)=='.'){
                        tempI=tempI.substring(0,i1+7);
                    }
                }
                String tempI1=i-0.002+"";
                for (int i1 = 0; i1 < tempI1.length(); i1++) {
                    if (tempI1.charAt(i1)=='.'){
                        tempI1=tempI1.substring(0,i1+7);
                    }
                }
                Point point=new Point(k,tempJ,tempJ1,tempI1,tempI);
                common.addPoint(point);
            }
        }
        iniDB.connection.close();
    }

    /**
     * 构造time_info表
     * 利用随机数据产生权值
     * 所有方块--中心方块
     * 存储早上7-9点，每隔五分钟，5月1日到5月21日
     * @throws IOException
     */
    public void createTableTwo() throws IOException {
        SqlSession sqlSession= MyBatisUtil.getSession();
        TimeInfoDao timeInfoDao=sqlSession.getMapper(TimeInfoDao.class);
        List<Point> pointList=timeInfoDao.selAll();
        System.out.println("***************");
        Point pp=new Point();
        for (Point p :pointList) {
            if (Double.valueOf(p.getLAT_MIN())<26.645508
                    &&Double.valueOf(p.getLAT_MAX())>26.645508
                    &&Double.valueOf(p.getLON_MIN())<106.6315935
                    &&Double.valueOf(p.getLON_MAX())>106.6315935
            ){
                System.out.println(p);
                pp=p;
            }
        }
        System.out.println("***************");
        System.out.println(pointList);
        Random random=new Random();
        int la=0;
        for (int i = 0; i < pointList.size(); i++) {
                String[] arrStr={
                        "7:00:00","7:05:00","7:10:00","7:15:00","7:20:00","7:25:00"
                        ,"7:30:00","7:35:00", "7:40:00","7:45:00","7:50:00","7:55:00",
                        "8:00:00","8:05:00","8:10:00","8:15:00","8:20:00","8:25:00"
                        ,"8:30:00","8:35:00", "8:40:00","8:45:00","8:50:00","8:55:00"
                };
                String[] arrStr1={
                        "Bus"
                        ,"Car"
                        ,"LightRail"
                };
                for (int k = 1; k < 22; k++) {
                    for (int k1 = 0; k1 < 24; k1++) {
                        for (int k2 = 0; k2 <3 ; k2++) {
                            String date_time="";
                            if (k >= 10) {
                                date_time = "2019-05-" + k + "T" + arrStr[k1];
                            }else{
                                date_time = "2019-05-0" + k + "T" + arrStr[k1];
                            }
                            String way=arrStr1[k2];
                            timeInfoDao.addTimeInfo(new TimeInfo(pointList.get(i).getPOINT_ID()
                                    , pp.getPOINT_ID()
                                    , random.nextInt(100)
                                    , date_time
                                    , way
                            ));
                            System.out.println(++la);
                        }
                    }
                }
            }

        sqlSession.commit();
        sqlSession.close();
    }

    //利用高德API获得各方式的时间
    public void computer(String startLat,String startLon,
                         String endLat,String endLon,
                         String date,String time) throws IOException {

        BestTimeAndMethod bestTimeAndMethod=new BestTimeAndMethod();
        double timeByCar=bestTimeAndMethod.computeByCar(startLon,startLat
                ,endLon,endLat);
        System.out.println("timeByCar:"+timeByCar);
        double timeByLightRail=bestTimeAndMethod.computeByLightRail(
                startLon,startLat
                ,endLon,endLat
                ,date,time
        );
        System.out.println("timeByLightRail:"+timeByLightRail);
        double timeByBus=bestTimeAndMethod.computeByBus(
                startLon,startLat
                ,endLon,endLat
                ,date,time
        );
        System.out.println("timeByBus:"+timeByBus);
    }

    /**
     * 查询出最佳出行时间与方式
     * 范围为经度106.622174-106.641013,维度26.633828-26.657188
     * @param startLat
     * @param startLon
     * @param date
     * @return
     */
    public Result getResult(Double startLon,Double startLat,String date) throws ParseException {
        SqlSession sqlSession= MyBatisUtil.getSession();
        TimeInfoDao timeInfoDao=sqlSession.getMapper(TimeInfoDao.class);
        List<Point> pointList=timeInfoDao.selAll();
        Point pp=new Point();
        for (Point p :pointList) {
            if (Double.valueOf(p.getLAT_MIN())<startLat
                    &&Double.valueOf(p.getLAT_MAX())>startLat
                    &&Double.valueOf(p.getLON_MIN())<startLon
                    &&Double.valueOf(p.getLON_MAX())>startLon
            ){
                System.out.println(p);
                pp=p;
            }
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=simpleDateFormat.parse(date);

        String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        //System.out.println(weekDays[w]);
        String[] arrStr={
                "7,00","7,05","7,10","7,15","7,20","7,25"
                ,"7,30","7,35", "7,40","7,45","7,50","7,55",
                "8,00","8,05","8,10","8,15","8,20","8,25"
                ,"8,30","8,35", "8,40","8,45","8,50","8,55"
        };
        String[] arrStr1={
                "Bus"
                ,"Car"
                ,"LightRail"
        };
        List<Result> resultList=new LinkedList<>();
        for (int kk=0;kk<24;kk++){
            List<TimeInfo> timeInfoList=timeInfoDao.getPoints(pp.getPOINT_ID()+"",arrStr[kk],weekDays[w]);
            Double timeByBus=0.0;
            Double timeByLightRail=0.0;
            Double timeByCar=0.0;
            for (TimeInfo timeInfo:timeInfoList){
                if (timeInfo.getWAY().equals("Bus")){
                    timeByBus+=timeInfo.getTIME_CONSUMED();
                }else if (timeInfo.getWAY().equals("LightRail")){
                    timeByLightRail+=timeInfo.getTIME_CONSUMED();
                }else if (timeInfo.getWAY().equals("Car")){
                    timeByCar+=timeInfo.getTIME_CONSUMED();
                }
            }
            timeByBus/=3;
            timeByLightRail/=3;
            timeByCar/=3;
            Double tempTimeByBus=timeByBus;
            Double tempTimeByLightRail=timeByLightRail;
            Double tempTimeByCar=timeByCar;
            if (kk<6){
                tempTimeByBus+=50;
                if(tempTimeByBus>120){
                    tempTimeByBus=(tempTimeByBus-120)*51;
                }else {
                    tempTimeByBus=-(120-tempTimeByBus)*49.5;
                }
                timeByBus=timeByBus*25.5+tempTimeByBus;

                tempTimeByLightRail+=50;
                if(tempTimeByLightRail>120){
                    tempTimeByLightRail=(tempTimeByLightRail-120)*51;
                }else {
                    tempTimeByLightRail=-(120-tempTimeByLightRail)*49.5;
                }
                timeByLightRail=timeByLightRail*25.5*1.6+tempTimeByLightRail;

                tempTimeByCar+=50;
                if(tempTimeByCar>120){
                    tempTimeByCar=(tempTimeByCar-120)*51;
                }else {
                    tempTimeByCar=-(120-tempTimeByCar)*49.5;
                }
                timeByCar=timeByCar*25.5*3+tempTimeByCar;

            }else if (kk<12){
                tempTimeByBus+=50;
                if(tempTimeByBus>120){
                    tempTimeByBus=(tempTimeByBus-120)*51;
                }else {
                    tempTimeByBus=-(120-tempTimeByBus)*49.5;
                }
                timeByBus=timeByBus*25.5+tempTimeByBus;

                tempTimeByLightRail+=50;
                if(tempTimeByLightRail>120){
                    tempTimeByLightRail=(tempTimeByLightRail-120)*51;
                }else {
                    tempTimeByLightRail=-(120-tempTimeByLightRail)*49.5;
                }
                timeByLightRail=timeByLightRail*25.5*1.6+tempTimeByLightRail;

                tempTimeByCar+=50;
                if(tempTimeByCar>120){
                    tempTimeByCar=(tempTimeByCar-120)*51;
                }else {
                    tempTimeByCar=-(120-tempTimeByCar)*49.5;
                }
                timeByCar=timeByCar*25.5*3+tempTimeByCar;

            }else if (kk<24){
                tempTimeByBus+=50;
                if(tempTimeByBus>120){
                    tempTimeByBus=(tempTimeByBus-120)*51;
                }else {
                    tempTimeByBus=-(120-tempTimeByBus)*108;
                }
                timeByBus=timeByBus*25.5+tempTimeByBus;

                tempTimeByLightRail+=50;
                if(tempTimeByLightRail>120){
                    tempTimeByLightRail=(tempTimeByLightRail-120)*51;
                }else {
                    tempTimeByLightRail=-(120-tempTimeByLightRail)*108;
                }
                timeByLightRail=timeByLightRail*25.5*1.6+tempTimeByLightRail;

                tempTimeByCar+=50;
                if(tempTimeByCar>120){
                    tempTimeByCar=(tempTimeByCar-120)*51;
                }else {
                    tempTimeByCar=-(120-tempTimeByCar)*108;
                }
                timeByCar=timeByCar*25.5*3+tempTimeByCar;

            }
            resultList.add(new Result(arrStr[kk],"Bus",timeByBus));
            resultList.add(new Result(arrStr[kk],"LightRail",timeByLightRail));
            resultList.add(new Result(arrStr[kk],"Car",timeByCar));
        }
        Result result2=new Result();
        Double value=100000.0;
        for (Result result:resultList){
            if(result.getValue()<value){
                value=result.getValue();
                result2=result;
            }
        }



        sqlSession.close();
        return new Result(result2.getTime(),result2.getMethod());
    }
}
