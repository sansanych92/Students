package com.netcracker.lr1.controller;

import com.netcracker.lr1.model.GroupModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by artur_v on 07.11.16.
 */
public class GroupController {
    private ArrayList<GroupModel> arrayListOfModels;

    public GroupController() {
        arrayListOfModels = new ArrayList<GroupModel>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/artur_v/Artur/Programming/Work/NetCracker/Courses/Java/LabaK1/Students/Laba1/src/model/storage.txt"));
            for (int i = 0; i < 2; i++) {
                try {
                    arrayListOfModels.add(i, new GroupModel(0, bufferedReader.read(), bufferedReader.readLine()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<GroupModel> getArrayListOfModels() {
        return arrayListOfModels;
    }

    public void setArrayListOfModels(ArrayList<GroupModel> arrayListOfModels) {
        this.arrayListOfModels = arrayListOfModels;
    }

    public void showArrayList() {
        for (int i = 0; i < this.arrayListOfModels.size(); i++) {
            System.out.println(this.arrayListOfModels.get(i).getNumberOfGroup() + " " +
                    this.arrayListOfModels.get(i).getNameOfFaculty());
        }
    }
}
