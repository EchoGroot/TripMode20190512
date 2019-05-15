package TripMode_3_BestTime;

import java.util.Scanner;

public class MakeArray {
    private int n;
    public int[][] getUserMarry(){
        int array[][]=new int[10][10];

        System.out.println("请输入节点个数");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int x,y,w;
        System.out.println("请输入每条边的起点，终点，权值，以-1，-1，-1结束");
        while(true){
            x=sc.nextInt();
            y=sc.nextInt();
            w=sc.nextInt();
            if(x==-1&&y==-1&&w==-1){
                break;
            }
            array[x][y]=w;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j&&array[i][j]==0){
                    array[i][j]=-1;
                }
            }
        }
        System.out.println("输入的邻接矩阵为：");
        for(int i=0;i<n;i++) {
            String temp="";
            for (int j = 0; j < n; j++) {
                temp+=Integer.toString(array[i][j])+"  ";
            }
            System.out.println(temp);
        }
        return array;
    }
    public int getN() {
        return n;
    }
}
