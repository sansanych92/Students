package com.netcracker.lr1;

import com.netcracker.lr1.controller.StudentController;
import com.netcracker.lr1.model.StudentModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Арсений on 03.11.2016.
 */
public class Main {
    public static void main(String[] args) {

        StudentController controller=new StudentController();

        /*for (int i = 0; i <controller.getStudentList().size(); i++) {
            System.out.println(controller.getStudentList().get(i).toString());
        }

        Calendar date=new GregorianCalendar();

        date.set(2017,11,23);

        controller.editStudentDateOfEnvironment(controller.getStudentById(1), date);

        StudentModel newStudent=new StudentModel();

        newStudent.setSurname("Сидоров");
        newStudent.setName("Генадий");
        newStudent.setPatronymic("Петрович");
        newStudent.setId(4);
        newStudent.setDateOfEnrollment(new GregorianCalendar(2020,9,21));

        controller.addStudent(newStudent);


        for (int i = 0; i <controller.getStudentList().size(); i++) {
            System.out.println(controller.getStudentList().get(i).toString());
        }*/

       controller.saveData();

        for (int i = 0; i <controller.getStudentList().size(); i++) {
            System.out.println(controller.getStudentList().get(i).toString());
        }

        controller.loadData();

        for (int i = 0; i <controller.getStudentList().size(); i++) {
            System.out.println(controller.getStudentList().get(i).toString());
        }
    }
}
