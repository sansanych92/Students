package com.egartech.auction.view;

import com.egartech.auction.controller.UserController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * Created by Артем Громовержец on 20.10.2016.
 */

/**
 * View class shows to user all information about model
 */
public class View {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private ProductView productView = new ProductView();
    private BetsView betsView = new BetsView();
    private UserView userView = new UserView();
    private AdminView adminView = new AdminView();
    private UserController userController = new UserController();

    /**
     * Method starts main menu.
     */
    public void mainMenu() throws IOException {

        int responce = Integer.parseInt(in.readLine());
        String responce1 = "";
        boolean adminFlag = false;

        System.out.println("1: Авторизоваться.");
        System.out.println("2: Продолжить без авторизации.");
        System.out.println("3: Выход.");

         switch (responce){

             case 1:{

                 autorizationWindow();

                 responce1 = in.readLine();

                 String [] loginPass = responce1.split(" ");

                 do {
                     if ((userController.getUser(loginPass[0],loginPass[1]) == null)) {

                         System.out.println("Пользователя с такими данными не существует.");

                         mainMenu();
                     }

                else {
                         if (Objects.equals(userController.getUser(loginPass[0], loginPass[1]).getAccessRight(), "admin"))

                             adminFlag = true;

                         continueWithAutorization();

                         responce = Integer.parseInt(in.readLine());
                }

                    switch (responce) {

                        case 1: {

                            productView.printLotsByCategory();

                            break;
                        }

                        case 2: {

                            betsView.printBetsByLot();

                            break;
                        }

                        case 3: {

                            userView.printMyOwnStatistics(loginPass[0], loginPass[1]);

                            break;
                        }

                        case 4: {

                            if (adminFlag)
                                adminView.printUsersStatistics();

                            else
                                System.out.println("Этот пункт меню доступен только для администраторов.");

                            break;
                        }

                        case 5: {

                            betsView.printAddBetMenu(loginPass);

                            break;
                        }

                        case 6: {

                            break;
                        }
                    }

                 } while(responce!=6);

                 break;
             }

             case 2:{

                continueWithoutAutorization();

                do {
                    responce = Integer.parseInt(in.readLine());

                    switch (responce) {

                        case 1: {

                            productView.printLotsByCategory();

                            continueWithoutAutorization();

                            break;
                        }

                        case 2: {

                            betsView.printBetsByLot();

                            continueWithoutAutorization();

                            break;
                        }

                        case 3: {

                            break;
                        }
                    }
                } while(responce!=3);

                 break;
             }

            case 3:

                break;
         }
    }

    private void autorizationWindow(){

        System.out.println("Введите логин и пароль через пробел.");
    }

    private void continueWithoutAutorization(){

        System.out.println("1: Просмотреть список лотов по категории.");
        System.out.println("2: Просмотреть список ставок по лоту.");
        System.out.println("3: Выход.");
    }


    private void continueWithAutorization(){

        System.out.println("1: Просмотреть список лотов по категории.");
        System.out.println("2: Просмотреть список ставок по лоту.");
        System.out.println("3: Посмотреть список своих лотов и ставок по ним.");
        System.out.println("4: Просмотреть статистику по пользователям.(Только Админ)");
        System.out.println("5: Сделать ставку.");
        System.out.println("6: Выход.");
    }

}
