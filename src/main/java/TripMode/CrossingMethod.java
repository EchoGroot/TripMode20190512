package TripMode;

import TripMode.Model.Nd;
import TripMode.Model.Node;
import TripMode.Model.Osm;
import TripMode.Model.Way;

import javax.xml.namespace.QName;
import java.util.*;

public class CrossingMethod {

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
            ways.add(way);
        }
        return ways;
    }

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

    public void getConnection(Osm osm){
        getCrossings(osm);
        int i=0;
        //System.out.println("crossings:"+this.crossings.toString());
        for (Way way:this.ways){
            ArrayList<String> crossingArray=new ArrayList<>();
            for (Nd nd:way.getNdList()){
                String ref= (String) nd.getCode().get(QName.valueOf("ref"));
                System.out.println("ref:"+ref);
                //System.out.println(this.crossings.toString());
                if (this.crossings.contains(ref)){
                    System.out.println("+1");
                    crossingArray.add(ref);
                }
            }
            //store
            for (int j=0;j<crossingArray.size()-1;j++){

            }
            System.out.println("------------------"+i+"-----------------");
            System.out.println("crossingArray.toString():"+crossingArray.toString());
            System.out.println("-------------------------------------");
            i++;
            if (i==318){
                for (String refTemp:crossingArray){
                    for (Node node:osm.getNode()){
                        if (node.getCode().get(QName.valueOf("id")).equals(refTemp)){
                            System.out.println("id:"+node.getCode().get(QName.valueOf("id")));
                            System.out.print(node.getCode().get(QName.valueOf("lon")));
                            System.out.println(","+node.getCode().get(QName.valueOf("lat")));
                            break;
                        }
                    }
                }
            }
        }
    }
}
