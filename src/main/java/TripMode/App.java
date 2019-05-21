package TripMode;

import TripMode.dao.IniDB;
import TripMode.dao.Store;
import TripMode.model.Crossing;
import TripMode.model.Nd;
import TripMode.model.Osm;
import TripMode.model.Way;
import TripMode.service.CrossingMethod;
import TripMode.service.XmlToJavaBean;

import javax.xml.namespace.QName;
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
        xmlToJavaBean.correct("src/main/resources/data/map.xml");
        Osm osm=xmlToJavaBean.getOsm();
        CrossingMethod crossingMethod=new CrossingMethod();
        //Set<Crossing> crossings = crossingMethod.getConnection(osm);
        //System.out.println(osm);

        System.out.println( "Hello World!" );

        //存储路口信息到数据库
        /*IniDB iniDB=new IniDB();
        Store store=new Store(iniDB.getConnection());
        for (Crossing crossing:crossings){
            store.addCrossing(crossing);
        }
        store.connection.close();*/

        //存储way到数据库
        IniDB iniDB=new IniDB();
        Store store=new Store(iniDB.getConnection());
        for (Way way:crossingMethod.getWays(osm)){
            String nodeOfWayStr="";
            for (Nd nd:way.getNdList()){
                Crossing crossing=crossingMethod.getLocation(osm, (String) nd.getCode().get(QName.valueOf("ref")));
                nodeOfWayStr+=nd.getCode().get(QName.valueOf("ref"))+":"
                +crossing.getLon()+","
                +crossing.getLat()+";";
            }
            store.addWay((String) way.getCode().get(QName.valueOf("id")),nodeOfWayStr);
        }
        store.connection.close();
    }
}
