package TripMode.model;

import javax.xml.bind.annotation.*;

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
    private Route route;


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

    public Route getRoute() {
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
