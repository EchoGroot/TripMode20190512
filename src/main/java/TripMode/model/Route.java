package TripMode.model;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Map;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "route")
public class Route {
    @XmlElement(name = "origin")
    private String origin;
    @XmlElement(name = "destination")
    private String destination;
    @XmlAnyAttribute()
    private Map code;//每个Item的属性值
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

    public Map getCode() {
        return code;
    }

    public void setCode(Map code) {
        this.code = code;
    }

    public Paths getPaths() {
        return paths;
    }

    public void setPaths(Paths paths) {
        this.paths = paths;
    }

    @Override
    public String toString() {
        return "Route{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", code=" + code +
                ", paths=" + paths +
                '}';
    }
}
