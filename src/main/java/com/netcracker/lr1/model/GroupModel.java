package com.netcracker.lr1.model;

/**
 * Модель группы
 *
 * @author Артур Воеков (основная группа 3).
 */
public class GroupModel {
    private int numberOfGroup;
    private String nameOfFaculty;
    private int idOfGroup;

    public GroupModel(int numberOfModels, int groupN, String facultyN){
        this.numberOfGroup=groupN;
        this.nameOfFaculty=facultyN;
        idOfGroup=numberOfModels;
    }

    public int getIdOfGroup() {
        return idOfGroup;
    }

    public void setIdOfGroup(int ifOfGroup) {
        this.idOfGroup = ifOfGroup;
    }

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public String getNameOfFaculty() {
        return nameOfFaculty;
    }

    public void setNameOfFaculty(String numberOfFaculty) {
        this.nameOfFaculty = numberOfFaculty;
    }
}
