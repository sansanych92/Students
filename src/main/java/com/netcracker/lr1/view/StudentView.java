package com.netcracker.lr1.view;

import com.netcracker.lr1.Exceptions.GroupNotFoundException;
import com.netcracker.lr1.Exceptions.IdAlreadyExsistsException;
import com.netcracker.lr1.Exceptions.IdNotFoundException;
import com.netcracker.lr1.controller.StudentController;
import com.netcracker.lr1.model.StudentModel;

import java.io.*;

/**
 * Created by Arsenii on 11.11.2016.
 */
public class StudentView {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public StudentController getController() {
        return controller;
    }

    private StudentController controller = new StudentController();

    /**
     *
     * @throws GroupNotFoundException
     */
    public StudentView() throws GroupNotFoundException, IdAlreadyExsistsException, FileNotFoundException {
    }

    /**
     *
     * @throws IOException
     * @throws GroupNotFoundException
     */
    public void printAddNewStudentMenu() throws IOException, GroupNotFoundException, IdAlreadyExsistsException {

        System.out.println("Введите данные студента (id, Фамилию, Имя, Отчество, id группы, дату зачисления в формате \"ГГГГ.ММ.ДД\") через пробел.");
        String student = in.readLine();
        controller.addStudent(student);
        System.out.println("Данные добавлены.");
    }

    /**
     *
     * @throws IOException
     * @throws IdNotFoundException
     */
    public void printDeleteStudentMenu() throws IOException, IdNotFoundException {

        System.out.println("Введите id студента, которого хотите удалить.");
        int id = Integer.parseInt(in.readLine());
        controller.deleteStudent(id);
        System.out.println("Студент удален.");
    }

    /**
     *
     * @throws IOException
     * @throws IdNotFoundException
     * @throws GroupNotFoundException
     */
    public void printFullEditionOfStudentMenu() throws IOException, IdNotFoundException, GroupNotFoundException, IdAlreadyExsistsException {

        System.out.println("Введите id студента, которого хотите отредактировать.");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Введите данные студента (id, Фамилию, Имя, Отчество, id группы, дату зачисления в формате \"ГГГГ.ММ.ДД\") через пробел.");
        String studentData = in.readLine();
        controller.editStudent(id,studentData);
        System.out.println("Студент отредактирован.");
    }

    /**
     *
     * @throws IOException
     * @throws IdNotFoundException
     */
    public void printEditionOfIdMenu() throws IOException {

        boolean flag = true;
        while (flag) {
            try {
                System.out.println("Введите id студента, которого хотите отредактировать.");
                int id = Integer.parseInt(in.readLine());
                controller.checkStudentForExsistance(id);
                System.out.println("Введите новый id студента.");
                int newId = Integer.parseInt(in.readLine());
                controller.editStudentId(id,newId);
                System.out.println("id студента отредактирован.");
                flag = false;
            } catch (IdAlreadyExsistsException | IdNotFoundException e) {
                System.out.println(e.getMessage());
                System.out.println("Повторите ввод.");
            }
        }
    }

    /**
     *
     * @throws IOException
     * @throws IdNotFoundException
     */
    public void printEditionOfNameMenu() throws IOException, IdNotFoundException {

        System.out.println("Введите id студента, которого хотите отредактировать.");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Введите новое имя студента.");
        String newName = in.readLine();
        controller.editStudentName(id,newName);
        System.out.println("Имя студента отредактировано.");
    }

    /**
     *
     * @throws IOException
     * @throws IdNotFoundException
     */
    public void printEditionOfSurnameMenu() throws IOException, IdNotFoundException {

        System.out.println("Введите id студента, которого хотите отредактировать.");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Введите новую фамилию студента.");
        String newSurname = in.readLine();
        controller.editStudentSurname(id,newSurname);
        System.out.println("Фамилия студента отредактирована.");
    }

    /**
     *
     * @throws IOException
     * @throws IdNotFoundException
     */
    public void printEditionOfPatronymicMenu() throws IOException, IdNotFoundException {

        System.out.println("Введите id студента, которого хотите отредактировать.");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Введите новое отчество студента.");
        String newPatronymic = in.readLine();
        controller.editStudentPatronymic(id,newPatronymic);
        System.out.println("Отчество студента отредактировано.");
    }

    /**
     *
     * @throws IOException
     * @throws IdNotFoundException
     */
    public void printEditionOfEnvironmentDateMenu() throws IOException, IdNotFoundException {

        System.out.println("Введите id студента, которого хотите отредактировать.");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Введите новую дату зачисления студента в формате \"ГГГГ.ММ.ДД\".");
        String newDate = in.readLine();
        controller.editStudentDateOfEnvironment(id,newDate);
        System.out.println("Дата зачисления студента отредактирована.");
    }

    /**
     *
     * @throws IOException
     * @throws IdNotFoundException
     */
    public void printEditionOfStudentsGroupIdMenu() throws IOException, IdNotFoundException, GroupNotFoundException {

        System.out.println("Введите id студента, которого хотите отредактировать.");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Введите новый id группы студента.");
        int newGroupId = Integer.parseInt(in.readLine());
        controller.editStudentGroupId(id, newGroupId);
        System.out.println("id группы студента отредактирован.");
    }

    /**
     *
     */
    public void  prindSaveDataMenu() {

        controller.saveData();
        System.out.println("Данные сохранены.");
    }

    /**
     *
     * @throws IOException
     */
    public void  prindLoadDataMenu() throws IOException {

        controller.loadData();
        System.out.println("Данные загружены.");
    }

    /**
     *
     * @throws IOException
     */
    public void printLoadDataFromAnotherFileMenu() throws IOException {

        System.out.println("Введите путь файла, откуда нужно добавить данные.");
        boolean flag = true;
        while (flag) {
            String path = in.readLine();
            try {
                controller.addDataFromAnotherFile(path);
                flag = false;
            }
            catch (EOFException e) {
                System.out.println("Недопустимый файл.");
                System.out.println("Повторите ввод.");
            }
            catch (FileNotFoundException e) {
                System.out.println("Файл не найден.");
                System.out.println("Повторите ввод.");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (GroupNotFoundException | IdAlreadyExsistsException e) {
                e.getMessage();
            }
        }
        System.out.println("Данные добавлены.");
    }

    /**
     *
     */
    public void printListOfStudents(){

        for (StudentModel student:controller.getStudentList()) {
            System.out.println(student.toString());
        }
    }

    /**
     *
     * @throws IOException
     */
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

    /**
     *
     * @throws IOException
     */
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

    /**
     *
     * @throws IOException
     */
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

    /**
     *
     * @throws IOException
     */
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

    /**
     *
     * @throws IOException
     */
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

    /**
     *
     * @throws IOException
     */
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
