package TripMode_3_BestTime;

import java.util.Random;

public class DataArray {
    private int array[][]=new int[7][3];
    private int array1[][][]=new int[10][7][3];
    public int[][] getMarry(){
        for(int i=0;i<10;i++){
            int temp=800;
            Random random=new Random();
            System.out.println("第"+(i+1)+"个矩阵：");
            for(int j=0;j<7;j++){
                String temp2="出行时间：";
                array1[i][j][0]=temp;
                array1[i][j][1]=random.nextInt(30)+30;
                array1[i][j][2]=random.nextInt(10);
                temp+=5;
                temp2+=Integer.toString(array1[i][j][0])+" 总花费"
                        +Integer.toString(array1[i][j][1])+" 拥挤程度"
                        +Integer.toString(array1[i][j][2]);
                System.out.println(temp2);
            }
        }
        int temp=800;
        for(int j=0;j<7;j++){
            int sumTime=0,sumK=0;
            for (int i=0;i<10;i++){
                sumTime+=array1[i][j][1];
                sumK+=array1[i][j][2];
            }
            array[j][2]=sumK/10;
            array[j][1]=sumTime/10;
            array[j][0]=temp;
            temp+=5;
        }
        System.out.println("平均值矩阵为：");
        for(int i=0;i<7;i++){
            String temp1="出行时间：";
//            for (int j=0;j<3;j++){
//                temp1+=Integer.toString(array[i][j])+" ";
//            }
            temp1+=Integer.toString(array[i][0])+" 总花费"
                    +Integer.toString(array[i][1])+" 拥挤程度"
                    +Integer.toString(array[i][2]);
            System.out.println(temp1);
        }
        return array;
    }
}
