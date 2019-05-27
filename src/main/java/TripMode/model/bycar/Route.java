package TripMode.model.bycar;

import javax.xml.bind.annotation.*;
import java.util.Map;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "route")
public class Route {
    @XmlElement(name = "origin")
    private String origin;
    @XmlElement(name = "destination")
    private String destination;
    @XmlElement(name="taxi_cost")
    private String taxi_cost;
    @XmlElement(name = "paths")
    private Paths paths;

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



    public Paths getPaths() {
        return paths;
    }

    public void setPaths(Paths paths) {
        this.paths = paths;
    }

    public String getTaxi_cost() {
        return taxi_cost;
    }

    public void setTaxi_cost(String taxi_cost) {
        this.taxi_cost = taxi_cost;
    }

    @Override
    public String toString() {
        return "Route{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", taxi_cost='" + taxi_cost + '\'' +
                ", paths=" + paths +
                '}';
    }
}
