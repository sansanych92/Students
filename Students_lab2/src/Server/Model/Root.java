package Server.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *@author Arsenii
 */
@XmlRootElement(name = "root")
public class Root implements Serializable{

    private List<StudentModel> studentModelList;
    private List<GroupModel> groupModelList;

    /**
     *
     */
    public Root() {

        studentModelList = new ArrayList<>();
        groupModelList = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public List<StudentModel> getStudentModelList() {
        return studentModelList;
    }

    /**
     *
     * @param studentModelList
     */
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    public void setStudentModelList(List<StudentModel> studentModelList) {
        this.studentModelList = studentModelList;
    }

    /**
     *
     * @return
     */
    public List<GroupModel> getGroupModelList() {
        return groupModelList;
    }

    /**
     *
     * @param groupModelList
     */
    @XmlElementWrapper(name = "groups")
    @XmlElement(name = "group")
    public void setGroupModelList(List<GroupModel> groupModelList) {
        this.groupModelList = groupModelList;
    }

}
