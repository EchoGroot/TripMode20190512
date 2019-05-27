package TripMode.model.byBus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "segment")
public class Segment {
    @XmlElement(name = "taxi")
    private String taxi;
    @XmlElement(name = "walking")
    private Walking walking;
    @XmlElement(name="bus")
    private Bus bus;
    @XmlElement(name = "entrance")
    private String entrance;
    @XmlElement(name = "exit")
    private String exit;
    @XmlElement(name = "railway")
    private Railway railway;

    public String getTaxi() {
        return taxi;
    }

    public void setTaxi(String taxi) {
        this.taxi = taxi;
    }

    public Walking getWalking() {
        return walking;
    }

    public void setWalking(Walking walking) {
        this.walking = walking;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }

    public Railway getRailway() {
        return railway;
    }

    public void setRailway(Railway railway) {
        this.railway = railway;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "taxi='" + taxi + '\'' +
                ", walking=" + walking +
                ", bus=" + bus +
                ", entrance='" + entrance + '\'' +
                ", exit='" + exit + '\'' +
                ", railway=" + railway +
                '}';
    }
}
