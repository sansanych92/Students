package com.netcracker.lr1.controller;

import com.netcracker.lr1.Exceptions.GroupNotFoundException;
import com.netcracker.lr1.Exceptions.IdAlreadyExsistsException;
import com.netcracker.lr1.Exceptions.IdNotFoundException;
import com.netcracker.lr1.model.*;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Арсений on 03.11.2016.
 */

/**
 *
 */
public class StudentController {

    private List<StudentModel> studentModelList;

    public GroupController getGroupController() {
        return groupController;
    }

    private GroupController groupController;

    /**
     *
     */
    public StudentController() throws GroupNotFoundException, IdAlreadyExsistsException, FileNotFoundException {

        studentModelList = new ArrayList();
        String[] students;
        groupController = new GroupController();

        try(BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/netcracker/lr1/storageOfStudents.txt")))
        {
            String s;
            while((s=reader.readLine())!=null){

                StudentModel student = new StudentModel();
                String [] date;
                Calendar dateOfEnvironment = new GregorianCalendar();
                int groupId;

                students = s.split(" ");

                student.setId(Integer.valueOf(students[0]));
                student.setSurname(students[1]);
                student.setName(students[2]);
                student.setPatronymic(students[3]);
                groupId = Integer.parseInt(students[4]);

                checkGroupForExsistance(groupId);

                student.setGroupId(groupId);

                date = students[5].split("[.]");
                dateOfEnvironment.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date[2]));

                student.setDateOfEnrollment(dateOfEnvironment);

                studentModelList.add(student);
            }

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public StudentModel getStudentById(int id) throws IdNotFoundException {

        StudentModel student = new StudentModel();

        checkStudentForExsistance(id);

        for (StudentModel student1:studentModelList) {

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
        return studentModelList;
    }

    public StudentModel createStudentFromString(String student) throws GroupNotFoundException, IdAlreadyExsistsException {

        StudentModel newStudent = new StudentModel();
        String [] studentData=student.split(" ");
        String [] date;
        int groupId;

        newStudent.setId(Integer.parseInt(studentData[0]));
        newStudent.setName(studentData[1]);
        newStudent.setSurname(studentData[2]);
        newStudent.setPatronymic(studentData[3]);
        groupId = Integer.parseInt(studentData[4]);

        checkGroupForExsistance(groupId);


        checkIdForExsistance(Integer.parseInt(studentData[0]));

        newStudent.setGroupId(groupId);
        date = studentData[5].split("[.]");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1])-1;
        int day = Integer.parseInt(date[2]);
        Calendar dateOfEnvironment = new GregorianCalendar(year, month, day);

        newStudent.setDateOfEnrollment(dateOfEnvironment);

        return newStudent;
    }
    /**
     *
     * @param student
     */
    public void addStudent(String student) throws GroupNotFoundException, IdAlreadyExsistsException {

        studentModelList.add(createStudentFromString(student));
    }

    /**
     *
     * @param studentId
     */
    public void deleteStudent(int studentId) throws IdNotFoundException {

        StudentModel deletedStud = getStudentById(studentId);
        studentModelList.remove(deletedStud);
    }

    /**
     *
     * @param studentId
     * @param studentData
     */
    public void editStudent(int studentId, String studentData) throws IdNotFoundException, GroupNotFoundException, IdAlreadyExsistsException {

        StudentModel newStudent = createStudentFromString(studentData);
        StudentModel stud = getStudentById(studentId);
        studentModelList.set( studentModelList.indexOf(stud),newStudent);
    }

    /**
     *
     * @param studentId
     * @param newId
     */
    public void editStudentId(int studentId, int newId) throws IdNotFoundException, IdAlreadyExsistsException {

        StudentModel newStudent = getStudentById(studentId);
        checkIdForExsistance(newId);
        newStudent.setId(newId);

    }

    /**
     *
     * @param studentId
     * @param newSurname
     */
    public void editStudentSurname(int studentId, String newSurname) throws IdNotFoundException {

        StudentModel newStudent = getStudentById(studentId);
        newStudent.setSurname(newSurname);
    }

    /**
     *
     * @param studentId
     * @param newName
     */
    public void editStudentName(int studentId, String newName) throws IdNotFoundException {

        StudentModel newStudent = getStudentById(studentId);
        newStudent.setName(newName);
    }

    /**
     *
     * @param studentId
     * @param newPatronymic
     */
    public void editStudentPatronymic(int studentId, String newPatronymic) throws IdNotFoundException {

        StudentModel newStudent = getStudentById(studentId);
        newStudent.setPatronymic(newPatronymic);
    }

    /**
     *
     * @param studentId
     * @param newGroupId
     */
    public void editStudentGroupId(int studentId, int newGroupId) throws IdNotFoundException, GroupNotFoundException {

        checkGroupForExsistance(newGroupId);
        checkStudentForExsistance(studentId);
        StudentModel newStudent = getStudentById(studentId);
        newStudent.setGroupId(newGroupId);

    }

    /**
     *
     * @param studentId
     * @param dateOfEnvironment
     */
    public void editStudentDateOfEnvironment(int studentId, String dateOfEnvironment) throws IdNotFoundException {

        String date [];
        Calendar newDate = new GregorianCalendar();
        StudentModel newStudent = getStudentById(studentId);
        date = dateOfEnvironment.split("[.]");
        newDate.set(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        newStudent.setDateOfEnrollment(newDate);
    }

    /**
     *
     */
    public void saveData(){

        try(ObjectOutputStream writer = new ObjectOutputStream( new FileOutputStream("src\\main\\java\\com\\netcracker\\lr1\\Saved.txt")))
        {
            for (int i = 0; i <studentModelList.size(); i++) {

                writer.writeObject(studentModelList.get(i));
            }

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     */
    public void loadData(){

        studentModelList = new ArrayList();

        try(ObjectInputStream reader = new ObjectInputStream( new FileInputStream("lab1\\src\\main\\java\\com\\netcracker\\lr1\\Saved.txt")))
        {
            for (int i = 0; i <studentModelList.size(); i++) {

                StudentModel newModel;
                newModel = (StudentModel) reader.readObject();
                studentModelList.add(newModel);
            }

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param filePath
     */
    public void addDataFromAnotherFile(String filePath) throws IOException, ClassNotFoundException, GroupNotFoundException {

       List<StudentModel> newStudentModelList = new ArrayList();
        String[] students;

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String s;
            while((s=reader.readLine())!=null){

                StudentModel student = new StudentModel();
                String [] date;
                Calendar dateOfEnvironment = new GregorianCalendar();
                int groupId;

                students = s.split(" ");

                student.setId(Integer.valueOf(students[0]));
                student.setSurname(students[1]);
                student.setName(students[2]);
                student.setPatronymic(students[3]);
                groupId = Integer.parseInt(students[4]);

                checkGroupForExsistance(groupId);

                student.setGroupId(groupId);

                date = students[5].split("[.]");
                dateOfEnvironment.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date[2]));

                student.setDateOfEnrollment(dateOfEnvironment);

                newStudentModelList.add(student);
            }

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        for (StudentModel aNewStudent : newStudentModelList) {

            boolean coincidenceFlag = false;

            for (StudentModel aStudent : studentModelList) {
                if (aStudent.equals(aNewStudent)) {
                    coincidenceFlag = true;
                }
            }

            if (!coincidenceFlag) {
                studentModelList.add(aNewStudent);
            }
        }
    }

    /**
     *
     * @param groupId
     * @throws GroupNotFoundException
     */
    private void checkGroupForExsistance(int groupId) throws GroupNotFoundException{

        boolean exsistanceFlag = false;

            for (GroupModel group : groupController.getArrayListOfModels()) {
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
    private void checkStudentForExsistance(int studId) throws IdNotFoundException{

        boolean exsistanceFlag = false;
        for (StudentModel student:studentModelList) {
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
        for (StudentModel student:studentModelList) {
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

