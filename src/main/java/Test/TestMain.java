package Test;

import TripMode_2_BestTimeAndMethod_20190602.CreateData;
import TripMode_2_BestTimeAndMethod_20190602.model.Result;

import java.text.ParseException;

public class TestMain {

    /**
     * 参数（起点经纬度，和出发的日期）
     * 返回最佳出行时间以及出行方式
     * @param lon
     * @param lat
     * @param date
     * @return
     * @throws ParseException
     */
    public Result test(Double lon,Double lat,String date) throws ParseException {
        CreateData createData=new CreateData();
        //范围为经度106.622174-106.641013,维度26.633828-26.657188
        Result result=createData.getResult(lon,lat,date);
        return result;
    }


}
