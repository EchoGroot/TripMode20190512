package TripMode.dao;

import TripMode.model.Crossing;
import TripMode.po.CrossingPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TripModeDao {
    CrossingPo getLocation(String id);
    List<CrossingPo> selectAll();
    String selectWay(@Param("startNodeId")String startNodeId,@Param("endNodeId")String endNodeId);
    String judgeCrossing(@Param("lon")String lon,@Param("lat")String lat);
}
