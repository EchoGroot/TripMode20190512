package TripMode.model;

import javax.xml.namespace.QName;

public class Connection {
    private String connectionId;//目标点连接的点的Id
    private String connectionLon;//目标点连接的点的经度
    private String connectionLat;//目标点连接的点的维度
    private String connectionValue;//目标点连接的点的权值（时间）
    public static Osm osm;//oopenstreetXML转出来的Bean

    public String getConnectionLon() {
        return connectionLon;
    }

    public void setConnectionLon(String connectionLon) {
        this.connectionLon = connectionLon;
    }

    public String getConnectionLat() {
        return connectionLat;
    }

    public void setConnectionLat(String connectionLat) {
        this.connectionLat = connectionLat;
    }

    public static Osm getOsm() {
        return osm;
    }

    public static void setOsm(Osm osm) {
        Connection.osm = osm;
    }

    public Connection(String connectionId, String connectionLon, String connectionLat, String connectionValue) {
        this.connectionId = connectionId;
        this.connectionLon = connectionLon;
        this.connectionLat = connectionLat;
        this.connectionValue = connectionValue;
    }

    public Connection(String connectionId, String connectionValue) {
        this.connectionId = connectionId;
        this.connectionValue = connectionValue;
    }
    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    public String getConnectionValue() {
        return connectionValue;
    }

    public void setConnectionValue(String connectionValue) {
        this.connectionValue = connectionValue;
    }

    /*@Override
    public String toString() {
        return "Connection{" +
                "connectionId='" + connectionId + '\'' +
                ", connectionLon='" + connectionLon + '\'' +
                ", connectionLat='" + connectionLat + '\'' +
                ", connectionValue='" + connectionValue + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        return connectionLat+","+connectionLon+";";
    }
}
