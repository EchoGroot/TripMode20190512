package TripMode_2_Temp;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class DijkstraHeap {
    public static final int INF=100000;
    public int[] dist=new int[10000];
    public int[] s=new int[10000];
    public int[] path=new int[10000];
    public static HashSet<PointVector> pointVectorSet=new HashSet<>();
    private int start;
    private int tempDist;

    public void dijkstra(int arr[][],int start,int end){
        this.start=start;
        for (int i=0;i<10000;i++){
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
            for(int i=0;i<10000;i++){
                if(s[i]==0&&dist[i]>arr[u][i]+node.cost){
                    dist[i]=arr[u][i]+node.cost;
                    nodeQueue.add(new Node(i,dist[i]));
                    path[i]=u;
                }
            }
        }
        tempDist=dist[end];
        //输出start到end的路径和距离
        /*String tempDist="距离为：";
        tempDist+=dist[end];
        System.out.println(tempDist);
        int shortest[]=new int[10000];
        int k=0;
        shortest[k]=end;
        while(path[shortest[k]]!=start){
            k++;
            shortest[k]=path[shortest[k-1]];
        }
        k++;
        shortest[k]=start;
        String temp="路径为：";
        for(;k>=0;k--){
            temp+=Integer.toString(shortest[k]);
            if(k!=0){
                temp+="->";
            }
        }
        System.out.println(temp);*/
    }

    public void storeShortest(int start) throws Exception {
        IniDB iniDB=new IniDB();
        Common common=new Common(iniDB.getConnection());
        common.shortest(start,dist,path);
    }

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



    public int[] getDist(){
        return dist;
    }

    public int[] getPath() {
        return path;
    }

    public static int getINF() {
        return INF;
    }



    public int[] getS() {
        return s;
    }

    public int getTempDist() {
        return tempDist;
    }

    public void setTempDist(int tempDist) {
        this.tempDist = tempDist;
    }

    public static HashSet<PointVector> getPointVectorSet() {
        return pointVectorSet;
    }

    public static void setPointVectorSet(HashSet<PointVector> pointVectorSet) {
        DijkstraHeap.pointVectorSet = pointVectorSet;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
