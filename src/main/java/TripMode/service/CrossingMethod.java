package TripMode.service;

import TripMode.model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class CrossingMethod {

    private static int COUNTS=0;
    private static int COUNTSBIGTHANONE=0;
    private Set<String> nodes=new HashSet<>();
    private Set<Way> ways=new HashSet<>();
    private Set<String> crossings=new HashSet<>();

    public Set<String> getNodes(Osm osm){
        for (Node node:osm.getNode()){
            Map map=node.getCode();
            String id= (String) map.get(QName.valueOf("id"));
            nodes.add(id);
        }
        //System.out.println(nodes.toString());
        return nodes;
    }

    public Set<Way> getWays(Osm osm){
        for (Way way:osm.getWay()){
            System.out.println(way.getTagList());
            for (Tag tag:way.getTagList()){
                if (tag.getCode().get(QName.valueOf("k")).equals("highway")){
                    ways.add(way);
                    break;
                }
            }
        }
        return ways;
    }

    //获得所有路口
    public Set<String> getCrossings(Osm osm){
        Set<String> nodes=getNodes(osm);
        Set<Way> ways=getWays(osm);
        Set<String> crossings=new HashSet<>();
        for(String node:this.nodes){
            int count=0;
            for (Way way:this.ways){
                List<Nd> nds=way.getNdList();
                for (Nd nd:nds){
                    String ref= (String) nd.getCode().get(QName.valueOf("ref"));
                    if (node.equals(ref)) {
                        count++;
                        break;
                    }
                }
            }
            if (count>1){
                //System.out.println("count:"+count);
                this.crossings.add(node);
            }
        }
        System.out.println("crossings.size:"+this.crossings.size());
        System.out.println("crossings:"+this.crossings.toString());
        return this.crossings;
    }

    //获得路口的邻接信息
    public Set<Crossing> getConnection(Osm osm) throws IOException {
        Connection.osm=osm;
        Set<Crossing> crossingSet=new HashSet<>();
        getCrossings(osm);
        //System.out.println("crossings:"+this.crossings.toString());
        //int limtTemp=20;
        System.out.println("ways.size:"+ways.size());
        for (Way way:this.ways){
            /*System.out.println("limtTemp:"+--limtTemp);
            if (limtTemp<0){
                break;
            }*/
            ArrayList<String> crossingArray=new ArrayList<>();
            for (Nd nd:way.getNdList()){
                String ref= (String) nd.getCode().get(QName.valueOf("ref"));
                //System.out.println("ref:"+ref);
                //System.out.println(this.crossings.toString());
                if (this.crossings.contains(ref)){
                    //System.out.println("+1");
                    crossingArray.add(ref);
                }
            }
            //store
            for (int j=0;j<crossingArray.size()-1;j++){
                //交换首尾
                int crossingFlag=0;
                for (Crossing crossing:crossingSet){
                    //System.out.println("notjudge:crossing.getId()"+crossing.getId()+" crossingArray.get(j)"+crossingArray.get(j));
                    if (crossing.getId().equals(crossingArray.get(j))){
                        System.out.println("equal:crossing.getId()"+crossing.getId()+" crossingArray.get(j)"+crossingArray.get(j));
                        int flag=0;
                        for (Connection connection:crossing.getConnections()){
                            if (connection.getConnectionId().equals(crossingArray.get(j+1))){
                                flag=1;
                                break;
                            }
                        }
                        //*************
                        if(flag==0){
                            String[] distance=getDistance(crossingArray.get(j),crossingArray.get(j+1),osm);
                            crossing.connections.add(new Connection(crossingArray.get(j+1),distance[3],distance[4],distance[0]));
                        }
                        crossingFlag=1;
                        break;
                    }
                }
                if (crossingFlag==0){
                    System.out.println("no 1   :crossingArray.get(j)"+crossingArray.get(j));
                    Crossing crossing=getLocation(osm,crossingArray.get(j));
                    //*************
                    String[] distance=getDistance(crossingArray.get(j),crossingArray.get(j+1),osm);
                    crossing.connections.add(new Connection(crossingArray.get(j+1),distance[3],distance[4],distance[0]));
                    crossingSet.add(crossing);
                    System.out.println("成功添加"+crossing.getId());
                }
                //交换首尾
                crossingFlag=0;
                for (Crossing crossing:crossingSet){
                    if (crossing.getId().equals(crossingArray.get(j+1))){
                        System.out.println("equal:crossing.getId()"+crossing.getId()+" crossingArray.get(j+1)"+crossingArray.get(j+1));
                        int flag=0;
                        for (Connection connection:crossing.getConnections()){
                            if (connection.getConnectionId().equals(crossingArray.get(j))){
                                flag=1;
                                break;
                            }
                        }
                        if(flag==0){
                            //*************
                            String[] distance=getDistance(crossingArray.get(j+1),crossingArray.get(j),osm);
                            crossing.connections.add(new Connection(crossingArray.get(j),distance[3],distance[4],distance[0]));
                        }
                        crossingFlag=1;
                        break;
                    }
                }
                if (crossingFlag==0){
                    System.out.println("no 2   :crossingArray.get(j+1)"+crossingArray.get(j+1));
                    if (crossingArray.get(j+1).equals("1143803255")){
                        System.out.println("///////////////////////////////////////////////////");
                        System.out.println(crossingSet);
                    }
                    Crossing crossing=getLocation(osm,crossingArray.get(j+1));
                    //*************
                    String[] distance=getDistance(crossingArray.get(j+1),crossingArray.get(j),osm);
                    crossing.connections.add(new Connection(crossingArray.get(j),distance[3],distance[4],distance[0]));
                    crossingSet.add(crossing);
                    System.out.println("成功添加"+crossing.getId());
                }
            }
        }
        System.out.println(crossingSet);
        return crossingSet;
    }

    //利用高德API得到两点的距离
    public String[] getDistance(String start,String  end,Osm osm) throws IOException {
        String[] distance=new String[5];

        //根据id查找经纬度  起点 j
        Crossing crossing=getLocation(osm,start);
        String lonTempStart = crossing.getLon();
        String latTempStart = crossing.getLat();
        distance[1]=lonTempStart;
        distance[2]=latTempStart;

        //根据id查找经纬度  终点 j+1
        Crossing crossing1=getLocation(osm,end);
        String lonTempEnd = crossing1.getLon();
        String latTempEnd = crossing1.getLat();
        distance[3]=latTempEnd;
        distance[4]=lonTempEnd;

        //发送http请求 得到xml
        COUNTS++;
        System.out.println("正在发送第"+COUNTS+"次高德API请求");
        String responceStr=HttpClient.httpGet("https://restapi.amap.com/v3/direction/walking?origin="+lonTempStart+","+latTempStart+"&destination="+lonTempEnd+","+latTempEnd+"&output=xml&key=c6bfc5bf6c87600f79b4a461cbb760a8");
        System.out.println("请求成功");
        //xml转JavaBean
        Response response=new Response();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            response=(Response) unmarshaller.unmarshal(new StringReader(responceStr));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println(responceStr);
        System.out.println(response);
        distance[0]=response.getRoute().getPaths().getPaths().get(0).getDistance();
        System.out.println("Distance:"+distance[0]);
        if (Integer.valueOf(distance[0].toString())>1){
            COUNTSBIGTHANONE++;
            System.out.println("COUNTSBIGTHANONE:"+COUNTSBIGTHANONE);
        }
        return distance;
    }

    //根据id查找经纬度
    public Crossing getLocation(Osm osm,String id){
        String lonTemp = "";
        String latTemp = "";
        for (Node node:osm.getNode()){
            if (node.getCode().get(QName.valueOf("id")).equals(id)){
                lonTemp= (String) node.getCode().get(QName.valueOf("lon"));
                latTemp= (String) node.getCode().get(QName.valueOf("lat"));
                break;
            }
        }
        return new Crossing(id,latTemp,lonTemp);
    }
}
