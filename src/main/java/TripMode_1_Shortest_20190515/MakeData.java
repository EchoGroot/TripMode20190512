package TripMode_1_Shortest_20190515;

import TripMode.dao.TripModeDao;
import TripMode.model.Crossing;
import TripMode.po.CrossingPo;

import java.io.IOException;
import java.util.*;

public class MakeData {
    public static Map<String, Integer> map=new HashMap<>();
    public static Map<Integer,String> map1=new HashMap<>();
    public static final Integer INF=100000;

    public int[][] createData(List<CrossingPo> theCrossings) throws IOException {

        int count=theCrossings.size();
        int[][] arr=new int[count][count];


        for(int i=0;i<count;i++){
            for(int j=0;j<count;j++){
                if(i==j){
                    arr[i][j]=0;
                }else{
                    arr[i][j]=INF;
                }
            }
        }
        for(int i=0;i<theCrossings.size();i++){
            //System.out.println(theCrossings.get(i));
            this.map.put(theCrossings.get(i).getId(),i);
            this.map1.put(i,theCrossings.get(i).getId());
        }
        for (CrossingPo theCrossing:theCrossings){
            if (theCrossing.getId1()!=null){
                arr[map.get(theCrossing.getId())]
                        [map.get(theCrossing.getId1())]
                        =Integer.valueOf(theCrossing.getWlong1());
                arr[map.get(theCrossing.getId1())]
                        [map.get(theCrossing.getId())]
                        =Integer.valueOf(theCrossing.getWlong1());
            }
            if (theCrossing.getId2()!=null){
                arr[map.get(theCrossing.getId())]
                        [map.get(theCrossing.getId2())]
                        =Integer.valueOf(theCrossing.getWlong2());
                arr[map.get(theCrossing.getId2())]
                        [map.get(theCrossing.getId())]
                        =Integer.valueOf(theCrossing.getWlong2());
            }
            if (theCrossing.getId3()!=null){
                arr[map.get(theCrossing.getId())]
                        [map.get(theCrossing.getId3())]
                        =Integer.valueOf(theCrossing.getWlong3());
                arr[map.get(theCrossing.getId3())]
                        [map.get(theCrossing.getId())]
                        =Integer.valueOf(theCrossing.getWlong3());
            }
            if (theCrossing.getId4()!=null){
                arr[map.get(theCrossing.getId())]
                        [map.get(theCrossing.getId4())]
                        =Integer.valueOf(theCrossing.getWlong4());
                arr[map.get(theCrossing.getId4())]
                        [map.get(theCrossing.getId())]
                        =Integer.valueOf(theCrossing.getWlong4());
            }
            if (theCrossing.getId5()!=null){
                arr[map.get(theCrossing.getId())]
                        [map.get(theCrossing.getId5())]
                        =Integer.valueOf(theCrossing.getWlong5());
                arr[map.get(theCrossing.getId5())]
                        [map.get(theCrossing.getId())]
                        =Integer.valueOf(theCrossing.getWlong5());
            }
            if (theCrossing.getId6()!=null){
                arr[map.get(theCrossing.getId())]
                        [map.get(theCrossing.getId6())]
                        =Integer.valueOf(theCrossing.getWlong6());
                arr[map.get(theCrossing.getId6())]
                        [map.get(theCrossing.getId())]
                        =Integer.valueOf(theCrossing.getWlong6());
            }
            if (theCrossing.getId7()!=null){
                arr[map.get(theCrossing.getId())]
                        [map.get(theCrossing.getId7())]
                        =Integer.valueOf(theCrossing.getWlong7());
                arr[map.get(theCrossing.getId7())]
                        [map.get(theCrossing.getId())]
                        =Integer.valueOf(theCrossing.getWlong7());
            }
            if (theCrossing.getId8()!=null){
                arr[map.get(theCrossing.getId())]
                        [map.get(theCrossing.getId8())]
                        =Integer.valueOf(theCrossing.getWlong8());
                arr[map.get(theCrossing.getId8())]
                        [map.get(theCrossing.getId())]
                        =Integer.valueOf(theCrossing.getWlong8());
            }
            if (theCrossing.getId9()!=null){
                arr[map.get(theCrossing.getId())]
                        [map.get(theCrossing.getId9())]
                        =Integer.valueOf(theCrossing.getWlong9());
                arr[map.get(theCrossing.getId9())]
                        [map.get(theCrossing.getId())]
                        =Integer.valueOf(theCrossing.getWlong9());
            }
            if (theCrossing.getId10()!=null){
                arr[map.get(theCrossing.getId())]
                        [map.get(theCrossing.getId10())]
                        =Integer.valueOf(theCrossing.getWlong10());
                arr[map.get(theCrossing.getId10())]
                        [map.get(theCrossing.getId())]
                        =Integer.valueOf(theCrossing.getWlong10());
            }
        }
        return arr;
    }

    public int[] connectStartAndEnd(Crossing startCrossing, Crossing endCrossing, TripModeDao tripModeDao){
        int[] arr=new int[2];
        double min=INF;
        String minId="";
        double min1=INF;
        String minId1="";
        List<CrossingPo> crossingPoList=tripModeDao.selectAll();

        for (CrossingPo crossingPo:crossingPoList){
            double temp=(Double.valueOf(crossingPo.getLon())-Double.valueOf(startCrossing.getLon()))
                    *(Double.valueOf(crossingPo.getLon())-Double.valueOf(startCrossing.getLon()))
                    +(Double.valueOf(crossingPo.getLat())-Double.valueOf(startCrossing.getLat()))
                    *(Double.valueOf(crossingPo.getLat())-Double.valueOf(startCrossing.getLat()));
            if (temp<min){
                min=temp;
                minId=crossingPo.getId();
            }
            double temp1=(Double.valueOf(crossingPo.getLon())-Double.valueOf(endCrossing.getLon()))
                    *(Double.valueOf(crossingPo.getLon())-Double.valueOf(endCrossing.getLon()))
                    +(Double.valueOf(crossingPo.getLat())-Double.valueOf(endCrossing.getLat()))
                    *(Double.valueOf(crossingPo.getLat())-Double.valueOf(endCrossing.getLat()));
            if (temp1<min1){
                min1=temp1;
                minId1=crossingPo.getId();
            }
        }
        arr[0]=MakeData.map.get(minId);
        arr[1]=MakeData.map.get(minId1);
        return arr;

    }

    public int judgeCrossing(String lon,String lat,TripModeDao tripModeDao){
        String answer=tripModeDao.judgeCrossing(lon,lat);
        System.out.println("answer:"+answer);
        if (answer==null){
            return 0;
        }
        return Integer.valueOf(answer);
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public Map<Integer, String> getMap1() {
        return map1;
    }

    public void setMap1(Map<Integer, String> map1) {
        this.map1 = map1;
    }

    public static Integer getINF() {
        return INF;
    }
}
