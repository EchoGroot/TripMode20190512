package TripMode.model.bycar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "path")
public class Path {
    @XmlElement(name = "distance")
    private String distance;
    @XmlElement(name = "duration")
    private String duration;
    @XmlElement(name="strategy")
    private String strategy;
    @XmlElement(name="tolls")
    private String tolls;
    @XmlElement(name="toll_distance")
    private String toll_distance;
    @XmlElement(name = "steps")
    private TripMode.model.bycar.Steps steps;
    @XmlElement(name="restriction")
    private String restriction;
    @XmlElement(name="traffic_lights")
    private String traffic_lights;

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

    public TripMode.model.bycar.Steps getSteps() {
        return steps;
    }

    public void setSteps(Steps steps) {
        this.steps = steps;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getTolls() {
        return tolls;
    }

    public void setTolls(String tolls) {
        this.tolls = tolls;
    }

    public String getToll_distance() {
        return toll_distance;
    }

    public void setToll_distance(String toll_distance) {
        this.toll_distance = toll_distance;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    public String getTraffic_lights() {
        return traffic_lights;
    }

    public void setTraffic_lights(String traffic_lights) {
        this.traffic_lights = traffic_lights;
    }

    @Override
    public String toString() {
        return "Path{" +
                "distance='" + distance + '\'' +
                ", duration='" + duration + '\'' +
                ", strategy='" + strategy + '\'' +
                ", tolls='" + tolls + '\'' +
                ", toll_distance='" + toll_distance + '\'' +
                ", steps=" + steps +
                ", restriction='" + restriction + '\'' +
                ", traffic_lights='" + traffic_lights + '\'' +
                '}';
    }
}
