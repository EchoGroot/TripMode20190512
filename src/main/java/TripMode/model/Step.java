package TripMode.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "step")
public class Step {
    @XmlElement(name = "instruction")
    private String instruction;
    @XmlElement(name = "orientation")
    private String orientation;
    @XmlElement(name = "road")
    private String road;
    @XmlElement(name = "distance")
    private String distance;
    @XmlElement(name = "duration")
    private String duration;
    @XmlElement(name = "polyline")
    private String polyline;
    @XmlElement(name = "action")
    private String action;
    @XmlElement(name = "assistant_action")
    private String assistant_action;
    @XmlElement(name = "walk_type")
    private String walk_type;

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
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

    public String getWalk_type() {
        return walk_type;
    }

    public void setWalk_type(String walk_type) {
        this.walk_type = walk_type;
    }

    @Override
    public String toString() {
        return "Step{" +
                "instruction='" + instruction + '\'' +
                ", orientation='" + orientation + '\'' +
                ", road='" + road + '\'' +
                ", distance='" + distance + '\'' +
                ", duration='" + duration + '\'' +
                ", polyline='" + polyline + '\'' +
                ", action='" + action + '\'' +
                ", assistant_action='" + assistant_action + '\'' +
                ", walk_type='" + walk_type + '\'' +
                '}';
    }
}
