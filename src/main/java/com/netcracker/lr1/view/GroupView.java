package com.netcracker.lr1.view;

import com.netcracker.lr1.Exceptions.IdAlreadyExsistsException;
import com.netcracker.lr1.Exceptions.IdNotFoundException;
import com.netcracker.lr1.controller.GroupController;
import com.netcracker.lr1.model.GroupModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

;

/**
 * Created by artur_v on 07.11.16.
 */
public class GroupView {
    private BufferedReader in;
    private GroupController groupController;

    public GroupView() throws IdAlreadyExsistsException {
        in = new BufferedReader(new InputStreamReader(System.in));
        groupController = new GroupController();
    }

    public void run() throws IOException {
        System.out.println("Выберете действие");
        System.out.println("1 - вывод списка групп");
        System.out.println("2 - добавление новой группы");
        System.out.println("3 - поиск группы");
        String select = in.readLine();
        int s = Integer.parseInt(select);

        switch (s) {
            case 1: {
                //groupController.showArrayList();
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                //groupController.search();
            }
        }
    }

    public void printAddNewGroupMenu() throws IOException, IdAlreadyExsistsException {
        System.out.println("Введите данные группы (id, номер, название факультета) через пробел.");
        String groupString = in.readLine();
        groupController.addGroup(groupString);
        System.out.println("Данные добавлены.");
    }

    public void printFullEditOfGroupMenu() throws IOException, IdNotFoundException, IdAlreadyExsistsException {
        System.out.println("Введите id группы, данные о которой хотите отредактировать.");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Введите данные группы (id, номер, название факультета) через пробел.");
        String groupData = in.readLine();
        groupController.editGroup(id, groupData);
        System.out.println("Группа отредактирована.");
    }

    public void printEditOfIdMenu() throws IOException, IdNotFoundException, IdAlreadyExsistsException {
        System.out.println("Введите id группы, id которой хотите отредактировать.");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Введите новый id группы.");
        int newId = Integer.parseInt(in.readLine());
        groupController.editGroupId(id, newId);
        System.out.println("id группы отредактирован.");
    }

    public void printEditOfNumberMenu() throws IOException, IdNotFoundException {
        System.out.println("Введите id группы, номер которой хотите отредактировать.");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Введите новый номер группы.");
        int newNumber = Integer.parseInt(in.readLine());
        groupController.editGroupNumber(id, newNumber);
        System.out.println("Номер группы отредактирован.");
    }

    public void printEditOfFacultyNameMenu() throws IOException, IdNotFoundException {
        System.out.println("Введите id группы, факультет которой хотите отредактировать.");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Введите новое имя факультета группы.");
        String newName = in.readLine();
        groupController.editGroupNameOfFaculty(id, newName);
        System.out.println("Имя факультета отредактировано.");
    }

    public void prindSaveDataMenu() {
        groupController.saveData();
        System.out.println("Данные сохранены.");
    }

    public void prindLoadDataMenu() throws IOException {
        groupController.loadData();
        System.out.println("Данные загружены.");
    }

    public void printListOfGroups() {
        for (GroupModel group : groupController.getArrayListOfModels()) {
            System.out.println(group.toString());
        }
    }
}
