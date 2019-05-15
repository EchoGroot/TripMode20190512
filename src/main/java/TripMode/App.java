package TripMode;

import TripMode.dao.IniDB;
import TripMode.dao.Store;
import TripMode.model.Crossing;
import TripMode.model.Osm;
import TripMode.service.CrossingMethod;
import TripMode.service.XmlToJavaBean;

import java.io.*;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        XmlToJavaBean xmlToJavaBean=new XmlToJavaBean();
        xmlToJavaBean.correct("src/main/resources/map.xml");
        Osm osm=xmlToJavaBean.getOsm();
        CrossingMethod crossingMethod=new CrossingMethod();
        Set<Crossing> crossings = crossingMethod.getConnection(osm);
        //System.out.println(osm);

        System.out.println( "Hello World!" );

        /*IniDB iniDB=new IniDB();
        Store store=new Store(iniDB.getConnection());
        for (Crossing crossing:crossings){
            store.addCrossing(crossing);
        }
        store.connection.close();*/
    }
}
