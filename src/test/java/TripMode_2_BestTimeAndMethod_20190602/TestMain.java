package TripMode_2_BestTimeAndMethod_20190602;

import TripMode_2_BestTimeAndMethod_20190602.model.Result;

import java.text.ParseException;

public class TestMain {

    public Result test(Double lon,Double lat,String date) throws ParseException {
        CreateData createData=new CreateData();
        //范围为经度106.622174-106.641013,维度26.633828-26.657188
        Result result=createData.getResult(lon,lat,date);
        return result;
    }


}
