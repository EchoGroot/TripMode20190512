package TripMode.model;

import java.util.LinkedList;
import java.util.List;

public class Crossing {
    private String id;//路口Id
    private String lat;//路口维度
    private String lon;//路口经度
    public List<Connection> connections=new LinkedList<>();//目标路口与周围路口的连接

    public Crossing(String id, String lat, String lon) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
    }

    public Crossing(double lon, double lat) {
        this.lat = lat+"";
        this.lon = lon+"";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    /*@Override
    public String toString() {
        return "Crossing{" +
                "id='" + id + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", connections=" + connections +
                '}';
    }*/
    @Override
    public String toString() {
        return "https://restapi.amap.com/v3/staticmap?markers=mid,0xFF0000,A:"+lon+","+lat+"|mid,0xFF0000,B:"+connections+"&key=c6bfc5bf6c87600f79b4a461cbb760a8\n";
    }
}
