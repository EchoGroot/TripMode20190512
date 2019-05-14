package TripMode;

import TripMode.model.Osm;
import TripMode.service.CrossingMethod;
import TripMode.service.XmlToJavaBean;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        XmlToJavaBean xmlToJavaBean=new XmlToJavaBean();
        xmlToJavaBean.correct("src/main/resources/map.xml");
        Osm osm=xmlToJavaBean.getOsm();
        CrossingMethod crossingMethod=new CrossingMethod();
        crossingMethod.getConnection(osm);
        //System.out.println(osm);

        System.out.println( "Hello World!" );



    }
}
