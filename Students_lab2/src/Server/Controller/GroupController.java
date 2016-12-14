package Server.Controller;

import Server.Exceptions.*;
import Server.Model.GroupModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by artur_v on 04.12.16.
 */
public class GroupController {

    private ArrayList<GroupModel> arrayListOfModels;

    public GroupController() throws IdAlreadyExsistsException {
        arrayListOfModels = new ArrayList();
        String[] group;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/netcracker/lr1/storageOfGroups.txt"))) {
            String s = "";
            while ((s = reader.readLine()) != null) {
                if (s.charAt(0) == 65279) {
                    s = s.substring(1);
                }
                GroupModel groupModel = new GroupModel();

                group = s.split(" ");

                checkGroupIdForPresenceError(Integer.valueOf(group[0]));

                groupModel.setIdOfGroup(Integer.valueOf(group[0]));
                groupModel.setNumberOfGroup(Integer.valueOf(group[1]));
                groupModel.setNameOfFaculty(group[2]);

                arrayListOfModels.add(groupModel);
            }

        } catch (IOException ex) {

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

        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("src/main/java/com/netcracker/lr1/GroupsDataFile.txt"))) {
            for (int i = 0; i < arrayListOfModels.size(); i++) {

                writer.writeObject(arrayListOfModels.get(i));
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void loadData() {

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
        return findedGroups;
    }

    public List<GroupModel> searchGroupByNumber(String number) {

        number = number.replaceAll("[*]", ".*");
        number = number.replace('?', '.');
        List<GroupModel> findedGroups = new ArrayList<>();
        Pattern regex = Pattern.compile(number);

        for (GroupModel group : arrayListOfModels) {
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

        for (GroupModel group : arrayListOfModels) {
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
