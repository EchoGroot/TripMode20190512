package TripMode.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "path")
public class Path {
    @XmlElement(name = "distance")
    private String distance;
    @XmlElement(name = "duration")
    private String duration;
    @XmlElement(name = "steps")
    private Steps steps;

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
        return "Path{" +
                "distance='" + distance + '\'' +
                ", duration='" + duration + '\'' +
                ", steps=" + steps +
                '}';
    }
}
