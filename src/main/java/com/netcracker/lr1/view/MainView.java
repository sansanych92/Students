package com.netcracker.lr1.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by artur_v on 07.11.16.
 */
public class MainView {

    public static void main(String [] args) throws IOException {
        GroupView groupView = new GroupView();
        Scanner scanner = new Scanner(System.in);
        int selectInt;
        System.out.println("Здравствуйте");
        boolean menuIsRun=true;
        while(menuIsRun){
            System.out.println("Что Вы хотите сделать?");
            System.out.println("1 - работа со студентами");
            System.out.println("2 - работа с группой");
            selectInt = scanner.nextInt();
            switch (selectInt){
                case 1:{
                    break;
                }
                case 2:{
                    groupView.run();
                    break;
                }
            }
        }
    }
}
