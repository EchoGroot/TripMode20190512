package TripMode.dao;

import TripMode.model.Crossing;
import TripMode.po.CrossingPo;

import java.util.List;

public interface TripModeDao {
    public CrossingPo getLocation(String id);
    public List<CrossingPo> selectAll();
    public List<CrossingPo> selectWay(String startId,String endId);
}
