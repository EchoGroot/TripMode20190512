package TripMode;

import TripMode.Model.Osm;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        //XmlToJavaBean xmlToJavaBean=new XmlToJavaBean();
        //xmlToJavaBean.getOsm("map.xml");
        //Osm osm = (Osm) marshallerUtils.parseXmlDataObject(ReqEaxmsInfo.class, examsXml);

        String xmlString;
        byte[] strBuffer = null;
        int flen = 0;
        File xmlfile = new File("src/main/resources/map.xml");
        try {
            InputStream in = new FileInputStream(xmlfile);
            flen = (int)xmlfile.length();
            strBuffer = new byte[flen];
            in.read(strBuffer, 0, flen);
        } catch (FileNotFoundException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        xmlString = new String(strBuffer);
        System.out.println(xmlString);
        System.out.println("----------------------------");
        Osm osm=new Osm();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Osm.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            osm=(Osm) unmarshaller.unmarshal(new StringReader(xmlString));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println(osm);
        System.out.println( "Hello World!" );
    }
}
