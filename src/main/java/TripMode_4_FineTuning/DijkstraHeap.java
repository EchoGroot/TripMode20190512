package TripMode_4_FineTuning;

import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraHeap {
    public static final int INF=100000;
    public int[] dist=new int[10000];
    public int[] s=new int[10000];
    public int[] path=new int[10000];
    public int[] shortest=new int[10000];
    private int tempDist;
    public int k=0;
    private int start;

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



        //输出start到end的路径和距离

        tempDist=dist[end];
        //System.out.println(tempDist);


        shortest[k]=end;
        while(path[shortest[k]]!=start){
            k++;
            //System.out.println("检测k："+k+" shortest[k-1]:"+shortest[k-1]+"  path[shortest[k]]:"+path[shortest[k]]);
            shortest[k]=path[shortest[k-1]];
        }
        k++;
        shortest[k]=start;
        /*String temp="路径为：";
        int tempK=k;
        //System.out.println("k:"+k);
        for(;tempK>=0;tempK--){
            temp+=Integer.toString(shortest[tempK]);
            if(tempK!=0){
                temp+="->";
            }
        }
        System.out.println(temp);*/
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

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int[] getShortest() {
        return shortest;
    }

    public int getTempDist() {
        return tempDist;
    }

    public void setTempDist(int tempDist) {
        this.tempDist = tempDist;
    }

    public void setShortest(int[] shortest) {
        this.shortest = shortest;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }


}
