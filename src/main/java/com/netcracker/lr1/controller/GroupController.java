package com.netcracker.lr1.controller;

import com.netcracker.lr1.Exceptions.IdAlreadyExsistsException;
import com.netcracker.lr1.Exceptions.IdNotFoundException;
import com.netcracker.lr1.model.GroupModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artur_v on 07.11.16.
 */
public class GroupController {
    private ArrayList<GroupModel> arrayListOfModels;

    public GroupController() throws IdAlreadyExsistsException {
        arrayListOfModels = new ArrayList();
        String[] group;
        int i = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader("home/artur_v/Artur/Programming/Work/NetCracker/Courses/Java/LabaK1/Students_2/src/main/java/com/netcracker/lr1/storageOfGroups.txt")))
        {
            String s="";
            for(int j=0; j<10; j++){
            //while((s=reader.readLine())!=null){
                s=reader.readLine();
                if (s.charAt(0)==
                if (i>1)
                    break;
                GroupModel groupModel = new GroupModel();

                group = s.split(" ");

                checkGroupIdForPresenceError(Integer.valueOf(group[0].split(" ")[0]));

                groupModel.setIdOfGroup(Integer.valueOf(group[0]));
                groupModel.setNumberOfGroup(Integer.valueOf(group[1]));
                groupModel.setNameOfFaculty(group[2]);

                arrayListOfModels.add(groupModel);
                i++;
            }

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<GroupModel> getArrayListOfModels() {
        return arrayListOfModels;
    }

    public void setArrayListOfModels(ArrayList<GroupModel> arrayListOfModels) {
        this.arrayListOfModels = arrayListOfModels;
    }

    public GroupModel getGroupById(int idOfGroup) throws IdNotFoundException {
        GroupModel groupModel = new GroupModel();

        checkGroupIdForMissError(idOfGroup);

        for (GroupModel groupModel1 : arrayListOfModels) {

            if (groupModel1.getIdOfGroup() == idOfGroup) {
                groupModel = groupModel1;
            }
        }

        return groupModel;
    }

    private GroupModel createGroupFromString(String groupString) throws IdAlreadyExsistsException {
        GroupModel groupModel = new GroupModel();
        String[] groupData = groupString.split(" ");
        int idOfGroup = Integer.parseInt(groupData[0]);

        checkGroupIdForPresenceError(idOfGroup);
        groupModel.setIdOfGroup(idOfGroup);
        groupModel.setNumberOfGroup(Integer.parseInt(groupData[1]));
        groupModel.setNameOfFaculty(groupData[2]);

        return groupModel;
    }

    public void addGroup(String groupString) throws IdAlreadyExsistsException {
        arrayListOfModels.add(createGroupFromString(groupString));
    }

    public void deleteGroup(int groupId) throws IdNotFoundException {
        GroupModel deletedGroup = getGroupById(groupId);
        arrayListOfModels.remove(deletedGroup);
    }

    public void editGroup(int groupId, String groupGtring) throws IdAlreadyExsistsException, IdNotFoundException {
        checkGroupIdForMissError(groupId);
        int index = arrayListOfModels.indexOf(getGroupById(groupId));
        arrayListOfModels.remove(getGroupById(groupId));
        GroupModel groupModel = createGroupFromString(groupGtring);
        arrayListOfModels.set(index, groupModel);
    }

    public void editGroupId(int groupId, int newGroupId) throws IdAlreadyExsistsException, IdNotFoundException {
        GroupModel groupModel = getGroupById(groupId);
        checkGroupIdForPresenceError(newGroupId);
        groupModel.setIdOfGroup(newGroupId);
    }

    public void editGroupNumber(int groupId, int newNumber) throws IdNotFoundException {
        GroupModel groupModel = getGroupById(groupId);
        groupModel.setNumberOfGroup(newNumber);
    }

    public void editGroupNameOfFaculty(int groupId, String nameOfFaculty) throws IdNotFoundException {
        GroupModel groupModel = getGroupById(groupId);
        groupModel.setNameOfFaculty(nameOfFaculty);
    }

    public void checkGroupIdForMissError(int idOfGroup) throws IdNotFoundException {

        boolean exsistanceFlag = false;
        for (GroupModel groupModel : arrayListOfModels) {
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
        for (GroupModel groupModel : arrayListOfModels) {
            if (idOfGroup == groupModel.getIdOfGroup()) {
                exsistanceFlag = true;
            }
        }

        if (exsistanceFlag) {
            throw new IdAlreadyExsistsException("Ошибка! Группа с id " + idOfGroup + " уже существует.");
        }
    }

    public void saveData() {

        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("src\\main\\java\\com\\netcracker\\lr1\\GroupDataFile.txt"))) {
            for (int i = 0; i < arrayListOfModels.size(); i++) {

                writer.writeObject(arrayListOfModels.get(i));
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void loadData() {

        arrayListOfModels = new ArrayList();

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("lab1\\src\\main\\java\\com\\netcracker\\lr1\\GroupDataFile.txt"))) {
            for (int i = 0; i < arrayListOfModels.size(); i++) {

                GroupModel newModel;
                newModel = (GroupModel) reader.readObject();
                arrayListOfModels.add(newModel);
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addDataFromAnotherFile(String filePath) throws IOException, ClassNotFoundException {

        List<GroupModel> newGroupModelList = new ArrayList();


        ObjectInputStream reader = new ObjectInputStream( new FileInputStream(filePath));

        for (int i = 0; i <arrayListOfModels.size(); i++) {

            GroupModel newModel;
            newModel = (GroupModel) reader.readObject();
            newGroupModelList.add(newModel);
        }

        for (GroupModel aNewGroup : newGroupModelList) {

            boolean coincidenceFlag = false;

            for (GroupModel aGroup : arrayListOfModels) {
                if (aGroup.equals(aNewGroup)) {
                    coincidenceFlag = true;
                }
            }

            if (!coincidenceFlag) {
                arrayListOfModels.add(aNewGroup);
            }
        }
    }
}
