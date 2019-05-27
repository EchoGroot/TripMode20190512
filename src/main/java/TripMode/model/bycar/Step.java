package TripMode.model.bycar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
    @XmlElement(name = "tolls")
    private String tolls;
    @XmlElement(name = "toll_distance")
    private String toll_distance;
    @XmlElement(name = "toll_road")
    private String toll_road;
    @XmlElement(name = "duration")
    private String duration;
    @XmlElement(name = "polyline")
    private String polyline;
    @XmlElement(name = "action")
    private String action;
    @XmlElement(name = "assistant_action")
    private String assistant_action;
    @XmlElement(name = "tmcs")
    private Tmcs tmcs;
    @XmlElement(name = "cities")
    private Cities cities;

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTolls() {
        return tolls;
    }

    public void setTolls(String tolls) {
        this.tolls = tolls;
    }

    public String getToll_distance() {
        return toll_distance;
    }

    public void setToll_distance(String toll_distance) {
        this.toll_distance = toll_distance;
    }

    public String getToll_road() {
        return toll_road;
    }

    public void setToll_road(String toll_road) {
        this.toll_road = toll_road;
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

    public Tmcs getTmcs() {
        return tmcs;
    }

    public void setTmcs(Tmcs tmcs) {
        this.tmcs = tmcs;
    }

    public Cities getCities() {
        return cities;
    }

    public void setCities(Cities cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Step{" +
                "instruction='" + instruction + '\'' +
                ", orientation='" + orientation + '\'' +
                ", road='" + road + '\'' +
                ", distance='" + distance + '\'' +
                ", tolls='" + tolls + '\'' +
                ", toll_distance='" + toll_distance + '\'' +
                ", toll_road='" + toll_road + '\'' +
                ", duration='" + duration + '\'' +
                ", polyline='" + polyline + '\'' +
                ", action='" + action + '\'' +
                ", assistant_action='" + assistant_action + '\'' +
                ", tmcs=" + tmcs +
                ", cities=" + cities +
                '}';
    }
}
