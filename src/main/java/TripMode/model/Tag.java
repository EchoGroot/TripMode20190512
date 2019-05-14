package TripMode.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "tag")
public class Tag {

    @XmlAnyAttribute()
    private Map code;//每个Item的属性值

    public Map getCode() {
        return code;
    }

    public void setCode(Map code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "code=" + code +
                '}';
    }
}
