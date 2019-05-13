package TripMode;

import TripMode.Model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import java.io.*;
import java.util.Map;

public class XmlToJavaBean {
    private Osm osm=new Osm();

    public Osm getOsm(String xmlPath) throws IOException {
        String xmlString;
        byte[] strBuffer = null;
        int flen = 0;
        File xmlfile = new File(xmlPath);
        try {
            InputStream in = new FileInputStream(xmlfile);
            flen = (int)xmlfile.length();
            strBuffer = new byte[flen];
            in.read(strBuffer, 0, flen);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        xmlString = new String(strBuffer);
        //System.out.println(xmlString);
        //System.out.println("----------------------------");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Osm.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            this.osm=(Osm) unmarshaller.unmarshal(new StringReader(xmlString));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return this.osm;
    }

    public void correct(String xmlPath) throws IOException {
        getOsm(xmlPath);
        for (Node node:this.osm.getNode()){
            //System.out.println("old:"+node.getCode().get(QName.valueOf("lat")));
            //System.out.println("old:"+node.getCode().get(QName.valueOf("lon")));
            double lat= Double.valueOf(node.getCode().get(QName.valueOf("lat")).toString());
            double lon= Double.valueOf(node.getCode().get(QName.valueOf("lon")).toString());
            LocateInfo locateInfo=GCJ02_WGS84.wgs84_To_Gcj02(lat,lon);
            String latTemp=locateInfo.getLatitude()+"";
            String lonTemp=locateInfo.getLongitude()+"";
            int end=0;
            for (int i=0;i<latTemp.length();i++){
                if (latTemp.charAt(i)=='.'){
                    end=i+7;
                    break;
                }
            }
            for (int i=0;i<lonTemp.length();i++){
                if (lonTemp.charAt(i)=='.'){
                    end=i+7;
                    break;
                }
            }
            latTemp=latTemp.substring(0,end);
            lonTemp=lonTemp.substring(0,end);
            Map map=node.getCode();
            map.put(QName.valueOf("lat"),latTemp);
            map.put(QName.valueOf("lon"),lonTemp);
            node.setCode(map);
            //System.out.println("new:"+node.getCode().get(QName.valueOf("lat")));
            //System.out.println("new:"+node.getCode().get(QName.valueOf("lon")));
        }
    }

    public Osm getOsm() {
        return osm;
    }

    public void setOsm(Osm osm) {
        this.osm = osm;
    }

    @Override
    public String toString() {
        return "XmlToJavaBean{" +
                "osm=" + osm +
                '}';
    }
}
