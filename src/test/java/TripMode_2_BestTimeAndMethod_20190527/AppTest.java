package TripMode_2_BestTimeAndMethod_20190527;

import TripMode_2_BestTimeAndMethod_20190527.BestTimeAndMethod;

import java.io.IOException;

public class AppTest {
    public static void main(String[] args) throws IOException {
        BestTimeAndMethod bestTimeAndMethod=new BestTimeAndMethod();
        double timeByCar=bestTimeAndMethod.computeByCar("106.571042","29.488785"
                ,"106.551201","29.60957");
        System.out.println("timeByCar:"+timeByCar);
        double timeByLightRail=bestTimeAndMethod.computeByLightRail(
                "106.717779","26.584463"
                ,"106.707951","26.572642"
                ,"2019-5-28","18:00"
        );
        System.out.println("timeByLightRail:"+timeByLightRail);
        double timeByBus=bestTimeAndMethod.computeByBus(
                "106.717779","26.584463"
                ,"106.707951","26.572642"
                ,"2019-5-28","18:00"
        );
        System.out.println("timeByBus:"+timeByBus);
    }
}
