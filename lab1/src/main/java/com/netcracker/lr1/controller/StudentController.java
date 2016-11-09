package com.netcracker.lr1.controller;

import com.netcracker.lr1.model.*;

import java.io.*;
import java.util.*;


/**
 * Created by Арсений on 03.11.2016.
 */
public class StudentController {

    private List<StudentModel> studentModelList;

    public StudentController(){

        studentModelList=new ArrayList();
        String[] students;

        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Arsenii\\Desktop\\LR1\\src\\main\\java\\com\\netcracker\\lr1\\Storage.txt")))
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

    public void addStudent(StudentModel student){}

    public void deleteStudent(StudentModel student){}

    public void editStudent(StudentModel student, StudentModel newstudent){}

   // public StudentModel searchStudent(){}

    public void saveStudent(){}

    public void loadStudent(){}

    public void addDataFromAnotherFile(){}
}
