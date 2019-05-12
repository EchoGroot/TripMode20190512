package TripMode.Model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "nd")
public class Nd {

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
        return "Nd{" +
                "code=" + code +
                '}';
    }
}
