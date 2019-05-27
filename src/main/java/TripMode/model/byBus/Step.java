package TripMode.model.byBus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "step")
public class Step {
    @XmlElement(name = "instruction")
    private String instruction;
    @XmlElement(name = "road")
    private String road;
    @XmlElement(name="distance")
    private String distance;
    @XmlElement(name = "duration")
    private String duration;
    @XmlElement(name = "polyline")
    private String polyline;
    @XmlElement(name = "action")
    private String action;
    @XmlElement(name="assistant_action")
    private String  assistant_action;

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPolyline() {
        return polyline;
    }

    public void setPolyline(String polyline) {
        this.polyline = polyline;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAssistant_action() {
        return assistant_action;
    }

    public void setAssistant_action(String assistant_action) {
        this.assistant_action = assistant_action;
    }

    @Override
    public String toString() {
        return "Step{" +
                "instruction='" + instruction + '\'' +
                ", road='" + road + '\'' +
                ", distance='" + distance + '\'' +
                ", duration='" + duration + '\'' +
                ", polyline='" + polyline + '\'' +
                ", action='" + action + '\'' +
                ", assistant_action='" + assistant_action + '\'' +
                '}';
    }
}
