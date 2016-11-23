import com.netcracker.lr1.Exceptions.GroupNotFoundException;
import com.netcracker.lr1.Exceptions.IdNotFoundException;
import com.netcracker.lr1.model.GroupModel;
import com.netcracker.lr1.model.StudentModel;
import com.netcracker.lr1.view.StudentView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Arsenii on 16.11.2016.
 */
public class Test {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, GroupNotFoundException {

        StudentView studentView = new StudentView();

        printMainMenu();

        int responce = Integer.parseInt(in.readLine());

        do {
            switch(responce){
                case 1:{
                    printAdditionMenu();
                    responce = Integer.parseInt(in.readLine());

                    switch(responce){
                        case 1:{
                            studentView.printAddNewStudentMenu();
                            break;
                        }
                        case 2:{
                            break;
                        }
                        case 3:{
                            break;
                        }
                    }

                    break;
                }
                case 2:{
                    printDeletionMenu();
                    responce = Integer.parseInt(in.readLine());

                    switch(responce){
                        case 1:{
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
                        case 2:{
                            break;
                        }
                        case 3:{
                            break;
                        }
                    }

                    break;

                }
                case 3:{
                    printEditionMenu();
                    responce = Integer.parseInt(in.readLine());

                    switch(responce){
                        case 1:{
                            boolean flag = true;
                            while (flag) {
                                try {
                                    studentView.printFullEditionOfStudentMenu();
                                    flag = false;
                                } catch (IdNotFoundException e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("Повторите ввод.");
                                }
                            }
                            break;
                        }
                        case 2:{
                            boolean flag = true;
                            while (flag) {
                                try {
                                    studentView.printEditionOfIdMenu();
                                    flag = false;
                                } catch (IdNotFoundException e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("Повторите ввод.");
                                }
                            }
                            break;
                        }
                        case 3:{
                            boolean flag = true;
                            while (flag) {
                                try {
                                    studentView.printEditionOfIdMenu();
                                    flag = false;
                                } catch (IdNotFoundException e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("Повторите ввод.");
                                }
                            }
                            break;
                        }
                        case 4:{
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
                        case 5:{
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
                        case 6:{
                            boolean flag = true;
                            while (flag) {
                                try {
                                    studentView.printEditionOfEnvironmentDateMenu();
                                    flag = false;
                                } catch (IdNotFoundException e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("Повторите ввод.");
                                }
                            }
                            break;
                        }
                        case 7:{
                            boolean flag = true;
                            while (flag) {
                                try {
                                    studentView.printEditionOfStudentsGroupIdMenu();
                                    flag = false;
                                } catch (IdNotFoundException e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("Повторите ввод.");
                                }
                            }
                            break;
                        }
                        case 8:{
                            break;
                        }
                        case 9:{
                            break;
                        }
                        case 0:{
                            break;
                        }
                        case 10:{
                            break;
                        }
                    }

                    break;
                }
                case 4:{
                    printReviewMenu();
                    responce = Integer.parseInt(in.readLine());

                    switch(responce){
                        case 1:{
                            studentView.printListOfStudents();
                            break;
                        }
                        case 2:{
                            break;
                        }
                        case 3:{
                            break;
                        }
                    }

                    break;
                }
                case 5:{
                    printSearchMenu();
                    responce = Integer.parseInt(in.readLine());

                    switch(responce){
                        case 1:{

                            break;
                        }
                        case 2:{

                            break;
                        }
                        case 3:{
                            break;
                        }
                        case 4:{

                            break;
                        }
                        case 5:{

                            break;
                        }
                        case 6:{
                            break;
                        }
                        case 7:{

                            break;
                        }
                        case 8:{

                            break;
                        }
                        case 9:{
                            break;
                        }
                        case 0:{

                            break;
                        }
                    }
                    break;
                }
                case 6:{
                    printSaveLoadMenu();
                    responce = Integer.parseInt(in.readLine());

                    switch(responce){
                        case 1:{
                            studentView.prindSaveDataMenu();
                            break;
                        }
                        case 2:{
                            studentView.prindLoadDataMenu();
                            break;
                        }
                        case 3:{
                            break;
                        }
                    }

                    break;
                }
                case 7:{
                    studentView.printLoadDataFromAnotherFileMenu();
                    break;
                }
                case 8:{
                    break;
                }
            }
        } while(responce!=8);
    }

    public static void printMainMenu(){

        System.out.println("1: Добавить данные.");
        System.out.println("2: Удалить данные.");
        System.out.println("3: Изменить данные.");
        System.out.println("4: Просмотреть данные.");
        System.out.println("5: Поиск данных.");
        System.out.println("6: сохранить/загрузить данные.");
        System.out.println("7: Добавить данные из другого файла.");
        System.out.println("8: Выход.");
    }

    public static void printAdditionMenu(){

        System.out.println("1: Добавить Нового Студента.");
        System.out.println("2: Добавить Новую Группу.");
        System.out.println("3: Выход в главное меню.");
    }

    public static void printDeletionMenu(){

        System.out.println("1: Удалить Студента.");
        System.out.println("2: Удалить Группу.");
        System.out.println("3: Выход в главное меню.");
    }

    public static void printEditionMenu(){

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

    public static void printReviewMenu(){

        System.out.println("1: Посмотреть список студентов.");
        System.out.println("2: Посмотреть список групп.");
        System.out.println("3: Выход в главное меню.");
    }

    public static void printSearchMenu(){

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

    public static void printSaveLoadMenu(){

        System.out.println("1: Сохранить данные.");
        System.out.println("2: Загрузить данные.");
        System.out.println("3: Выход в главное меню.");
    }

}
