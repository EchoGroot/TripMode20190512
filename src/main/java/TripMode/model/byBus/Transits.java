package TripMode.model.byBus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "transits")
public class Transits {
    @XmlElement(name = "transit")
    private List<Transit> transits;

    public List<Transit> getTransits() {
        return transits;
    }

    public void setTransits(List<Transit> transits) {
        this.transits = transits;
    }

    @Override
    public String toString() {
        return "Transits{" +
                "transits=" + transits +
                '}';
    }
}
