package TripMode.model.byBus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "buslines")
public class Buslines {
    @XmlElement(name = "busline")
    private List<Busline> buslines;

    public List<Busline> getPaths() {
        return buslines;
    }

    public void setPaths(List<Busline> buslines) {
        this.buslines = buslines;
    }

    @Override
    public String toString() {
        return "Buslines{" +
                "buslines=" + buslines +
                '}';
    }
}
