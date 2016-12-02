package com.netcracker.lr1.view;

import com.netcracker.lr1.Exceptions.GroupNotFoundException;
import com.netcracker.lr1.Exceptions.IdAlreadyExsistsException;
import com.netcracker.lr1.Exceptions.IdNotFoundException;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by artur_v on 07.11.16.
 */
public class MainView {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, GroupNotFoundException, IdAlreadyExsistsException {

        StudentView studentView = new StudentView();
        GroupView groupView = new GroupView(studentView.getController().getGroupController());

        String responce = "";
        do {
            printMainMenu();

            responce = in.readLine();
            responce = responce.trim();


            switch (responce) {
                case "1": {
                    do {
                        printAdditionMenu();
                        responce = in.readLine();
                        responce = responce.trim();


                        switch (responce) {
                            case "1": {
                                boolean flag = true;
                                while (flag) {
                                    try {
                                        studentView.printAddNewStudentMenu();
                                        flag = false;
                                    } catch (NumberFormatException | IdAlreadyExsistsException | GroupNotFoundException ex) {
                                        System.out.println(ex.getMessage());
                                        System.out.println("Повторите ввод.");
                                    }
                                    catch (ArrayIndexOutOfBoundsException ex) {
                                        System.out.println("Неверный формат даты.");
                                        System.out.println("Повторите ввод.");
                                    }
                                }
                                break;
                            }
                            case "2": {
                                boolean flag = true;
                                while(flag){
                                    try {
                                        groupView.printAddNewGroupMenu();
                                        flag = false;
                                    } catch (NumberFormatException | IdAlreadyExsistsException ex){
                                        System.out.println(ex.getMessage());
                                        System.out.println("Повторите ввод.");
                                    }
                                }
                                break;
                            }
                            case "3": {
                                break;
                            }
                            default: {
                                System.out.println("Введены неверные данные.");
                                break;
                            }
                        }
                    } while (!responce.equals("3"));

                    break;
                }
                case "2": {
                    do {
                        printDeletionMenu();
                        responce = in.readLine();
                        responce = responce.trim();

                        switch (responce) {
                            case "1": {
                                boolean flag = true;
                                while (flag) {
                                    try {
                                        studentView.printDeleteStudentMenu();
                                        flag = false;
                                    } catch (IdNotFoundException e) {
                                        System.out.println(e.getMessage());
                                        System.out.println("Повторите ввод.");
                                    }
                                }
                                break;
                            }
                            case "2": {
                                boolean flag = true;
                                while (flag) {
                                   /*
                                    try {
                                        //groupView.printDeleteStudentMenu();
                                        flag = false;
                                    }
                                    */
                                }
                                break;
                            }
                            case "3": {
                                break;
                            }
                            default: {
                                System.out.println("Введены неверные данные.");
                                break;
                            }
                        }
                    } while (!responce.equals("3"));
                    break;
                }
                case "3": {
                    do {
                        printEditionMenu();
                        responce = in.readLine();
                        responce = responce.trim();


                        switch (responce) {
                            case "1": {
                                boolean flag = true;
                                while (flag) {
                                    try {
                                        studentView.printFullEditionOfStudentMenu();
                                        flag = false;
                                    } catch (IdNotFoundException | IdAlreadyExsistsException | NumberFormatException | GroupNotFoundException e) {
                                        System.out.println(e.getMessage());
                                        System.out.println("Повторите ввод.");
                                    }
                                    catch (ArrayIndexOutOfBoundsException ex) {
                                        System.out.println("Неверный формат даты.");
                                        System.out.println("Повторите ввод.");
                                    }
                                }
                                break;
                            }
                            case "2": {
                                studentView.printEditionOfIdMenu();
                                break;
                            }
                            case "3": {
                                boolean flag = true;
                                while (flag) {
                                    try {
                                        studentView.printEditionOfNameMenu();
                                        flag = false;
                                    } catch (IdNotFoundException e) {
                                        System.out.println(e.getMessage());
                                        System.out.println("Повторите ввод.");
                                    }
                                }
                                break;
                            }
                            case "4": {
                                boolean flag = true;
                                while (flag) {
                                    try {
                                        studentView.printEditionOfSurnameMenu();
                                        flag = false;
                                    } catch (IdNotFoundException e) {
                                        System.out.println(e.getMessage());
                                        System.out.println("Повторите ввод.");
                                    }
                                }
                                break;
                            }
                            case "5": {
                                boolean flag = true;
                                while (flag) {
                                    try {
                                        studentView.printEditionOfPatronymicMenu();
                                        flag = false;
                                    } catch (IdNotFoundException e) {
                                        System.out.println(e.getMessage());
                                        System.out.println("Повторите ввод.");
                                    }
                                }
                                break;
                            }
                            case "6": {
                                boolean flag = true;
                                while (flag) {
                                    try {
                                        studentView.printEditionOfEnvironmentDateMenu();
                                        flag = false;
                                    } catch (IdNotFoundException | NumberFormatException e) {
                                        System.out.println(e.getMessage());
                                        System.out.println("Повторите ввод.");
                                    }
                                    catch (ArrayIndexOutOfBoundsException e) {
                                        System.out.println("Неверный формат даты.");
                                        System.out.println("Повторите ввод.");
                                    }
                                }
                                break;
                            }
                            case "7": {
                                boolean flag = true;
                                while (flag) {
                                    try {
                                        studentView.printEditionOfStudentsGroupIdMenu();
                                        flag = false;
                                    } catch (IdNotFoundException |GroupNotFoundException |NumberFormatException e) {
                                        System.out.println(e.getMessage());
                                        System.out.println("Повторите ввод.");
                                    }
                                }
                                break;
                            }
                            case "8": {
                                break;
                            }
                            case "9": {
                                break;
                            }
                            case "0": {
                                break;
                            }
                            case "10": {
                                break;
                            }
                            default: {
                                System.out.println("Введены неверные данные.");
                                break;
                            }
                        }
                    } while (!responce.equals("10"));

                    break;
                }
                case "4": {
                    do {
                        printReviewMenu();
                        responce = in.readLine();
                        responce = responce.trim();


                        switch (responce) {
                            case "1": {
                                studentView.printListOfStudents();
                                break;
                            }
                            case "2": {
                                groupView.printListOfGroups();
                                break;
                            }
                            case "3": {
                                break;
                            }
                            default: {
                                System.out.println("Введены неверные данные.");
                                break;
                            }
                        }
                    } while (!responce.equals("3"));
                    break;
                }
                case "5": {
                    do {
                        printSearchMenu();
                        responce = in.readLine();
                        responce = responce.trim();


                        switch (responce) {
                            case "1": {
                                studentView.printSearchStudentByIdMenu();
                                break;
                            }
                            case "2": {
                                studentView.printSearchStudentByNameMenu();
                                break;
                            }
                            case "3": {
                                studentView.printSearchStudentBySurnameMenu();
                                break;
                            }
                            case "4": {
                                studentView.printSearchStudentByPatronymicMenu();
                                break;
                            }
                            case "5": {
                                boolean flag = true;
                                while (flag) {
                                    try {
                                        studentView.printSearchStudentByDateOfEnvironmentMenu();
                                        flag = false;
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                        System.out.println("Неверный формат даты.");
                                        System.out.println("Повторите ввод.");
                                    }
                                }
                                break;
                            }
                            case "6": {
                                studentView.printSearchStudentByStudntsGroupIdMenu();
                                break;
                            }
                            case "7": {

                                break;
                            }
                            case "8": {

                                break;
                            }
                            case "9": {
                                break;
                            }
                            case "0": {

                                break;
                            }
                            default: {
                                System.out.println("Введены неверные данные.");
                                break;
                            }
                        }
                    } while (!responce.equals("0"));
                    break;
                }
                case "6": {
                    do {
                        printSaveLoadMenu();
                        responce = in.readLine();
                        responce = responce.trim();


                        switch (responce) {
                            case "1": {
                                studentView.prindSaveDataMenu();
                                break;
                            }
                            case "2": {
                                studentView.prindLoadDataMenu();
                                break;
                            }
                            case "3": {
                                break;
                            }
                            default: {
                                System.out.println("Введены неверные данные.");
                                break;
                            }
                        }
                    } while (!responce.equals("3"));

                    break;
                }
                case "7": {
                    studentView.printLoadDataFromAnotherFileMenu();
                    break;
                }
                case "8": {
                    break;
                }
                default: {
                    System.out.println("Введены неверные данные.");
                    break;
                }
            }
        } while(!Objects.equals(responce, "8"));
    }

    private static void printMainMenu(){

        System.out.println("1: Добавить данные.");
        System.out.println("2: Удалить данные.");
        System.out.println("3: Изменить данные.");
        System.out.println("4: Просмотреть данные.");
        System.out.println("5: Поиск данных.");
        System.out.println("6: сохранить/загрузить данные.");
        System.out.println("7: Добавить данные из другого файла.");
        System.out.println("8: Выход.");
    }

    private static void printAdditionMenu(){

        System.out.println("1: Добавить Нового Студента.");
        System.out.println("2: Добавить Новую Группу.");
        System.out.println("3: Выход в главное меню.");
    }

    private static void printDeletionMenu(){

        System.out.println("1: Удалить Студента.");
        System.out.println("2: Удалить Группу.");
        System.out.println("3: Выход в главное меню.");
    }

    private static void printEditionMenu(){

        System.out.println("1: Полностью редактировать студента.");
        System.out.println("2: Редактировать id студента.");
        System.out.println("3: Редактировать имя студента.");
        System.out.println("4: Редактировать Фамилию студента.");
        System.out.println("5: Редактировать отчество студента.");
        System.out.println("6: Редактировать дату зачисления студента.");
        System.out.println("7: Редактировать id группы Студента.");
        System.out.println("8: Редактировать id группы.");
        System.out.println("9: Редактировать номер группы.");
        System.out.println("0: Редактировать Факультет группы.");
        System.out.println("10: Выход в главное меню.");
    }

    private static void printReviewMenu(){

        System.out.println("1: Посмотреть список студентов.");
        System.out.println("2: Посмотреть список групп.");
        System.out.println("3: Выход в главное меню.");
    }

    private static void printSearchMenu(){

        System.out.println("Выполнить поиск по:");
        System.out.println("1: id студента.");
        System.out.println("2: Имени студента.");
        System.out.println("3: Фамилии студента.");
        System.out.println("4: Отчеству студента.");
        System.out.println("5: Дате зачисления студента.");
        System.out.println("6: id группы Студента.");
        System.out.println("7: id группы.");
        System.out.println("8: Номеру группы.");
        System.out.println("9: Факультету группы.");
        System.out.println("0: Выход в главное меню.");
    }

    private static void printSaveLoadMenu(){

        System.out.println("1: Сохранить данные.");
        System.out.println("2: Загрузить данные.");
        System.out.println("3: Выход в главное меню.");
    }

}
