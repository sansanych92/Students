package com.netcracker.lr1.model;


import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by Арсений on 03.11.2016.
 */
public class StudentModel implements Serializable {

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

    @Override
    public String toString() {
        int month = dateOfEnrollment.get(Calendar.MONTH)+1;
        return "id=" + id + '\n' +
                "surname=" + surname + '\n' +
                "name=" + name + '\n' +
                "patronymic=" + patronymic + '\n' +
                "groupId=" + groupId + '\n' +
                "dateOfEnvironment=" + dateOfEnrollment.get(Calendar.YEAR)+"."
                +month+"."
                +dateOfEnrollment.get(Calendar.DAY_OF_MONTH)+ '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentModel that = (StudentModel) o;

        if (id != that.id) return false;
        if (groupId != that.groupId) return false;
        if (!surname.equals(that.surname)) return false;
        if (!name.equals(that.name)) return false;
        if (!patronymic.equals(that.patronymic)) return false;
        return dateOfEnrollment.equals(that.dateOfEnrollment);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + surname.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + patronymic.hashCode();
        result = 31 * result + groupId;
        result = 31 * result + dateOfEnrollment.hashCode();
        return result;
    }
}
