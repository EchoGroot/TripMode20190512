package TripMode.model.byBus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "busline")
public class Busline {
    @XmlElement(name = "departure_stop")
    private Departure_stop departure_stop;
    @XmlElement(name = "arrival_stop")
    private Arrival_stop arrival_stop;
    @XmlElement(name="name")
    private String name;
    @XmlElement(name = "id")
    private String id;
    @XmlElement(name = "type")
    private String type;
    @XmlElement(name = "distance")
    private String distance;
    @XmlElement(name = "duration")
    private String duration;
    @XmlElement(name = "polyline")
    private String polyline;
    @XmlElement(name="bustimetag")
    private String bustimetag;
    @XmlElement(name = "start_time")
    private String start_time;
    @XmlElement(name = "end_time")
    private String end_time;
    @XmlElement(name = "via_num")
    private String via_num;
    @XmlElement(name = "via_stops ")
    private Via_stops  via_stops ;

    public Departure_stop getDeparture_stop() {
        return departure_stop;
    }

    public void setDeparture_stop(Departure_stop departure_stop) {
        this.departure_stop = departure_stop;
    }

    public Arrival_stop getArrival_stop() {
        return arrival_stop;
    }

    public void setArrival_stop(Arrival_stop arrival_stop) {
        this.arrival_stop = arrival_stop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPolyline() {
        return polyline;
    }

    public void setPolyline(String polyline) {
        this.polyline = polyline;
    }

    public String getBustimetag() {
        return bustimetag;
    }

    public void setBustimetag(String bustimetag) {
        this.bustimetag = bustimetag;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getVia_num() {
        return via_num;
    }

    public void setVia_num(String via_num) {
        this.via_num = via_num;
    }

    public Via_stops getVia_stops() {
        return via_stops;
    }

    public void setVia_stops(Via_stops via_stops) {
        this.via_stops = via_stops;
    }

    @Override
    public String toString() {
        return "Busline{" +
                "departure_stop=" + departure_stop +
                ", arrival_stop=" + arrival_stop +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", distance='" + distance + '\'' +
                ", duration='" + duration + '\'' +
                ", polyline='" + polyline + '\'' +
                ", bustimetag='" + bustimetag + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", via_num='" + via_num + '\'' +
                ", via_stops=" + via_stops +
                '}';
    }
}
