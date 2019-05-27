package TripMode.model.byBus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "transit")
public class Transit {
    @XmlElement(name = "cost")
    private String cost;
    @XmlElement(name = "duration")
    private String duration;
    @XmlElement(name="nightflag")
    private String nightflag;
    @XmlElement(name = "walking_distance")
    private String walking_distance;
    @XmlElement(name = "distance")
    private String distance;
    @XmlElement(name = "missed")
    private String missed;
    @XmlElement(name="segments ")
    private Segments  segments ;

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getNightflag() {
        return nightflag;
    }

    public void setNightflag(String nightflag) {
        this.nightflag = nightflag;
    }

    public String getWalking_distance() {
        return walking_distance;
    }

    public void setWalking_distance(String walking_distance) {
        this.walking_distance = walking_distance;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getMissed() {
        return missed;
    }

    public void setMissed(String missed) {
        this.missed = missed;
    }

    public Segments getSegments() {
        return segments;
    }

    public void setSegments(Segments segments) {
        this.segments = segments;
    }

    @Override
    public String toString() {
        return "Transit{" +
                "cost='" + cost + '\'' +
                ", duration='" + duration + '\'' +
                ", nightflag='" + nightflag + '\'' +
                ", walking_distance='" + walking_distance + '\'' +
                ", distance='" + distance + '\'' +
                ", missed='" + missed + '\'' +
                ", segments=" + segments +
                '}';
    }
}
