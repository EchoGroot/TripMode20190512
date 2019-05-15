package TripMode_4_FineTuning;

public class App {
    public static void main(String args[]) throws Exception {
//        MakeData2 makeData2=new MakeData2();
//        int arr[][]=new int[10005][10005];
//        Vector<PointVector> pointVectors=new Vector<>();
        //向数据库插入数据
        //makeData2.makeData();
        //从数据库取出数据，构造二维数组
//        arr=makeData2.useData();

//step2

        //测试dijkstra计算两点
        /*long startTime=System.currentTimeMillis();   //获取开始时间
        MakeData makeData2=new MakeData();
        int arr[][]=new int[10005][10005];
        arr=makeData2.useData();
        long midTime=System.currentTimeMillis(); //获取结束时间
        DijkstraHeap dijkstraHeap=new DijkstraHeap();
        dijkstraHeap.dijkstra(arr,200,6584);
        long endTime=System.currentTimeMillis(); //获取结束时间
        Dijkstra dijkstra=new Dijkstra(arr,10000);
        dijkstra.getShortest(200,6584);
        long end2Time=System.currentTimeMillis(); //获取结束时间
        System.out.println("从数据库提取数据进内存并构造二维矩阵的时间： "+(midTime-startTime)+"ms");
        System.out.println("堆优化程序运行时间： "+(endTime-midTime)+"ms");
        System.out.println("未优化程序运行时间： "+(end2Time-endTime)+"ms");*/

//step3

        MakeData makeData=new MakeData();
        //给点设置容量属性
        //makeData.addPointCapacity();

        /*int[][] arr=new int[10005][10005];
        int[][] arrTemp=new int[10005][10005];
        int[] arrayCapacity=new int[10005];
        int[] arrayCapacityTemp=new int[10005];
        arr=makeData.useData();
        //二维数组深拷贝
        for (int i=0;i<arr.length;i++){
            arrTemp[i]=arr[i].clone();
        }*/

        //得到容量数组
        /*arrayCapacity=makeData.getPointCapacity();
        for (int i=0;i<10000;i++){
            for (int j=0;j<10000;j++){
                if(arrTemp[i][j]!=DijkstraHeap.getINF()){
                    arrTemp[i][j]+=(7-arrayCapacity[i]);
                }
                if(arrTemp[j][i]!=DijkstraHeap.getINF()){
                    arrTemp[j][i]+=(7-arrayCapacity[i]);
                }
            }
        }*/

        //测试arrayTemp
        /*for (int k=0;k<50;k++){
            DijkstraHeap dijkstraHeap=new DijkstraHeap();
            dijkstraHeap.dijkstra(arrTemp,2947,3486);
            int[] shortestTemp=new int[10005];
            shortestTemp=dijkstraHeap.getShortest();
            System.out.println("dijkstraHeap.getK()"+dijkstraHeap.getK());
            for (int i=0;i<=dijkstraHeap.getK();i++){
                arrayCapacityTemp[shortestTemp[i]]++;
                if (arrayCapacityTemp[shortestTemp[i]]>arrayCapacity[shortestTemp[i]]*0.5
                &&arrayCapacityTemp[shortestTemp[i]]<=arrayCapacity[shortestTemp[i]]*0.7){
                    for (int j=0;j<10000;j++){
                        if(arrTemp[shortestTemp[i]][j]!=DijkstraHeap.getINF()){
                            arrTemp[shortestTemp[i]][j]++;
                        }
                        if(arrTemp[j][shortestTemp[i]]!=DijkstraHeap.getINF()){
                            arrTemp[j][shortestTemp[i]]++;
                        }
                    }
                }else if (arrayCapacityTemp[shortestTemp[i]]>arrayCapacity[shortestTemp[i]]*0.7
                        &&arrayCapacityTemp[shortestTemp[i]]<=arrayCapacity[shortestTemp[i]]){
                    for (int j=0;j<10000;j++){
                        if(arrTemp[shortestTemp[i]][j]!=DijkstraHeap.getINF()){
                            arrTemp[shortestTemp[i]][j]+=2;
                        }
                        if(arrTemp[j][shortestTemp[i]]!=DijkstraHeap.getINF()){
                            arrTemp[j][shortestTemp[i]]+=2;
                        }
                    }
                }else if (arrayCapacityTemp[shortestTemp[i]]>arrayCapacity[shortestTemp[i]]){
                    for (int j=0;j<10000;j++){
                        if(arrTemp[shortestTemp[i]][j]!=DijkstraHeap.getINF()){
                            arrTemp[shortestTemp[i]][j]+=3;
                        }
                        if(arrTemp[j][shortestTemp[i]]!=DijkstraHeap.getINF()){
                            arrTemp[j][shortestTemp[i]]+=3;
                        }
                    }
                }

            }
            //添加最短路径到数据库
            makeData.addShortest(k,shortestTemp,dijkstraHeap.getK());
        }*/

        //模拟紧急情况微调
        //从数据库读取全部路线
        int arr[][]=new int[10005][10005];
        arr=makeData.useData();
        DijkstraHeap dijkstraHeap=new DijkstraHeap();
        System.out.println("假设起点为：3486，终点为：2947，发生紧急情况的点为：2968");
        dijkstraHeap.dijkstra(arr,2947,3486);
        int[] shortestTemp=new int[10005];
        shortestTemp=dijkstraHeap.getShortest();

        System.out.println("原路径为：");
        int j=0;
        while(shortestTemp[j]!=0){
            System.out.print(" "+shortestTemp[j]);
            j++;
        }
        //System.out.println("距离为："+dijkstraHeap.getTempDist());
        //假设紧急点
        int badPoint=2968;
        for (int i=0;i<10000;i++){
            arr[badPoint][i]=DijkstraHeap.getINF();
            arr[i][badPoint]=DijkstraHeap.getINF();
        }

            j=0;
            while(shortestTemp[j]!=0){
                if (shortestTemp[j]==badPoint){

                    int tempBadX=badPoint%100;
                    int tempBadY=badPoint/100;
                    int[] dx={-3,-2,-1,0,1,2,3,-3,-2,-1,0,1,2,3,-3,-3,-3,-3,-3,3,3,3,3,3};
                    int[] dy={3,3,3,3,3,3,3,-3,-3,-3,-3,-3,-3,-3,2,1,0,1,2,2,1,0,1,2};
                    int[] tempArray=new int[24];
                    for (int k=0;k<24;k++){
                        tempArray[k]=(tempBadY+dy[k])*100+tempBadX+dx[k];
                    }
                    int tempJ=j;
                    int tempStartPoint;
                    int tempStartId;
                    int tempEndPoint;
                    int tempEndId;
                    toStartBreak:
                    while (true){
                        tempJ--;
                        //System.out.println("查找:"+allShortest[i][tempJ]);
                        for (int e=0;e<24;e++){
                            //System.out.println("匹配："+tempArray[e]);
                            if(shortestTemp[tempJ]==tempArray[e]){
                                //System.out.println("找到了");
                                tempStartPoint=tempArray[e];
                                tempStartId=tempJ;
                                break toStartBreak;
                            }
                        }
                    }
                    //System.out.println("tempStartPoint:"+tempStartPoint+" tempStartId:"+tempStartId);
                    tempJ=j;
                    toEndBreak:
                    while (true){
                        tempJ++;
                        for (int e=0;e<24;e++){
                            if(shortestTemp[tempJ]==tempArray[e]){
                                tempEndPoint=tempArray[e];
                                tempEndId=tempJ;
                                break toEndBreak;
                            }
                        }
                    }
                    //System.out.println("tempEndPoint:"+tempEndPoint+" tempEndId:"+tempEndId);
                    DijkstraHeap dijkstraHeap1=new DijkstraHeap();
                    dijkstraHeap1.dijkstra(arr,tempStartPoint,tempEndPoint);
                    int[] tempShortest=new int[10005];
                    int[] finalShortest=new int[10005];
                    tempShortest=dijkstraHeap1.getShortest();
                    for (int e=0;e<=tempStartId;e++){
                        finalShortest[e]=shortestTemp[e];
                    }
                    for (int e=0;e<=dijkstraHeap1.getK()-1;e++){
                        finalShortest[tempStartId+e+1]=tempShortest[dijkstraHeap1.getK()-e-1];
                    }
                    int tempE=0;
                    //System.out.println("tempEndPoint:"+tempEndPoint+" allShortest[i][e]:"+shortestTemp[tempEndId]);
                    for (int e=tempEndId;shortestTemp[e]!=0;e++){
                        finalShortest[tempE+tempStartId+dijkstraHeap1.getK()-1+1]=shortestTemp[e];
                        //System.out.println("finalShortest"+(tempE+tempStartId+dijkstraHeap.getK()-1+1)+
                                //" = allShortest[i]["+e+"]==="+allShortest[i][e]);
                        tempE++;
                    }

                    //shortestTemp=finalShortest.clone();
                    System.out.println();
                    System.out.println("微调后的路线为：");
                    int j1=0;
                    while(finalShortest[j1]!=0){
                        System.out.print(" "+finalShortest[j1]);
                        j1++;
                    }
                    break;
                }
                j++;
            }

        //makeData.addUpdateShortest(allShortest);
    }
}
