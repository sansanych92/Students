package Server.Model;

import java.io.Serializable;

/**
 * Модель группы
 *
 * @author Артур Воеков (основная группа 3).
 */
public class GroupModel implements Serializable {
    private int idOfGroup;
    private int numberOfGroup;
    private String nameOfFaculty;

    public GroupModel() {

    }

    ;

    public GroupModel(int numberOfModels, int groupN, String facultyN) {
        this.numberOfGroup = groupN;
        this.nameOfFaculty = facultyN;
        idOfGroup = numberOfModels;
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

    public String toString() {
        return this.idOfGroup + " " + numberOfGroup + " " + nameOfFaculty;
    }

    public boolean equals(Object o) {
        if (o instanceof GroupModel) {
            if ((((GroupModel) o).getIdOfGroup() == this.idOfGroup) &&
                    (((GroupModel) o).getNumberOfGroup() == this.numberOfGroup) &&
                    (((GroupModel) o).getNameOfFaculty() == this.nameOfFaculty)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int result = this.idOfGroup;
        result *= 31;
        result += this.numberOfGroup;
        result *= 31;
        result += this.nameOfFaculty.hashCode();
        return result;
    }
}