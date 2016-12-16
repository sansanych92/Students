package Server.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arsenii on 15.12.2016.
 */
@XmlRootElement(name = "root")
public class Root implements Serializable{

    private List<StudentModel> studentModelList;
    private List<GroupModel> groupModelList;
    private List<Exception> exceptions;
    private List<Integer> deleteStudent;
    private List<Integer> deleteGroup;
    private List<StudentModel> addStudent;
    private List<GroupModel> addGroup;
    private List<StudentModel> setStudent;
    private List<GroupModel> setGroup;
    private List<StudentModel> loadStudents;
    private List<GroupModel> loadGroups;

    /**
     *
     */
    public Root() {

        studentModelList = new ArrayList<>();
        groupModelList = new ArrayList<>();
        exceptions = new ArrayList<>();
        deleteStudent = new ArrayList<>();
        deleteGroup = new ArrayList<>();
        addStudent = new ArrayList<>();
        addGroup = new ArrayList<>();
        setStudent = new ArrayList<>();
        setGroup = new ArrayList<>();
        loadStudents = new ArrayList<>();
        loadGroups = new ArrayList<>();
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

    /**
     *
     * @return
     */
    public List<Exception> getExceptions() {
        return exceptions;
    }

    /**
     *
     * @param exceptions
     */
    @XmlElementWrapper(name = "exceptions")
    @XmlElement(name = "exception")
    public void setExceptions(List<Exception> exceptions) {
        this.exceptions = exceptions;
    }

    /**
     *
     * @return
     */
    public List<Integer> getDeleteStudent() {
        return deleteStudent;
    }

    /**
     *
     * @param deleteStudent
     */
    @XmlElementWrapper(name = "deleteStudent")
    @XmlElement(name = "StudentId")
    public void setDeleteStudent(List<Integer> deleteStudent) {
        this.deleteStudent = deleteStudent;
    }

    /**
     *
     * @return
     */
    public List<Integer> getDeleteGroup() {
        return deleteGroup;
    }

    /**
     *
     * @param deleteGroup
     */
    @XmlElementWrapper(name = "deleteGroup")
    @XmlElement(name = "groupId")
    public void setDeleteGroup(List<Integer> deleteGroup) {
        this.deleteGroup = deleteGroup;
    }

    /**
     *
     * @return
     */
    public List<StudentModel> getAddStudent() {
        return addStudent;
    }

    /**
     *
     * @param addStudent
     */
    @XmlElementWrapper(name = "addStudent")
    @XmlElement(name = "student")
    public void setAddStudent(List<StudentModel> addStudent) {
        this.addStudent = addStudent;
    }

    /**
     *
     * @return
     */
    public List<GroupModel> getAddGroup() {
        return addGroup;
    }

    /**
     *
     * @param addGroup
     */
    @XmlElementWrapper(name = "addGroup")
    @XmlElement(name = "group")
    public void setAddGroup(List<GroupModel> addGroup) {
        this.addGroup = addGroup;
    }

    /**
     *
     * @return
     */
    public List<StudentModel> getSetStudent() {
        return setStudent;
    }

    /**
     *
     * @param setStudent
     */
    @XmlElementWrapper(name = "setStudent")
    @XmlElement(name = "student")
    public void setSetStudent(List<StudentModel> setStudent) {
        this.setStudent = setStudent;
    }

    /**
     *
     * @return
     */
    public List<GroupModel> getSetGroup() {
        return setGroup;
    }

    /**
     *
     * @param setGroup
     */
    @XmlElementWrapper(name = "setGroup")
    @XmlElement(name = "group")
    public void setSetGroup(List<GroupModel> setGroup) {
        this.setGroup = setGroup;
    }

    /**
     *
     * @return
     */
    public List<StudentModel> getLoadStudents() {
        return loadStudents;
    }

    /**
     *
     * @param loadStudents
     */
    @XmlElement
    public void setLoadStudents(List<StudentModel> loadStudents) {
        this.loadStudents = loadStudents;
    }

    /**
     *
     * @return
     */
    public List<GroupModel> getLoadGroups() {
        return loadGroups;
    }

    /**
     *
     * @param loadGroups
     */
    @XmlElement
    public void setLoadGroups(List<GroupModel> loadGroups) {
        this.loadGroups = loadGroups;
    }
}
