package TripMode_1_Shortest_20190515;

import TripMode.po.CrossingPo;
import TripMode.po.TheCrossing;

import java.io.IOException;
import java.util.*;

public class MakeData {
    private Map<String, Integer> map=new HashMap<>();
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
