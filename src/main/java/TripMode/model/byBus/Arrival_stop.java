package TripMode.model.byBus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "arrival_stop")
public class Arrival_stop {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "id")
    private String id;
    @XmlElement(name="location")
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Arrival_stop{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
