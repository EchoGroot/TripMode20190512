package TripMode.Model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import javax.management.relation.Relation;
import java.util.List;

@XStreamAlias("osm")
public class Osm0 {

    @XStreamAsAttribute
    private String attribution;

    @XStreamAsAttribute
    private String copyright;

    @XStreamAsAttribute
    private String generator;

    @XStreamAsAttribute
    private String license;

    @XStreamAsAttribute
    private String version;

    @XStreamAlias("bounds")
    private Bounds bounds;

    @XStreamImplicit(itemFieldName = "node")
    private List<Node> node;

    @XStreamImplicit(itemFieldName = "way")
    private List<Way> way;

    @XStreamImplicit(itemFieldName = "relation")
    private List<Relation> relation;

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
                "attribution='" + attribution + '\'' +
                ", copyright='" + copyright + '\'' +
                ", generator='" + generator + '\'' +
                ", license='" + license + '\'' +
                ", version='" + version + '\'' +
                ", bounds=" + bounds +
                ", node=" + node +
                ", way=" + way +
                ", relation=" + relation +
                '}';
    }
}
