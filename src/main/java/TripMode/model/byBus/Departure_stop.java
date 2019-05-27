package TripMode.model.byBus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "departure_stop")
public class Departure_stop {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "id")
    private String id;
    @XmlElement(name="location")
    private String location;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Departure_stop{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
