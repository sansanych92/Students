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

    /**
     *
     */
    public StudentController(){

        studentModelList=new ArrayList();
        String[] students;

        try(BufferedReader reader = new BufferedReader(new FileReader("lab1\\src\\main\\java\\com\\netcracker\\lr1\\Storage.txt")))
        {
            String s;
            while((s=reader.readLine())!=null){

                StudentModel student = new StudentModel();
                String [] date;
                Calendar dateOfEnvironment = new GregorianCalendar();

                students = s.split(" ");

                student.setId(Integer.parseInt(students[0]));
                student.setSurname(students[1]);
                student.setName(students[2]);
                student.setPatronymic(students[3]);
                student.setGroupId(Integer.parseInt(students[4]));

                date=students[5].split("[.]");
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
    public StudentModel getStudentById(int id){

        StudentModel student=new StudentModel();

        for (StudentModel student1:studentModelList) {

            if (student1.getId()==id){
                student=student1;
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

    /**
     *
     * @param student
     */
    public void addStudent(StudentModel student){
        studentModelList.add(student);
    }

    /**
     *
     * @param student
     */
    public void deleteStudent(StudentModel student){

        for (StudentModel student1:studentModelList) {

            if (student1.equals(student)){
                studentModelList.remove(student);
            }
        }
    }

    /**
     *
     * @param student
     * @param newStudent
     */
    public void editStudent(StudentModel student, StudentModel newStudent){

        for (StudentModel student1:studentModelList) {

            if (student1.equals(student)){
                student = newStudent;
            }
        }
    }

    /**
     *
     * @param student
     * @param newId
     */
    public void editStudentId(StudentModel student, int newId){

        for (StudentModel student1:studentModelList) {

            if (student1.equals(student)){
                StudentModel newStudent = studentModelList.get(studentModelList.indexOf(student));
                newStudent.setId(newId);
            }
        }
    }

    /**
     *
     * @param student
     * @param newSurname
     */
    public void editStudentSurname(StudentModel student, String newSurname){

        for (StudentModel student1:studentModelList) {

            if (student1.equals(student)){
                StudentModel newStudent = studentModelList.get(studentModelList.indexOf(student));
                newStudent.setSurname(newSurname);
            }
        }
    }

    /**
     *
     * @param student
     * @param newName
     */
    public void editStudentName(StudentModel student, String newName){

        for (StudentModel student1:studentModelList) {

            if (student1.equals(student)){
                StudentModel newStudent = studentModelList.get(studentModelList.indexOf(student));
                newStudent.setName(newName);
            }
        }
    }

    /**
     *
     * @param student
     * @param newPatronymic
     */
    public void editStudentPatronymic(StudentModel student, String newPatronymic){

        for (StudentModel student1:studentModelList) {

            if (student1.equals(student)){
                StudentModel newStudent = studentModelList.get(studentModelList.indexOf(student));
                newStudent.setPatronymic(newPatronymic);
            }
        }
    }

    /**
     *
     * @param student
     * @param newGroup
     */
    public void editStudentGroup(StudentModel student, int newGroup){

        for (StudentModel student1:studentModelList) {

            if (student1.equals(student)){
                StudentModel newStudent = studentModelList.get(studentModelList.indexOf(student));
                newStudent.setGroupId(newGroup);
            }
        }
    }

    /**
     *
     * @param student
     * @param dateOfEnvironment
     */
    public void editStudentDateOfEnvironment(StudentModel student, Calendar dateOfEnvironment){

        for (StudentModel student1:studentModelList) {

            if (student1.equals(student)){
                StudentModel newStudent = studentModelList.get(studentModelList.indexOf(student));
                newStudent.setDateOfEnrollment(dateOfEnvironment);
            }
        }
    }

    /**
     *
     */
    public void saveData(){

        try(ObjectOutputStream writer = new ObjectOutputStream( new FileOutputStream("lab1\\src\\main\\java\\com\\netcracker\\lr1\\Saved.xml")))
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

        studentModelList=new ArrayList();

        try(ObjectInputStream reader = new ObjectInputStream( new FileInputStream("lab1\\src\\main\\java\\com\\netcracker\\lr1\\Saved.xml")))
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
}

