package TripMode_2_BestTimeAndMethod_20190602.dao;

import TripMode_2_BestTimeAndMethod_20190602.model.Point;
import TripMode_2_BestTimeAndMethod_20190602.model.TimeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TimeInfoDao {
    Integer addTimeInfo(TimeInfo timeInfo);
    List<Point> selAll();
    List<TimeInfo> getPoints(@Param("POINT_ID")String POINT_ID,@Param("date") String date, @Param("week") String week);
}
