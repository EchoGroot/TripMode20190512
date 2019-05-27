package TripMode.model.bycar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "district")
public class District {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "adcode")
    private String adcode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                ", adcode='" + adcode + '\'' +
                '}';
    }
}
