package TripMode.model.byBus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "railway")
public class Railway {
    @XmlElement(name = "spaces")
    private Object spaces;

    public Object getSpaces() {
        return spaces;
    }

    public void setSpaces(Object spaces) {
        this.spaces = spaces;
    }

    @Override
    public String toString() {
        return "Railway{" +
                "spaces=" + spaces +
                '}';
    }
}
