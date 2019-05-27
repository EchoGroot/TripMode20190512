package TripMode_3_BestTime;

import java.util.Random;
import java.util.Scanner;

public class App {
    public void getRandom(){
        String temp="122";
        Random random=new Random();
        for (int i=0;i<50;i++){
            temp+= Integer.toString(random.nextInt(10));
            if ((i+1)%10==0){
                temp+="\n";
            }
        }
        System.out.println(temp);
    }
    public void dijkstra(){
        int array[][]=new int[10][];
        int n;
        MakeArray makeArray=new MakeArray();
        array=makeArray.getUserMarry();
        n=makeArray.getN();
        System.out.println("请输入起点和终点");
        Scanner sc=new Scanner(System.in);
        int start=sc.nextInt();
        int end=sc.nextInt();
        Dijkstra dijkstra=new Dijkstra(array,n);
        dijkstra.getShortest(start,end);
    }
    public void bestTime(){
        BestTime btTime= new BestTime();
        btTime.setValue();
    }
    public void tripMode(){
        int array[][]=new int[7][3];
        DataArray dataArray=new DataArray();
        array=dataArray.getMarry();
        double carMin=10000,carTime=0,busMin=10000,busTime=0,lightRailMin=10000,lightRailTime=0;
        for (int i=0;i<7;i++){
            if (array[i][1]+array[i][0]>890){
                if(carMin>(0.6*array[i][1]+1*array[i][1]+2.94*array[i][1]+2*(array[i][1]+array[i][0]-860))){
                    carMin=0.6*array[i][1]+1*array[i][1]+2.94*array[i][1]+2*(array[i][1]+array[i][0]-860);
                    carTime=array[i][0];
                }
                if(busMin>(2*array[i][2]*array[i][1]+2.94*array[i][1]+2+2*(array[i][1]+array[i][0]-860))){
                    busMin=2*array[i][2]*array[i][1]+2.94*array[i][1]+2+2*(array[i][1]+array[i][0]-860);
                    busTime=array[i][0];
                }
                if(lightRailMin>(2*array[i][2]*array[i][1]+2.94*array[i][1]+4+2*(array[i][1]+array[i][0]-860))){
                    lightRailMin=2*array[i][2]*array[i][1]+2.94*array[i][1]+4+2*(array[i][1]+array[i][0]-860);
                    lightRailTime=array[i][0];
                }
            }else {
                if(carMin>(0.6*array[i][1]+1*array[i][1]+2.94*array[i][1]-0.5*(860-array[i][1]-array[i][0]))){
                    carMin=0.6*array[i][1]+1*array[i][1]+2.94*array[i][1]-0.5*(860-array[i][1]-array[i][0]);
                    carTime=array[i][0];
                }
                if(busMin>(2*array[i][2]*array[i][1]+2.94*array[i][1]+2-0.5*(860-array[i][1]-array[i][0]))){
                    busMin=2*array[i][2]*array[i][1]+2.94*array[i][1]+2-0.5*(860-array[i][1]-array[i][0]);
                    busTime=array[i][0];
                }
                if(lightRailMin>(2*array[i][2]*array[i][1]+2.94*array[i][1]+4-0.5*(860-array[i][1]-array[i][0]))){
                    lightRailMin=2*array[i][2]*array[i][1]+2.94*array[i][1]+4-0.5*(860-array[i][1]-array[i][0]);
                    lightRailTime=array[i][0];
                }
            }
        }
        System.out.println("乘坐小汽车最少需要的成本为："+carMin);
        System.out.println("乘坐小汽车最优的出行时间为："+carTime+"\n");
        System.out.println("乘坐公交车最少需要的成本为："+busMin);
        System.out.println("乘坐公交车最优的出行时间为："+busTime+"\n");
        System.out.println("乘坐轻轨最少需要的成本为："+lightRailMin);
        System.out.println("乘坐轻轨最优的出行时间为："+lightRailTime);

    }
    public static void main(String args[]){
        System.out.println();
        App app=new App();
        //产生随机数
        //app.getRandom();
        //实现dijkstra算法
        //app.dijkstra();
        //最佳出行时间
        app.tripMode();
        //app.bestTime();



    }
}
