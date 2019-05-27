package TripMode.model.bycar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "tmcs")
public class Tmcs {
    @XmlElement(name = "tmc")
    private List<Tmc> tmcs;

    public List<Tmc> getTmcs() {
        return tmcs;
    }

    public void setTmcs(List<Tmc> tmcs) {
        this.tmcs = tmcs;
    }

    @Override
    public String toString() {
        return "Tmcs{" +
                "tmcs=" + tmcs +
                '}';
    }
}
