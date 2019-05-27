package TripMode.model.byBus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "bus")
public class Bus {
    @XmlElement(name = "buslines")
    private Buslines buslines;

    public Buslines getBuslines() {
        return buslines;
    }

    public void setBuslines(Buslines buslines) {
        this.buslines = buslines;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "buslines=" + buslines +
                '}';
    }
}
