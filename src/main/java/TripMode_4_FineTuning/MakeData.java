package TripMode_4_FineTuning;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MakeData {
    public static final int INF=100000;
    //模拟数据存入数据库
    public void makeData() throws Exception {
        Random random=new Random();
        int dx[]=new int[]{0,0,1,-1};
        int dy[]=new int[]{1,-1,0,0};
        for(int i=0;i<10000;i++){
            int x=i/100;
            int y=i%100;
            Point point=new Point();
            point.setPOINT_ID(i);
            for(int j=0;j<4;j++){
                int tempx=x+dx[j];
                int tempy=y+dy[j];
                if(tempx>=0&&tempx<100&&tempy>=0&&tempy<100){
                    int tempPoint=tempx*100+tempy;
                    int tempValue=random.nextInt(10)+1;
                    if(j==0){
                        point.setPOINT_1(tempPoint);
                        point.setPOINT_1_VALUE(tempValue);
                    }else if(j==1){
                        point.setPOINT_2(tempPoint);
                        point.setPOINT_2_VALUE(tempValue);
                    }else if(j==2){
                        point.setPOINT_3(tempPoint);
                        point.setPOINT_3_VALUE(tempValue);
                    }else if(j==3){
                        point.setPOINT_4(tempPoint);
                        point.setPOINT_4_VALUE(tempValue);
                    }
                }
            }
            IniDB iniDB=new IniDB();
            Common common=new Common(iniDB.getConnection());
            common.addPoint(point);
        }
    }
    //从数据库取出数据，构造二维数组
    public int[][] useData() throws Exception {
        IniDB iniDB=new IniDB();
        Common common=new Common(iniDB.getConnection());
        Queue<Point>pointQueue=new LinkedList<>();
        pointQueue=common.selectAllPoint();
        int arr[][]=new int[10005][10005];
        for(int i=0;i<10005;i++){
            for(int j=0;j<10005;j++){
                if(i==j){
                    arr[i][j]=0;
                }else{
                    arr[i][j]=INF;
                }
            }
        }
        while (!pointQueue.isEmpty()){
            Point point=new Point();
            point=pointQueue.poll();
            int tempX,tempY,tempV;
            tempX=point.getPOINT_ID();
            if(point.getPOINT_1()!=0){
                tempY=point.getPOINT_1();
                tempV=point.getPOINT_1_VALUE();
                arr[tempX][tempY]=tempV;
            }
            if(point.getPOINT_2()!=0){
                tempY=point.getPOINT_2();
                tempV=point.getPOINT_2_VALUE();
                arr[tempX][tempY]=tempV;
            }
            if(point.getPOINT_3()!=0){
                tempY=point.getPOINT_3();
                tempV=point.getPOINT_3_VALUE();
                arr[tempX][tempY]=tempV;
            }
            if(point.getPOINT_4()!=0){
                tempY=point.getPOINT_4();
                tempV=point.getPOINT_4_VALUE();
                arr[tempX][tempY]=tempV;
            }
        }
        //输出二维矩阵
        /*for (int i=0;i<10000;i++){
            String s=i+"";
            for (int j=0;j<10005;j++){
                if(arr[i][j]!=INF){
                    s+=" j="+j+" v="+arr[i][j];
                }
            }
            System.out.println(s);
        }*/
        return arr;
    }

    //给点设置容量属性
    public void addPointCapacity() throws Exception {
        IniDB iniDB=new IniDB();
        Common common=new Common(iniDB.getConnection());
        Random random=new Random();
        for(int i=0;i<10000;i++){
            common.addPointCapacity(i,random.nextInt(5)+20);
        }
        common.getConnection().close();
    }

    //得到容量数组
    public int[] getPointCapacity() throws Exception {
        IniDB iniDB=new IniDB();
        Common common=new Common(iniDB.getConnection());
        int[] array=new int[10005];
        array=common.getPointCapacity();
        return array;
    }

    //向数据库存储最短路径坐标
    public void addShortest(int shortestId,int[] shortest,int k) throws Exception {
        IniDB iniDB=new IniDB();
        Common common=new Common(iniDB.getConnection());
        for (int i=0;i<=k;i++){
            int tempX=shortest[i]%100;
            int tempY=shortest[i]/100;
            System.out.println("tempx:"+tempX+"tempY:"+tempY);
            common.addShortest(shortestId,tempX,tempY);
        }
        iniDB.getConnection().close();
    }

    //从数据库读取全部路线
    public int[][] getAllShortest() throws Exception {
        IniDB iniDB=new IniDB();
        Common common=new Common(iniDB.getConnection());
        int[][] allShortest=new int[50][];
        allShortest=common.getAllShortest();
        return allShortest;
    }

    //向数据库存储微调后的路径坐标
    public void addUpdateShortest(int[][] shortest) throws Exception {
        IniDB iniDB=new IniDB();
        Common common=new Common(iniDB.getConnection());
        for (int i=0;i<50;i++){
            int j=0;
            while (shortest[i][j]!=0){
                int tempX=shortest[i][j]%100;
                int tempY=shortest[i][j]/100;
                common.addUpdateShortest(i,tempX,tempY);
                j++;
            }
        }
        common.getConnection().close();
    }
}
