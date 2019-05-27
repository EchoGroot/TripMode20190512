package TripMode.model.byBus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "route")
public class Route {
    @XmlElement(name = "origin")
    private String origin;
    @XmlElement(name = "destination")
    private String destination;
    @XmlElement(name="distance")
    private String distance;
    @XmlElement(name="taxi_cost")
    private String taxi_cost;
    @XmlElement(name = "transits")
    private Transits transits;

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

    public String getTaxi_cost() {
        return taxi_cost;
    }

    public void setTaxi_cost(String taxi_cost) {
        this.taxi_cost = taxi_cost;
    }

    public Transits getTransits() {
        return transits;
    }

    public void setTransits(Transits transits) {
        this.transits = transits;
    }

    @Override
    public String toString() {
        return "Route{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", distance='" + distance + '\'' +
                ", taxi_cost='" + taxi_cost + '\'' +
                ", transits=" + transits +
                '}';
    }
}
