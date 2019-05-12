package TripMode;

import TripMode.Model.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class XmlToJavaBean {
    public Osm getOsm(String xmlPath) throws IOException {
        InputStream xmlInputStream = new ClassPathResource(xmlPath).getInputStream();
        XStream xStream = new XStream();
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(new Class[]{Osm.class,Bounds.class,Node.class,Nd.class,Tag.class,Way.class});
        xStream.alias("osm",Osm.class);
        xStream.alias("bounds", Bounds.class);
        xStream.alias("nd", Nd.class);
        xStream.alias("node", Node.class);
        xStream.alias("tag", Tag.class);
        xStream.alias("way",Way.class);
        Osm osm = (Osm) xStream.fromXML(xmlInputStream);
        System.out.println(osm);
        return osm;
    }
}
