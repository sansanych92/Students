package Server.Controller;

import Server.Exceptions.DateFormatException;
import Server.Exceptions.GroupNotFoundException;
import Server.Exceptions.IdAlreadyExsistsException;
import Server.Exceptions.IdNotFoundException;
import Server.Model.GroupModel;
import Server.Model.StudentModel;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *@author artur_v
 */
public class StudentController {

    private List<StudentModel> studentList;
    private List<GroupModel> gropList;

    /**
     *
     */
    public StudentController() throws GroupNotFoundException, IOException, ParserConfigurationException, SAXException {

        studentList = new ArrayList<>();
        gropList = new ArrayList<>();
        File file = new File("Students_lab2\\src\\Server\\Storage.xml");
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        Node root = document.getDocumentElement();
        NodeList groupsAndStuds = root.getChildNodes();

        for (int i = 0; i < groupsAndStuds.getLength(); i++) {

            if (Objects.equals(groupsAndStuds.item(i).getNodeName(), "students")){
                NodeList studs = groupsAndStuds.item(i).getChildNodes();
                for (int j = 0; j < studs.getLength(); j++) {
                    if (Objects.equals(studs.item(j).getNodeName(), "student")){
                        NodeList studProps = studs.item(j).getChildNodes();
                        int id = 0;
                        String name = "";
                        String sur = "";
                        String patro = "";
                        int groupId = 0;
                        Calendar date = new GregorianCalendar();
                        for (int k = 0; k < studProps.getLength(); k++) {

                            if (Objects.equals(studProps.item(k).getNodeName(), "id")){
                                id = Integer.parseInt(studProps.item(k).getTextContent());
                            }
                            if (Objects.equals(studProps.item(k).getNodeName(), "surname")){
                                sur = studProps.item(k).getTextContent();
                            }
                            if (Objects.equals(studProps.item(k).getNodeName(), "name")){
                                name = studProps.item(k).getTextContent();
                            }
                            if (Objects.equals(studProps.item(k).getNodeName(), "patronymic")){
                                patro = studProps.item(k).getTextContent();
                            }
                            if (Objects.equals(studProps.item(k).getNodeName(), "groupId")){
                                groupId = Integer.parseInt(studProps.item(k).getTextContent());
                            }
                            if (Objects.equals(studProps.item(k).getNodeName(), "dateOfEnrollment")){
                                String [] date1 = studProps.item(k).getTextContent().split("[-]");
                                date = new GregorianCalendar(Integer.parseInt(date1[0]), Integer.parseInt(date1[1])-1, Integer.parseInt(date1[2].substring(0,2)));
                            }
                        }
                        StudentModel newStud = new StudentModel(id,sur,name,patro,groupId,date);
                        studentList.add(newStud);
                    }
                }
            }

            if (Objects.equals(groupsAndStuds.item(i).getNodeName(), "groups")){
                NodeList studs = groupsAndStuds.item(i).getChildNodes();
                for (int j = 0; j < studs.getLength(); j++) {
                    if (Objects.equals(studs.item(j).getNodeName(), "group")){
                        NodeList studProps = studs.item(j).getChildNodes();
                        int id = 0;
                        String fac = "";
                        int num = 0;
                        for (int k = 0; k < studProps.getLength(); k++) {

                            if (Objects.equals(studProps.item(k).getNodeName(), "idOfGroup")){
                                id = Integer.parseInt(studProps.item(k).getTextContent());
                            }
                            if (Objects.equals(studProps.item(k).getNodeName(), "nameOfFaculty")){
                                fac = studProps.item(k).getTextContent();
                            }
                            if (Objects.equals(studProps.item(k).getNodeName(), "numberOfGroup")){
                                num = Integer.parseInt(studProps.item(k).getTextContent());
                            }
                        }
                        GroupModel newgr = new GroupModel(id, num, fac);
                        gropList.add(newgr);
                    }
                }
            }
        }


    }

    public List<GroupModel> getGropList() {
        return gropList;
    }

    /**
     *
     * @param id
     * @return
     */
    public StudentModel getStudentById(int id) throws IdNotFoundException {

        StudentModel student = new StudentModel();
        checkStudentForExsistance(id);
        for (StudentModel student1:studentList) {
            if (student1.getId() == id){
                student = student1;
            }
        }

        return student;
    }

    /**
     *
     * @return
     */
    public List<StudentModel> getStudentList(){
        return studentList;
    }

    /**
     *
     * @param student
     */
    public void addStudent(StudentModel student) throws GroupNotFoundException, IdAlreadyExsistsException {

        checkIdForExsistance(student.getId());
        checkGroupForExsistance(student.getGroupId());
        studentList.add(student);
    }

    /**
     *
     * @param studentId
     */
    public void deleteStudent(int studentId) throws IdNotFoundException {

        StudentModel deletedStud = getStudentById(studentId);
        studentList.remove(deletedStud);
    }

    /**
     *
     * @param student
     */
    public void setStudent(int id, StudentModel student) throws GroupNotFoundException, IdNotFoundException {

        checkGroupForExsistance(student.getGroupId());
        StudentModel oldStud = getStudentById(id);
        studentList.set(studentList.indexOf(oldStud),student);
    }

    /**
     *
     * @param id
     * @return
     */
    public List<StudentModel> searchStudentById(String id){

        id = id.replaceAll("[*]",".*");
        id = id.replace('?','.');
        List<StudentModel> findedStudents = new ArrayList<>();
        Pattern regex = Pattern.compile(id);

        for (StudentModel student:getStudentList()) {
            Matcher m = regex.matcher(String.valueOf(student.getId()));
            if (m.matches()){
                findedStudents.add(student);
            }
        }
        return findedStudents;

    }

    /**
     *
     * @param name
     * @return
     */
    public List<StudentModel> searchStudentByName(String name){

        name = name.replaceAll("[*]",".*");
        name = name.replace('?','.');
        List<StudentModel> findedStudents = new ArrayList<>();
        Pattern regex = Pattern.compile(name);

        for (StudentModel student:getStudentList()) {
            Matcher m = regex.matcher(student.getName());
            if (m.matches()){
                findedStudents.add(student);
            }
        }
        return findedStudents;
    }

    /**
     *
     * @param surname
     * @return
     */
    public List<StudentModel> searchStudentBySurname(String surname){

        surname = surname.replaceAll("[*]",".*");
        surname = surname.replace('?','.');
        List<StudentModel> findedStudents = new ArrayList<>();
        Pattern regex = Pattern.compile(surname);

        for (StudentModel student:getStudentList()) {
            Matcher m = regex.matcher(student.getSurname());
            if (m.matches()){
                findedStudents.add(student);
            }
        }
        return findedStudents;
    }

    /**
     *
     * @param patronymic
     * @return
     */
    public List<StudentModel> searchStudentByPatronymic(String patronymic){

        patronymic = patronymic.replaceAll("[*]",".*");
        patronymic = patronymic.replace('?','.');
        List<StudentModel> findedStudents = new ArrayList<>();
        Pattern regex = Pattern.compile(patronymic);

        for (StudentModel student:getStudentList()) {
            Matcher m = regex.matcher(student.getPatronymic());
            if (m.matches()){
                findedStudents.add(student);
            }
        }
        return findedStudents;
    }

    /**
     *
     * @param dateOfEnvironment
     * @return
     */
    public List<StudentModel> searchStudentByDateOfEnvironment(String dateOfEnvironment){

        List<StudentModel> findedStudents = new ArrayList<>();
        String [] date = dateOfEnvironment.split("[.]");

        date[0] = date[0].replaceAll("[*]",".*");
        date[0] = date[0].replace('?','.');
        date[1] = date[1].replaceAll("[*]",".*");
        date[1] = date[1].replace('?','.');
        date[2] = date[2].replaceAll("[*]",".*");
        date[2] = date[2].replace('?','.');
        Pattern year = Pattern.compile(date[0]);
        Pattern month = Pattern.compile(date[1]);
        Pattern dayOfMonth = Pattern.compile(date[2]);

        for (StudentModel student:getStudentList()) {
            Matcher m = year.matcher(String.valueOf(student.getDateOfEnrollment().get(Calendar.YEAR)));
            Matcher m1 = month.matcher(String.valueOf(student.getDateOfEnrollment().get(Calendar.MONTH)));
            Matcher m2 = dayOfMonth.matcher(String.valueOf(student.getDateOfEnrollment().get(Calendar.DAY_OF_MONTH)));
            if (m.matches()&&m1.matches()&&m2.matches()){
                findedStudents.add(student);
            }
        }
        return findedStudents;
    }

    /**
     *
     * @param groupId
     * @return
     */
    public List<StudentModel> searchStudentByIdOfStudentsGroup(String groupId){

        groupId = groupId.replaceAll("[*]",".*");
        groupId = groupId.replace('?','.');
        List<StudentModel> findedStudents = new ArrayList<>();
        Pattern regex = Pattern.compile(groupId);

        for (StudentModel student:getStudentList()) {
            Matcher m = regex.matcher(String.valueOf(student.getGroupId()));
            if (m.matches()){
                findedStudents.add(student);
            }
        }
        return findedStudents;
    }

    /**
     *
     * @param groupId
     * @throws GroupNotFoundException
     */
    private void checkGroupForExsistance(int groupId) throws GroupNotFoundException{

        boolean exsistanceFlag = false;

        for (GroupModel group : gropList) {
            if (groupId == group.getIdOfGroup()) {
                exsistanceFlag = true;

            }
        }

        if (!exsistanceFlag) {
            throw new GroupNotFoundException("Cant find such group");
        }
    }

    /**
     *
     * @param studId
     * @throws IdNotFoundException
     */
    private void checkStudentForExsistance(int studId) throws IdNotFoundException{

        boolean exsistanceFlag = false;
        for (StudentModel student:studentList) {
            if (studId == student.getId()){
                exsistanceFlag = true;
            }
        }

        if (!exsistanceFlag) {
            throw new IdNotFoundException("Не существует студента с таким id. "+studId);
        }
    }

    /**
     *
     * @param studId
     * @throws IdAlreadyExsistsException
     */
    private void checkIdForExsistance(int studId) throws IdAlreadyExsistsException{

        boolean exsistanceFlag = false;
        for (StudentModel student:studentList) {
            if (studId == student.getId()){
                exsistanceFlag = true;
            }
        }

        if (exsistanceFlag) {
            throw new IdAlreadyExsistsException("Студент с таким id уже существует. "+studId);
        }
    }

    public void dateChecker(String [] date) throws DateFormatException {

        DateFormatException exc = new DateFormatException("Wrong date format!");
        int year;
        int month;
        int day;

        if (date.length!=3){
            throw exc;
        }

        try{
            year = Integer.parseInt(date[0]);
            month = Integer.parseInt(date[1]);
            day = Integer.parseInt(date[2]);
        } catch (NumberFormatException e){
            throw exc;
        }

        if ((year<2000)||(year>2016)){
            throw exc;
        }
    }
}
