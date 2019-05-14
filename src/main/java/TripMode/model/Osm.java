package TripMode.model;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Map;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "osm")
public class Osm {

    @XmlAnyAttribute()
    private Map code;//每个Item的属性值

    @XmlElement(name = "bounds")
    private Bounds bounds;

    @XmlElement(name = "node")
    private List<Node> node;

    @XmlElement(name = "way")
    private List<Way> way;

    @XmlElement(name = "relation")
    private List<Relation> relation;

    public Map getCode() {
        return code;
    }

    public void setCode(Map code) {
        this.code = code;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public List<Node> getNode() {
        return node;
    }

    public void setNode(List<Node> node) {
        this.node = node;
    }

    public List<Way> getWay() {
        return way;
    }

    public void setWay(List<Way> way) {
        this.way = way;
    }

    public List<Relation> getRelation() {
        return relation;
    }

    public void setRelation(List<Relation> relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "Osm{" +
                "code=" + code +
                ", bounds=" + bounds +
                ", node=" + node +
                ", way=" + way +
                ", relation=" + relation +
                '}';
    }
}
