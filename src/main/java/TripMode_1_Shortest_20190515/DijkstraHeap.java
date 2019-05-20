package TripMode_1_Shortest_20190515;

import TripMode.dao.TripModeDao;
import TripMode.model.Crossing;
import TripMode.model.Osm;
import TripMode.po.CrossingPo;
import TripMode.service.CrossingMethod;
import TripMode_1_Shortest.Common;
import TripMode_1_Shortest.IniDB;
import TripMode_1_Shortest.Shortest;
import TripMode_2_Temp.Node;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class DijkstraHeap {
    public static final Integer INF=100000;
    public int[] dist;
    public int[] s;
    public int[] path;
    //public static HashSet<PointVector> pointVectorSet=new HashSet<>();
    private Integer start;

    public void dijkstra(int arr[][], int start, int end, int count, TripModeDao tripModeDao){

        dist=new int[count];
        s=new int[count];
        path=new int[count];

        this.start=start;
        for (int i=0;i<count;i++){
            dist[i]=INF;
        }
        Queue<Node> nodeQueue=new PriorityQueue<>();
        nodeQueue.add(new Node(start,0));
        dist[start]=0;
        path[start]=-1;
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();
            int u = node.to;
            if (s[u] == 1)
                continue;
            s[u] = 1;
            for(int i=0;i<count;i++){
                if(s[i]==0&&dist[i]>arr[u][i]+node.cost){
                    dist[i]=arr[u][i]+node.cost;
                    nodeQueue.add(new Node(i,dist[i]));
                    path[i]=u;
                }
            }
        }
        //输出start到end的路径和距离
        String tempDist="距离为：\n";
        tempDist+=dist[end];
        System.out.println(tempDist);
        int shortest[]=new int[count];
        int k=0;
        shortest[k]=end;
        while(path[shortest[k]]!=start){
            k++;
            shortest[k]=path[shortest[k-1]];
        }
        k++;
        shortest[k]=start;
        CrossingMethod crossingMethod=new CrossingMethod();
        System.out.println("路径为：");
        String temp="https://restapi.amap.com/v3/staticmap?zoom=15&size=1024*1024&paths=7,0x0000ff,1,,:";
        for(;k>=0;k--){
            CrossingPo crossingPo=tripModeDao.getLocation(MakeData.map1.get(shortest[k]));
            temp+=crossingPo.getLon() +","
                    +crossingPo.getLat();
            if (k!=0){
                temp+=";";
            }
        }
        temp+="&key=c6bfc5bf6c87600f79b4a461cbb760a8";
        System.out.println(temp);
    }

    /*public void storeShortest(int start) throws Exception {
        IniDB iniDB=new IniDB();
        Common common=new Common(iniDB.getConnection());
        common.shortest(start,dist,path);
    }*/

    public void getShortest(int start,int end) throws Exception {
        System.out.println("进入getShortest");
        IniDB iniDB=new IniDB();
        Common common=new Common(iniDB.getConnection());
        System.out.println("进入common.getShortest");
        Shortest shortest=common.getShortest(start, end);
        System.out.println("*************************************************************************");
        Stack<Integer> stack=shortest.getPath();
        String s=stack.pop()+"";
        while (!stack.isEmpty()){
            s+="->"+stack.pop();
        }
        System.out.println("最短路径为");
        System.out.println(s);
        System.out.println("最短距离为");
        System.out.println(shortest.getDist());
    }

    public static Integer getINF() {
        return INF;
    }

    public int[] getDist() {
        return dist;
    }

    public void setDist(int[] dist) {
        this.dist = dist;
    }

    public int[] getS() {
        return s;
    }

    public void setS(int[] s) {
        this.s = s;
    }

    public int[] getPath() {
        return path;
    }

    public void setPath(int[] path) {
        this.path = path;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

/*public static HashSet<PointVector> getPointVectorSet() {
        return pointVectorSet;
    }

    public static void setPointVectorSet(HashSet<PointVector> pointVectorSet) {
        DijkstraHeap.pointVectorSet = pointVectorSet;
    }*/

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
