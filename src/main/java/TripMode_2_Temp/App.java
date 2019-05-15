package TripMode_2_Temp;

import java.util.Scanner;

public class App {
    public static void main(String args[]) throws Exception {
        MakeData2 makeData2=new MakeData2();
        int arr[][]=new int[10005][10005];
        arr=makeData2.useData();
        DijkstraHeap dijkstraHeap=new DijkstraHeap();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入起点和终点（0-9999）");
        int starttemp=sc.nextInt();
        int endtemp=sc.nextInt();
        dijkstraHeap.dijkstra(arr,starttemp,endtemp);
        double a=dijkstraHeap.getTempDist()+30;
        double b=dijkstraHeap.getTempDist()+20;
        double c=dijkstraHeap.getTempDist()+10;
        double k=dijkstraHeap.getTempDist()/100+1;
        double q;
        if (k>3){
            q=-0.5*k;
        }else {
            q=0.78*k;
        }
        double atemp=0.6*a+1*a+2.94*a;
        double btemp=0.5*q*b+2.94*b+2;
        double ctemp=0.7*q*c+2.94*c+4;


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



        if (atemp<=btemp&&atemp<=ctemp){
            System.out.println("最佳出行方式为乘坐小汽车");
            String t="";
            t+=carTime;
            System.out.println("乘坐小汽车最优的出行时间为：上午"+t.substring(0,1)+"点"+t.substring(1,3)+"分");
        }else if (btemp<=atemp&&btemp<=ctemp){
            System.out.println("最佳出行方式为乘坐公交车");
            String t="";
            t+=busTime;
            System.out.println("乘坐公交车最优的出行时间为：上午"+t.substring(0,1)+"点"+t.substring(1,3)+"分");
        }else if (ctemp<=atemp&&ctemp<=atemp){
            System.out.println("最佳出行方式为乘坐轻轨");
            String t="";
            t+=lightRailTime;
            System.out.println("乘坐轻轨最优的出行时间为：上午"+t.substring(0,1)+"点"+t.substring(1,3)+"分");
        }
    }
}
