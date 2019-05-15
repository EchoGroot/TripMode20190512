package TripMode_2_Temp;

public class Node implements Comparable<Node>{
    public int to;
    public int cost;
    public Node(int to,int cost){
        this.to=to;
        this.cost=cost;
    }
    @Override
    public int compareTo(Node o) {
        return this.cost-o.cost;
    }
}
