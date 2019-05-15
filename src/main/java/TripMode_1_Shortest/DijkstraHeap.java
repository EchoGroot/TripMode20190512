package TripMode_1_Shortest;

import java.util.*;

public class DijkstraHeap {
    public static final Integer INF=100000;
    public ArrayList<Integer> dist=new ArrayList<>();
    public ArrayList<Integer> s=new ArrayList<>();
    public ArrayList<Integer> path=new ArrayList<>();
    //public static HashSet<PointVector> pointVectorSet=new HashSet<>();
    private Integer start;

    public void dijkstra(int arr[][],int start,int end){
        this.start=start;
        for (int i=0;i<10000;i++){
            dist.set(i,INF);
        }
        Queue<Node> nodeQueue=new PriorityQueue<>();
        nodeQueue.add(new Node(start,0));
        dist.set(start,0);
        path.set(start,-1);
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();
            int u = node.to;
            if(s.get(u)==1)
                continue;
            s.set(u,1);
            for(int i=0;i<10000;i++){
                if(s.get(i)==0&&dist.get(i)>arr[u][i]+node.cost){
                    dist.set(i,arr[u][i]+node.cost);
                    nodeQueue.add(new Node(i,dist.get(i)));
                    path.set(i,u);
                }
            }
        }
        //输出start到end的路径和距离
        String tempDist="距离为：";
        tempDist+=dist.get(end);
        System.out.println(tempDist);
        ArrayList<Integer> shortest=new ArrayList<>();
        int k=0;
        shortest.set(k,end);
        while(path.get(shortest.get(k))!=start){
            k++;
            shortest.set(k,path.get(shortest.get(k-1)));
        }
        k++;
        shortest.set(k,start);
        String temp="路径为：";
        for(;k>=0;k--){
            temp+=Integer.toString(shortest.get(k));
            if(k!=0){
                temp+="->";
            }
        }
        System.out.println(temp);
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

    public static Integer getINF() {
        return INF;
    }

    public ArrayList<Integer> getDist() {
        return dist;
    }

    public void setDist(ArrayList<Integer> dist) {
        this.dist = dist;
    }

    public ArrayList<Integer> getS() {
        return s;
    }

    public void setS(ArrayList<Integer> s) {
        this.s = s;
    }

    public ArrayList<Integer> getPath() {
        return path;
    }

    public void setPath(ArrayList<Integer> path) {
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
