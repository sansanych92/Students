package com.netcracker.lr1.view;;

import com.netcracker.lr1.controller.GroupController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by artur_v on 07.11.16.
 */
public class GroupView {
    private BufferedReader bufferedReader;
    private GroupController groupController;

    public GroupView() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        groupController = new GroupController();
    }

    public void run() throws IOException {
        System.out.println("Выберете действие");
        System.out.println("1 - вывод списка групп");
        String select = bufferedReader.readLine();
        int s = Integer.parseInt(select);

        switch (s) {
            case 1: {
                groupController.showArrayList();
                break;
            }
        }
    }
}
