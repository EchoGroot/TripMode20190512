package TripMode.model;

import javax.xml.bind.annotation.*;
import java.util.Map;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "bounds")
public class Bounds {

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
        return "Bounds{" +
                "code=" + code +
                '}';
    }
}
