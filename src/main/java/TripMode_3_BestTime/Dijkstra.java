package TripMode_3_BestTime;

public class Dijkstra {
    public int n;
    public int v;
    public static final int INF=100000;
    public int array[][]=new int[10000][10000];
    public int path[]=new int[10000];    //存储路径的数组
    public int s[]=new int[10000];         //起点位置
    public int dist[]=new int[10000];       //最短路径长度
    public Dijkstra(int array[][],int n){
        this.array=array;
        this.n=n;
    };
    public void initialize(){
        for(int i=0;i<n;i++){
            s[i]=0;
            dist[i]=array[v][i];
            if(dist[i]!=INF&&i!=v){
                path[i]=v;
            }else{
                path[i]=-1;
            }
        }
        s[v]=1;
        dist[v]=0;
        for (int i=0;i<n-1;i++){
            int flag=1;
            int min=0;
            int u=v;
            for(int j=0;j<n;j++){
                if(flag==1&&s[j]!=1&&dist[j]!=INF){
                    min=dist[j];
                    u=j;
                    flag=0;
                }
                if(s[j]!=1&&dist[j]<min&&dist[j]!=INF){
                    min=dist[j];
                    u=j;
                }
            }
            s[u]=1;
            for(int k=0;k<n;k++){
                if (dist[k]!=INF){
                    if(array[u][k]!=INF&&dist[u]+array[u][k]<dist[k]&&s[k]!=1){
                        dist[k]=dist[u]+array[u][k];
                        path[k]=u;
                    }
                }else {
                    if(array[u][k]!=INF&&s[k]!=1){
                        dist[k]=dist[u]+array[u][k];
                        path[k]=u;
                    }
                }
            }
        }
    }
    public void getShortest(int start,int end){
        this.v=start;
        initialize();
        System.out.println(v+"点到"+end+"点的最短路径长度是："+dist[end]);
        int shortest[]=new int[n];
        int k=0;
        shortest[k]=end;
        while(path[shortest[k]]!=v){
            k++;
            shortest[k]=path[shortest[k-1]];
        }
        k++;
        shortest[k]=v;
        String temp="路径为：";
        for(;k>=0;k--){
            temp+=Integer.toString(shortest[k]);
            if(k!=0){
                temp+="->";
            }
        }
        System.out.println(temp);

        /*for(int i=0;i<n;i++){
            System.out.println(path[i]+" ");
        }*/
    }
}
