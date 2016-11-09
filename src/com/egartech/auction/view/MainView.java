package com.egartech.auction.view;

import com.egartech.auction.controller.UserController;
import com.egartech.auction.model.AbstractUser;
import com.egartech.auction.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * Created by Артем Громовержец on 20.10.2016.
 */

/**
 * Main view of auction.
 */
public class MainView {

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

        AbstractUser localUser=new User();
        String responce1 = "";

        System.out.println("1: Авторизоваться.");
        System.out.println("2: Продолжить без авторизации.");
        System.out.println("3: Выход.");

        int responce = Integer.parseInt(in.readLine());

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
                         localUser = userController.getUser(loginPass[0], loginPass[1]);

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

                            userView.printMyOwnStatistics(localUser);

                            break;
                        }

                        case 4: {

                            if (Objects.equals(localUser.getAccessRight(), "admin"))
                                adminView.printUsersStatistics();

                            else
                                System.out.println("Этот пункт меню доступен только для администраторов.");

                            break;
                        }

                        case 5: {

                            betsView.printAddBetMenu(localUser);

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
