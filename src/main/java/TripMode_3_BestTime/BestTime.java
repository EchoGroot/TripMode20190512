package TripMode_3_BestTime;

import java.util.Random;
import java.util.Scanner;

public class BestTime {
    public int array[][]=new int[10][10];
    public int array2[]=new int[10];
    int start,end,n,x,y;
    int temp,m;
    public  void setValue(){
        MakeArray makeArray=new MakeArray();
        array=makeArray.getUserMarry();
        n=makeArray.getN();
        System.out.println("请输入起点和终点");
        Scanner sc=new Scanner(System.in);
        start=sc.nextInt();
        end=sc.nextInt();
        Dijkstra dijkstra=new Dijkstra(array,n);
        dijkstra.getShortest(start,end);
        array2[0]=dijkstra.dist[end];
        for(int i=0;i<9;i++){
            for(int j=0;j<10;j++){
                for(int k=0;k<10;k++){
                    Random random=new Random();
                    x=random.nextInt(2);
                    y=random.nextInt(3)-1;
                    if(array[j][k]>=3){
                        array[j][k]=array[j][k]+y;
                    }
                    else if(array[j][k]>0){
                        array[j][k]=array[j][k]+x;
                    }
                }
            }
            Dijkstra dijkstraa=new Dijkstra(array,n);
            dijkstraa.getShortest(start,end);
            array2[i+1]=dijkstraa.dist[end];

        }
        for(int i=0;i<9;i++){
            temp=array2[0];m=0;
            if(array2[i+1]<array2[i]){
                temp=array2[i+1];
                m=i+1;
            }
        }
        System.out.println("最佳出行时间为： 7："+5*m);
        System.out.println("所花费时间为："+temp+"分钟");
    }

}
