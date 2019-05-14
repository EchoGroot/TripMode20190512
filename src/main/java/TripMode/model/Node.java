package TripMode.model;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Map;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "node")
public class Node {

    @XmlAnyAttribute()
    private Map code;//每个Item的属性值

    @XmlElement(name = "tag")
    private List<Tag> tagList;

    public Map getCode() {
        return code;
    }

    public void setCode(Map code) {
        this.code = code;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    @Override
    public String toString() {
        return "Node{" +
                "code=" + code +
                ", tagList=" + tagList +
                '}';
    }
}
