package TripMode.model.bycar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "tmc")
public class Tmc {
    @XmlElement(name = "lcode")
    private String lcode;
    @XmlElement(name = "distance")
    private String distance;
    @XmlElement(name = "status")
    private String status;
    @XmlElement(name = "polyline")
    private String polyline;

    public String getLcode() {
        return lcode;
    }

    public void setLcode(String lcode) {
        this.lcode = lcode;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPolyline() {
        return polyline;
    }

    public void setPolyline(String polyline) {
        this.polyline = polyline;
    }

    @Override
    public String toString() {
        return "Tmc{" +
                "lcode='" + lcode + '\'' +
                ", distance='" + distance + '\'' +
                ", status='" + status + '\'' +
                ", polyline='" + polyline + '\'' +
                '}';
    }
}
