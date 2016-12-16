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

    private Root root;

    public GroupController(Root root) throws IdAlreadyExsistsException {
      this.root = root;
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    public List<GroupModel> getArrayListOfModels() {
        return root.getGroupModelList();
    }

    public GroupModel getGroupById(int idOfGroup) throws IdNotFoundException {
        GroupModel groupModel = new GroupModel();

        checkGroupIdForMissError(idOfGroup);

        for (GroupModel groupModel1 : root.getGroupModelList()) {

            if (groupModel1.getIdOfGroup() == idOfGroup) {
                groupModel = groupModel1;
            }
        }

        return groupModel;
    }

    public void addGroup(GroupModel group) throws IdAlreadyExsistsException {
        checkGroupIdForPresenceError(group.getIdOfGroup());
        root.getGroupModelList().add(group);
    }

    public void deleteGroup(int groupId) throws IdNotFoundException {
        GroupModel deletedGroup = getGroupById(groupId);
        root.getGroupModelList().remove(deletedGroup);
    }

    public void setGroup(int groupId, GroupModel group) throws IdAlreadyExsistsException, IdNotFoundException {

        checkGroupIdForMissError(groupId);
        GroupModel oldGroup = getGroupById(group.getIdOfGroup());
        root.getGroupModelList().set(root.getGroupModelList().indexOf(oldGroup), group);
    }

    public void checkGroupIdForMissError(int idOfGroup) throws IdNotFoundException {

        boolean exsistanceFlag = false;
        for (GroupModel groupModel : root.getGroupModelList()) {
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
        for (GroupModel groupModel : root.getGroupModelList()) {
            if (idOfGroup == groupModel.getIdOfGroup()) {
                exsistanceFlag = true;
            }
        }

        if (exsistanceFlag) {
            throw new IdAlreadyExsistsException("Ошибка! Группа с id " + idOfGroup + " уже существует.");
        }
    }

    public void saveData() {

        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("src/main/java/com/netcracker/lr1/GroupsDataFile.txt"))) {
            for (int i = 0; i < root.getGroupModelList().size(); i++) {

                writer.writeObject(root.getGroupModelList().get(i));
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void loadData() {
/*
        arrayListOfModels = new ArrayList();
        Object groupModel;

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("src/main/java/com/netcracker/lr1/GroupsDataFile.txt"))) {
            boolean flag=true;
            while (flag){
                groupModel = reader.readObject();
                if (groupModel==null){
                    flag = false;
                }

                arrayListOfModels.add((GroupModel) groupModel);
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<GroupModel> searchGroupById(String id) {

        id = id.replaceAll("[*]", ".*");
        id = id.replace('?', '.');
        List<GroupModel> findedGroups = new ArrayList<>();
        Pattern regex = Pattern.compile(id);

        for (GroupModel group : arrayListOfModels) {
            Matcher m = regex.matcher(String.valueOf(group.getIdOfGroup()));
            if (m.matches()) {
                findedGroups.add(group);
            }
        }
        return findedGroups;*/
    }

    public List<GroupModel> searchGroupByNumber(String number) {

        number = number.replaceAll("[*]", ".*");
        number = number.replace('?', '.');
        List<GroupModel> findedGroups = new ArrayList<>();
        Pattern regex = Pattern.compile(number);

        for (GroupModel group : root.getGroupModelList()) {
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

        for (GroupModel group : root.getGroupModelList()) {
            Matcher m = regex.matcher(String.valueOf(group.getNameOfFaculty()));
            if (m.matches()) {
                findedGroups.add(group);
            }
        }
        return findedGroups;
    }

    public void addDataFromAnotherFile(String filePath) throws IOException, ClassNotFoundException, IdAlreadyExsistsException {

        List<GroupModel> newGroupModelsList = new ArrayList();
        String[] groups;

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String s;
            while((s=reader.readLine())!=null){

                GroupModel groupModel = new GroupModel();

                groups = s.split(" ");

                groupModel.setIdOfGroup(Integer.valueOf(groups[0]));
                groupModel.setNumberOfGroup(Integer.valueOf(groups[1]));
                groupModel.setNameOfFaculty(groups[2]);

                try{
                    checkGroupIdForPresenceError(Integer.valueOf(groups[0]));

                    newGroupModelsList.add(groupModel);
                } catch (IdAlreadyExsistsException e){
                    System.out.println(e.getMessage());
                }

            }

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        for (GroupModel aNewGroup : newGroupModelsList) {

            boolean coincidenceFlag = false;

            for (GroupModel aGroup : root.getGroupModelList()) {
                if (aGroup.equals(aNewGroup)) {
                    coincidenceFlag = true;
                }
            }

            if (!coincidenceFlag) {
                root.getGroupModelList().add(aNewGroup);
            }
        }
    }
}
