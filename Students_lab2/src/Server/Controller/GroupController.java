package Server.Controller;

import Server.Exceptions.*;
import Server.Model.GroupModel;
import Server.Model.Root;
import Server.Model.StudentModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by artur_v on 04.12.16.
 */
public class GroupController {

    private List<GroupModel> groupList;

    public GroupController(List<GroupModel> groupList) throws IdAlreadyExsistsException {
      this.groupList = groupList;
    }


    public List<GroupModel> getArrayListOfModels() {
        return groupList;
    }

    public GroupModel getGroupById(int idOfGroup) throws IdNotFoundException {
        GroupModel groupModel = new GroupModel();

        checkGroupIdForMissError(idOfGroup);

        for (GroupModel groupModel1 : groupList) {

            if (groupModel1.getIdOfGroup() == idOfGroup) {
                groupModel = groupModel1;
            }
        }

        return groupModel;
    }

    public void addGroup(GroupModel group) throws IdAlreadyExsistsException {
        checkGroupIdForPresenceError(group.getIdOfGroup());
        groupList.add(group);
    }

    public void deleteGroup(int groupId) throws IdNotFoundException {
        GroupModel deletedGroup = getGroupById(groupId);
        groupList.remove(deletedGroup);
    }

    public void setGroup(int groupId, GroupModel group) throws IdAlreadyExsistsException, IdNotFoundException {

        checkGroupIdForMissError(groupId);
        GroupModel oldGroup = getGroupById(group.getIdOfGroup());
        groupList.set(groupList.indexOf(oldGroup), group);
    }

    public void checkGroupIdForMissError(int idOfGroup) throws IdNotFoundException {

        boolean exsistanceFlag = false;
        for (GroupModel groupModel : groupList) {
            if (idOfGroup == groupModel.getIdOfGroup()) {
                exsistanceFlag = true;
            }
        }

        if (!exsistanceFlag) {
            throw new IdNotFoundException("Ошибка! Группа с id " + idOfGroup + " отсутствует.");
        }
    }

    public void checkGroupIdForPresenceError(int idOfGroup) throws IdAlreadyExsistsException {
        boolean exsistanceFlag = false;
        for (GroupModel groupModel : groupList) {
            if (idOfGroup == groupModel.getIdOfGroup()) {
                exsistanceFlag = true;
            }
        }

        if (exsistanceFlag) {
            throw new IdAlreadyExsistsException("Ошибка! Группа с id " + idOfGroup + " уже существует.");
        }
    }

    public List<GroupModel> searchGroupByNumber(String number) {

        number = number.replaceAll("[*]", ".*");
        number = number.replace('?', '.');
        List<GroupModel> findedGroups = new ArrayList<>();
        Pattern regex = Pattern.compile(number);

        for (GroupModel group : groupList) {
            Matcher m = regex.matcher(String.valueOf(group.getNumberOfGroup()));
            if (m.matches()) {
                findedGroups.add(group);
            }
        }
        return findedGroups;
    }

    public List<GroupModel> searchGroupByNameOfFaculty(String nameOfFaculty) {

        nameOfFaculty = nameOfFaculty.replaceAll("[*]", ".*");
        nameOfFaculty = nameOfFaculty.replace('?', '.');
        List<GroupModel> findedGroups = new ArrayList<>();
        Pattern regex = Pattern.compile(nameOfFaculty);

        for (GroupModel group : groupList) {
            Matcher m = regex.matcher(String.valueOf(group.getNameOfFaculty()));
            if (m.matches()) {
                findedGroups.add(group);
            }
        }
        return findedGroups;
    }

}
