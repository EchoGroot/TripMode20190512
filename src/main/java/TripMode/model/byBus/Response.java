package TripMode.model.byBus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "response")
public class Response {
    @XmlElement(name = "status")
    private String status;
    @XmlElement(name = "info")
    private String info;
    @XmlElement(name = "infocode")
    private String infocode;
    @XmlElement(name = "count")
    private String count;
    @XmlElement(name = "route")
    private TripMode.model.byBus.Route route;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }


    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public TripMode.model.byBus.Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status='" + status + '\'' +
                ", info='" + info + '\'' +
                ", infocode='" + infocode + '\'' +
                ", count='" + count + '\'' +
                ", route=" + route +
                '}';
    }
}
