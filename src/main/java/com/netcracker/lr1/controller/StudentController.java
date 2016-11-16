package com.netcracker.lr1.controller;

import com.netcracker.lr1.model.*;
import java.io.*;
import java.util.*;


/**
 * Created by Арсений on 03.11.2016.
 */

/**
 *
 */
public class StudentController {

    private List<StudentModel> studentModelList;
    GroupController groupController = new GroupController();

    /**
     *
     */
    public StudentController() throws GroupNotFoundException {

        studentModelList = new ArrayList();
        String[] students;

        try(BufferedReader reader = new BufferedReader(new FileReader("src\\main\\java\\com\\netcracker\\lr1\\storageOfStudents.txt")))
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

                date = students[5].split("[.]");
                dateOfEnvironment.set(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));

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

    public StudentModel createStudentFromString(String student) throws GroupNotFoundException {

        StudentModel newStudent = new StudentModel();
        String [] studentData=student.split(" ");
        String [] date;
        Calendar dateOfEnvironment = new GregorianCalendar();
        int groupId;

        newStudent.setId(Integer.parseInt(studentData[0]));
        newStudent.setName(studentData[1]);
        newStudent.setSurname(studentData[2]);
        newStudent.setPatronymic(studentData[3]);
        groupId = Integer.parseInt(studentData[4]);

        checkGroupForExsistance(groupId);

        newStudent.setGroupId(groupId);
        date = studentData[5].split("[.]");
        dateOfEnvironment.set(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        newStudent.setDateOfEnrollment(dateOfEnvironment);

        return newStudent;
    }
    /**
     *
     * @param student
     */
    public void addStudent(String student) throws GroupNotFoundException {

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
    public void editStudent(int studentId, String studentData) throws IdNotFoundException, GroupNotFoundException {

        StudentModel newStudent = createStudentFromString(studentData);
        StudentModel stud = getStudentById(studentId);
        studentModelList.set( studentModelList.indexOf(stud),newStudent);
    }

    /**
     *
     * @param studentId
     * @param newId
     */
    public void editStudentId(int studentId, int newId) throws IdNotFoundException {

        StudentModel newStudent = getStudentById(studentId);
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
    public void editStudentGroupId(int studentId, int newGroupId) throws IdNotFoundException {

        try {
            checkGroupForExsistance(newGroupId);
        } catch (GroupNotFoundException e) {
            e.printStackTrace();
        }

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

    public void addDataFromAnotherFile(String filePath){

       List<StudentModel> newStudentModelList = new ArrayList();

        String [] path;
        path=filePath.split("[/]");

        try(ObjectInputStream reader = new ObjectInputStream( new FileInputStream(filePath)))
        {
            for (int i = 0; i <studentModelList.size(); i++) {

                StudentModel newModel;
                newModel = (StudentModel) reader.readObject();
                newStudentModelList.add(newModel);
            }

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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

    private void checkGroupForExsistance(int groupId) throws GroupNotFoundException{

        boolean exsistanceFlag = false;
        for (GroupModel group:groupController.getArrayListOfModels()) {
            if (groupId == group.getIdOfGroup()){
                exsistanceFlag = true;
            }
        }

        if (!exsistanceFlag) {
        throw new GroupNotFoundException("Группа не найдена.");
        }
    }

    private void checkStudentForExsistance(int studId) throws IdNotFoundException{

        boolean exsistanceFlag = false;
        for (StudentModel student:studentModelList) {
            if (studId == student.getId()){
                exsistanceFlag = true;
            }
        }

        if (!exsistanceFlag) {
            throw new IdNotFoundException("Не существует студента с таким id.");
        }
    }
}

