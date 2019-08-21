package TripMode_2_BestTimeAndMethod_20190527;

import TripMode.model.bycar.Response;
import TripMode.service.HttpClient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;

public class BestTimeAndMethod {
    public double computeByCar(String originLon,String originLat,
                               String destinationLon,String destinationLat
    ) throws IOException {
        String url="https://restapi.amap.com/v3/direction/driving?"
                +"origin="+originLon+","+originLat
                +"&destination="+destinationLon+","+destinationLat
                +"&strategy=0&extensions=all&output=xml&key=c6bfc5bf6c87600f79b4a461cbb760a8";
        System.out.println("url:"+url);
        String responceXml=HttpClient.httpGet(url);
        double timeByCar=0;
        Response response=new Response();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            response =(Response) unmarshaller.unmarshal(new StringReader(responceXml));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        //System.out.println(response);
        timeByCar=Double.valueOf(response.getRoute().getPaths().getPaths().get(0).getDuration())/60;
        return timeByCar;
    }
    public double computeByLightRail(String originLon,String originLat
            ,String destinationLon,String destinationLat
            ,String date,String time
    ) throws IOException {
        String url="https://restapi.amap.com/v3/direction/transit/integrated?"
                +"origin="+originLon+","+originLat
                +"&destination="+destinationLon+","+destinationLat
                +"&date="+date+"&time="+time
                +"&city=023&strategy=5&output=xml&key=c6bfc5bf6c87600f79b4a461cbb760a8";
        System.out.println("url:"+url);
        String responceXml=HttpClient.httpGet(url);
        double timeByLightRail=0;
        TripMode.model.byBus.Response response=new TripMode.model.byBus.Response();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TripMode.model.byBus.Response.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            response =(TripMode.model.byBus.Response) unmarshaller.unmarshal(new StringReader(responceXml));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        //System.out.println(response);
        if (Integer.valueOf(response.getCount())==0)return 0;
        timeByLightRail=Double.valueOf(response.getRoute().getTransits().getTransits().get(0).getDuration())/60;
        return timeByLightRail;
    }
    public double computeByBus(String originLon,String originLat
            ,String destinationLon,String destinationLat
            ,String date,String time
    ) throws IOException {
        String url="https://restapi.amap.com/v3/direction/transit/integrated?"
                +"origin="+originLon+","+originLat
                +"&destination="+destinationLon+","+destinationLat
                +"&date="+date+"&time="+time
                +"&city=023&strategy=0&output=xml&key=c6bfc5bf6c87600f79b4a461cbb760a8";
        System.out.println("url:"+url);
        String responceXml=HttpClient.httpGet(url);
        double timeByBus=0;
        TripMode.model.byBus.Response response=new TripMode.model.byBus.Response();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TripMode.model.byBus.Response.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            response =(TripMode.model.byBus.Response) unmarshaller.unmarshal(new StringReader(responceXml));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        //System.out.println(response);
        if (Integer.valueOf(response.getCount())==0)return 0;
        timeByBus=Double.valueOf(response.getRoute().getTransits().getTransits().get(0).getDuration())/60;
        return timeByBus;
    }


}
