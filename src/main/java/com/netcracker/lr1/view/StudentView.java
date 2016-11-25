package com.netcracker.lr1.view;

import com.netcracker.lr1.Exceptions.GroupNotFoundException;
import com.netcracker.lr1.Exceptions.IdNotFoundException;
import com.netcracker.lr1.controller.StudentController;
import com.netcracker.lr1.model.StudentModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Arsenii on 11.11.2016.
 */
public class StudentView {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StudentController controller = new StudentController();

    public StudentView() throws GroupNotFoundException {
    }

    public void printAddNewStudentMenu() throws IOException, GroupNotFoundException {

        System.out.println("Введите данные студента (id, Фамилию, Имя, Отчество, id группы, дату зачисления) через пробел.");
        String student = in.readLine();
        controller.addStudent(student);
        System.out.println("Данные добавлены.");
    }

    public void printDeleteStudentMenu() throws IOException, IdNotFoundException {

        System.out.println("Введите id студента, которого хотите удалить.");
        int id = Integer.parseInt(in.readLine());
        controller.deleteStudent(id);
        System.out.println("Студент удален.");
    }

    public void printFullEditionOfStudentMenu() throws IOException, IdNotFoundException, GroupNotFoundException {

        System.out.println("Введите id студента, которого хотите отредактировать.");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Введите данные студента (id, Фамилию, Имя, Отчество, id группы, дату зачисления) через пробел.");
        String studentData = in.readLine();
        controller.editStudent(id,studentData);
        System.out.println("Студент отредактирован.");
    }

    public void printEditionOfIdMenu() throws IOException, IdNotFoundException {

        System.out.println("Введите id студента, которого хотите отредактировать.");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Введите новый id студента.");
        int newId = Integer.parseInt(in.readLine());
        controller.editStudentId(id,newId);
        System.out.println("id студента отредактирован.");
    }

    public void printEditionOfNameMenu() throws IOException, IdNotFoundException {

        System.out.println("Введите id студента, которого хотите отредактировать.");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Введите новое имя студента.");
        String newName = in.readLine();
        controller.editStudentName(id,newName);
        System.out.println("Имя студента отредактировано.");
    }

    public void printEditionOfSurnameMenu() throws IOException, IdNotFoundException {

        System.out.println("Введите id студента, которого хотите отредактировать.");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Введите новую фамилию студента.");
        String newSurname = in.readLine();
        controller.editStudentSurname(id,newSurname);
        System.out.println("Фамилия студента отредактирована.");
    }

    public void printEditionOfPatronymicMenu() throws IOException, IdNotFoundException {

        System.out.println("Введите id студента, которого хотите отредактировать.");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Введите новое отчество студента.");
        String newPatronymic = in.readLine();
        controller.editStudentPatronymic(id,newPatronymic);
        System.out.println("Отчество студента отредактировано.");
    }

    public void printEditionOfEnvironmentDateMenu() throws IOException, IdNotFoundException {

        System.out.println("Введите id студента, которого хотите отредактировать.");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Введите новую дату зачисления студента.");
        String newDate = in.readLine();
        controller.editStudentDateOfEnvironment(id,newDate);
        System.out.println("Дата зачисления студента отредактирована.");
    }

    public void printEditionOfStudentsGroupIdMenu() throws IOException, IdNotFoundException {

        System.out.println("Введите id студента, которого хотите отредактировать.");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Введите новый id группы студента.");
        int newGroupId = Integer.parseInt(in.readLine());
        controller.editStudentGroupId(id, newGroupId);
        System.out.println("id группы студента отредактирован.");
    }

    public void  prindSaveDataMenu() {

        controller.saveData();
        System.out.println("Данные сохранены.");
    }

    public void  prindLoadDataMenu() throws IOException {

        controller.loadData();
        System.out.println("Данные загружены.");
    }

    public void printLoadDataFromAnotherFileMenu() throws IOException {

        System.out.println("Введите путь файла, откуда нужно добавить данные.");
        String path = in.readLine();
        controller.addDataFromAnotherFile(path);
        System.out.println("Данные добавлены.");
    }

    public void printListOfStudents(){

        System.out.println(controller.getStudentList());
    }

    public void printSearchStudentByIdMenu() throws IOException {

        System.out.println("Введите Id студента или его шаблон, по которому хотите найти студента.");
        String id = in.readLine();

        if (controller.searchStudentById(id).isEmpty()){
            System.out.println("Студенты не найдены");
        } else{
            System.out.println("Найденные студенты:");
            for (StudentModel student:controller.searchStudentById(id)) {
                System.out.println(student.toString());
            }
        }
    }

    public void printSearchStudentByNameMenu() throws IOException {

        System.out.println("Введите имя студента или его шаблон, по которому хотите найти студента.");
        String name = in.readLine();

        if (controller.searchStudentByName(name).isEmpty()){
            System.out.println("Студенты не найдены");
        } else{
            System.out.println("Найденные студенты:");
            for (StudentModel student:controller.searchStudentByName(name)) {
                System.out.println(student.toString());
            }
        }
    }

    public void printSearchStudentBySurnameMenu() throws IOException {

        System.out.println("Введите фамилию студента или ее шаблон, по которому хотите найти студента.");
        String surName = in.readLine();

        if (controller.searchStudentBySurname(surName).isEmpty()){
            System.out.println("Студенты не найдены");
        } else{
            System.out.println("Найденные студенты:");
            for (StudentModel student:controller.searchStudentBySurname(surName)) {
                System.out.println(student.toString());
            }
        }
    }

    public void printSearchStudentByPatronymicMenu() throws IOException {

        System.out.println("Введите отчество студента или его шаблон, по которому хотите найти студента.");
        String patro = in.readLine();

        if (controller.searchStudentByPatronymic(patro).isEmpty()){
            System.out.println("Студенты не найдены");
        } else{
            System.out.println("Найденные студенты:");
            for (StudentModel student:controller.searchStudentByPatronymic(patro)) {
                System.out.println(student.toString());
            }
        }
    }

    public void printSearchStudentByStudntsGroupIdMenu() throws IOException {

        System.out.println("Введите id группы студента или его шаблон, по которому хотите найти студента.");
        String groupIdOfStudent = in.readLine();

        if (controller.searchStudentByIdOfStudentsGroup(groupIdOfStudent).isEmpty()){
            System.out.println("Студенты не найдены");
        } else{
            System.out.println("Найденные студенты:");
            for (StudentModel student:controller.searchStudentByIdOfStudentsGroup(groupIdOfStudent)) {
                System.out.println(student.toString());
            }
        }
    }

    public void printSearchStudentByDateOfEnvironmentMenu() throws IOException {

        System.out.println("Введите дату зачисления студента или ее шаблон, по которому хотите найти студента.");
        String date = in.readLine();

        if (controller.searchStudentByDateOfEnvironment(date).isEmpty()){
            System.out.println("Студенты не найдены");
        } else{
            System.out.println("Найденные студенты:");
            for (StudentModel student:controller.searchStudentByDateOfEnvironment(date)) {
                System.out.println(student.toString());
            }
        }
    }
}
