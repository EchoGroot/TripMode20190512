package TripMode.model.bycar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "city")
public class City {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "citycode")
    private String citycode;
    @XmlElement(name = "adcode")
    private String adcode;
    @XmlElement(name = "districts ")
    private Districts districts ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public Districts getDistricts() {
        return districts;
    }

    public void setDistricts(Districts districts) {
        this.districts = districts;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", citycode='" + citycode + '\'' +
                ", adcode='" + adcode + '\'' +
                ", districts=" + districts +
                '}';
    }
}
