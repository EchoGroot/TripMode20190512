package TripMode.model;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Map;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "relation")
public class Relation {

    @XmlAnyAttribute()
    private Map code;//每个Item的属性值

    @XmlElement(name = "member")
    private List<Member> memberList;

    @XmlElement(name = "tag")
    private List<Tag> tagList;

    public Map getCode() {
        return code;
    }

    public void setCode(Map code) {
        this.code = code;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "code=" + code +
                ", memberList=" + memberList +
                ", tagList=" + tagList +
                '}';
    }
}
