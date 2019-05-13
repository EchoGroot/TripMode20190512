package TripMode;

import TripMode.Model.Osm;

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
        CrossingMethod crossing=new CrossingMethod();
        crossing.getConnection(osm);
        //System.out.println(osm);

        System.out.println( "Hello World!" );



    }
}
