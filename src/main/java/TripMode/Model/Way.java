package TripMode.Model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Map;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "way")
public class Way {

    @XmlAnyAttribute()
    private Map code;//每个Item的属性值

    @XmlElement(name = "nd")
    private List<Nd> ndList;

    @XmlElement(name = "tag")
    private List<Tag> tagList;

    public Map getCode() {
        return code;
    }

    public void setCode(Map code) {
        this.code = code;
    }

    public List<Nd> getNdList() {
        return ndList;
    }

    public void setNdList(List<Nd> ndList) {
        this.ndList = ndList;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    @Override
    public String toString() {
        return "Way{" +
                "code=" + code +
                ", ndList=" + ndList +
                ", tagList=" + tagList +
                '}';
    }
}
