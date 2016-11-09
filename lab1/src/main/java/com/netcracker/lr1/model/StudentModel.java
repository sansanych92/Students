package com.netcracker.lr1.model;


import java.util.Calendar;

/**
 * Created by Арсений on 03.11.2016.
 */
public class StudentModel {



    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private int groupId;
    private Calendar dateOfEnrollment;

    /**
     *
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     *
     * @param patronymic
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     *
     * @return
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     *
     * @param groupId
     */
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    /**
     *
     * @return
     */
    public Calendar getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    /**
     *
     * @param dateOfEnrollment
     */
    public void setDateOfEnrollment(Calendar dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
}
