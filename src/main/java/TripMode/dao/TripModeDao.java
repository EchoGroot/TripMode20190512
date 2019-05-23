package TripMode.dao;

import TripMode.model.Crossing;
import TripMode.po.CrossingPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TripModeDao {
    public CrossingPo getLocation(String id);
    public List<CrossingPo> selectAll();
    public String selectWay(@Param("startNodeId")String startNodeId,@Param("endNodeId")String endNodeId);
    public String judgeCrossing(@Param("lon")String lon,@Param("lat")String lat);
}
