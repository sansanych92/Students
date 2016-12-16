package Server.Controller;

import Server.Exceptions.GroupNotFoundException;
import Server.Exceptions.IdAlreadyExsistsException;
import Server.Exceptions.IdNotFoundException;
import Server.Model.GroupModel;
import Server.Model.Root;
import Server.Model.StudentModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by artur_v on 04.12.16.
 */
public class StudentController {

    private Root root;

    /**
     *
     */
    public StudentController() throws GroupNotFoundException, FileNotFoundException {

        root = new Root();
        try {
            File file = new File( "Students_lab2\\src\\Server\\Storage.xml");
            JAXBContext context = JAXBContext.newInstance(Root.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            root = (Root) unmarshaller.unmarshal(file);


        } catch (JAXBException ex) {
            Logger.getLogger(Root.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return
     */
    public Root getRoot() {
        return root;
    }

    /**
     *
     * @param root
     */
    public void setRoot(Root root) {
        this.root = root;
    }

    /**
     *
     * @param id
     * @return
     */
    public StudentModel getStudentById(int id) throws IdNotFoundException {

        StudentModel student = new StudentModel();
        checkStudentForExsistance(id);
        for (StudentModel student1:root.getStudentModelList()) {
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
        return root.getStudentModelList();
    }

    /**
     *
     * @param student
     */
    public void addStudent(StudentModel student) throws GroupNotFoundException, IdAlreadyExsistsException {

        checkIdForExsistance(student.getId());
        checkGroupForExsistance(student.getGroupId());
        root.getStudentModelList().add(student);
    }

    /**
     *
     * @param studentId
     */
    public void deleteStudent(int studentId) throws IdNotFoundException {

        StudentModel deletedStud = getStudentById(studentId);
        root.getStudentModelList().remove(deletedStud);
    }

    /**
     *
     * @param student
     */
    public void setStudent(StudentModel student) throws GroupNotFoundException, IdNotFoundException {

        checkGroupForExsistance(student.getGroupId());
        StudentModel oldStud = getStudentById(student.getId());
        root.getStudentModelList().set(root.getStudentModelList().indexOf(oldStud),student);
    }

    /**
     *
     */
    public void saveData(){

        try {
            File file = new File("Students_lab2\\src\\Server\\Saved.xml");
            JAXBContext context = JAXBContext.newInstance(Root.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(root, file);
        } catch (JAXBException ex) {
            Logger.getLogger(Root.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     */
    public void loadData(){

        try {
            File file = new File( "Students_lab2\\src\\Server\\Saved.xml");
            JAXBContext context = JAXBContext.newInstance(Root.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            root = (Root) unmarshaller.unmarshal(file);


        } catch (JAXBException ex) {
            Logger.getLogger(Root.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param filePath
     */
    public void addDataFromAnotherFile(String filePath) throws IOException, ClassNotFoundException, GroupNotFoundException, IdAlreadyExsistsException {
        //TODO do addition
    }

    /**
     *
     * @param groupId
     * @throws GroupNotFoundException
     */
    private void checkGroupForExsistance(int groupId) throws GroupNotFoundException{

        boolean exsistanceFlag = false;

        for (GroupModel group : root.getGroupModelList()) {
            if (groupId == group.getIdOfGroup()) {
                exsistanceFlag = true;

            }
        }

        if (!exsistanceFlag) {
            throw new GroupNotFoundException("Группа не найдена.");
        }
    }

    /**
     *
     * @param studId
     * @throws IdNotFoundException
     */
    public void checkStudentForExsistance(int studId) throws IdNotFoundException{

        boolean exsistanceFlag = false;
        for (StudentModel student:root.getStudentModelList()) {
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
        for (StudentModel student:root.getStudentModelList()) {
            if (studId == student.getId()){
                exsistanceFlag = true;
            }
        }

        if (exsistanceFlag) {
            throw new IdAlreadyExsistsException("Студент с таким id уже существует. "+studId);
        }
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
}
