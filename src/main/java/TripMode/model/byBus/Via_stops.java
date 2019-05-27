package TripMode.model.byBus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "via_stops")
public class Via_stops {
    @XmlElement(name = "via_stop")
    private List<Via_stop> via_stopList;

    public List<Via_stop> getVia_stopList() {
        return via_stopList;
    }

    public void setVia_stopList(List<Via_stop> via_stopList) {
        this.via_stopList = via_stopList;
    }

    @Override
    public String toString() {
        return "Via_stops{" +
                "via_stopList=" + via_stopList +
                '}';
    }
}
