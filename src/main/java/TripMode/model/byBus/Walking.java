package TripMode.model.byBus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "walking")
public class Walking {
    @XmlElement(name = "origin")
    private String origin;
    @XmlElement(name = "destination")
    private String destination;
    @XmlElement(name="distance")
    private String distance;
    @XmlElement(name = "duration")
    private String duration;
    @XmlElement(name = "steps")
    private Steps  steps ;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

    public Steps getSteps() {
        return steps;
    }

    public void setSteps(Steps steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Walking{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", distance='" + distance + '\'' +
                ", duration='" + duration + '\'' +
                ", steps=" + steps +
                '}';
    }
}
