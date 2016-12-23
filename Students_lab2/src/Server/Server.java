package Server;

import Server.Controller.GroupController;
import Server.Controller.StudentController;
import Server.Exceptions.*;
import Server.Model.GroupModel;
import Server.Model.Root;
import Server.Model.StudentModel;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by artur_v on 04.12.16.
 */
public class Server implements Runnable{

   private BufferedReader inFile;
    private DataInputStream in;
    private DataOutputStream out;
    private BufferedWriter outServerWriter;
   private Thread t;
   private Socket client;
   private StudentController studentController;
   private GroupController groupController;
   private File serverFile;
   private File storage;
   private Root root;
   private int countOfItterations = 0;

   public Server(Socket client, File storage, StudentController studentController, GroupController groupController, Root root) throws IOException, NoSuchFieldException, GroupNotFoundException, IdAlreadyExsistsException, ParserConfigurationException, SAXException, JAXBException {

       this.client = client;
       this.storage = storage;
       this.studentController = studentController;
       this.groupController = groupController;
       this.root = root;
       serverFile = new File("Server.xml");
       out = new DataOutputStream(client.getOutputStream());
       in = new DataInputStream(client.getInputStream());
       t = new Thread(this);
       t.start();
    }

    @Override
    public synchronized void run() {
        try {
            while (true) {
                if (countOfItterations==0){
                    rootSender();
                } else{
                    try {
                        serverHandler();
                    } catch (NumberFormatException e) {
                        out.writeUTF("<exception>"+"error with data-"+e.getMessage()+"</exception>");
                        out.flush();
                    } catch (IdAlreadyExsistsException | GroupNotFoundException e) {
                        out.writeUTF("<exception>"+e.getMessage()+"</exception>");
                        out.flush();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        out.writeUTF("<exception>"+"date format error"+"</exception>");
                        out.flush();
                    } catch (NoSuchElementException e){
                        out.writeUTF("<exception>"+"cant find such group"+"</exception>");
                        out.flush();
                    } catch (IdNotFoundException e) {
                        e.printStackTrace();
                    }
                    rootSender();
                }
                countOfItterations++;
            }
        } catch (IOException | ParserConfigurationException | JAXBException | SAXException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            }
            catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }

    }

    private synchronized void serverHandler() throws ParserConfigurationException, IOException, SAXException, JAXBException, IdAlreadyExsistsException, GroupNotFoundException, IdNotFoundException {

        outServerWriter = new BufferedWriter(new FileWriter(serverFile));
        String req = "";
        req = in.readUTF();
        outServerWriter.write(req);
        outServerWriter.flush();
        outServerWriter.close();
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(serverFile);
        Node root = document.getDocumentElement();

        switch (root.getNodeName()) {
            case "addGroup": {
                NodeList groupData = root.getChildNodes();
                int grId = 0;
                for (GroupModel model : groupController.getArrayListOfModels()) {
                    if (grId < model.getIdOfGroup()) {
                        grId = model.getIdOfGroup();
                    }
                }
                GroupModel newGroup = new GroupModel(++grId, Integer.parseInt(groupData.item(0).getTextContent()), groupData.item(1).getTextContent());

                groupController.addGroup(newGroup);
                break;
            }
            case "deleteGroup": {

                groupController.deleteGroup(Integer.valueOf(root.getTextContent()));
                List<StudentModel> studsNeedToDelete = new ArrayList<>();
                    for (StudentModel stud: studentController.getStudentList() ) {
                        if (stud.getGroupId()==Integer.parseInt(root.getTextContent())) {
                           studsNeedToDelete.add(stud);
                        }
                    }

                    if (!studsNeedToDelete.isEmpty()){
                        for (StudentModel stud:studsNeedToDelete) {
                            studentController.deleteStudent(stud.getId());
                        }
                    }
                break;
            }
            case "addStudent": {
                NodeList studData = root.getChildNodes();
                int studId = 0;
                for (StudentModel model : studentController.getStudentList()) {
                    if (studId < model.getId()) {
                        studId = model.getId();
                    }
                }
                String [] date1 = studData.item(4).getTextContent().split("[.]");
                int grId=groupController.getArrayListOfModels().stream().filter(groupModel -> groupModel.getNumberOfGroup()==Integer.parseInt(studData.item(3).getTextContent())).findFirst().get().getIdOfGroup();
                Calendar date = new GregorianCalendar(Integer.parseInt(date1[0]), Integer.parseInt(date1[1])-1, Integer.parseInt(date1[2]));
                StudentModel newStud = new StudentModel(++studId, studData.item(0).getTextContent(), studData.item(1).getTextContent(), studData.item(2).getTextContent(), grId, date);

                studentController.addStudent(newStud);
                break;
            }
            case "deleteStudent": {
                studentController.deleteStudent(Integer.valueOf(root.getTextContent()));
                break;
            }
            case "editGroup": {
            }
            case "editStudent": {
            }
            case "searchStudByName": {
            }
            case "searchStudBySurname": {
            }
            case "searchStudByPatronymic": {
            }
            case "searchStudByNumberOfGroup": {
            }
            case "searchStudByDateOfEnvironment": {
            }
            case "searchGroupByNumber": {
            }
            case "searchGroupByFaculty": {
            }
            case "refresh": {
                System.out.println("kkk");
                break;
            }
        }

        JAXBContext context = JAXBContext.newInstance(Root.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(this.root, storage);

    }

    public synchronized void rootSender() throws IOException {
        String resp = "";
       String s = "";
        outServerWriter = new BufferedWriter(new FileWriter(serverFile));
        inFile = new BufferedReader(new FileReader(storage));
        while ((s = inFile.readLine()) != null) {
            s = s.trim();
            resp = resp.concat(s);
        }
        out.writeUTF(resp);
        out.flush();
        outServerWriter.close();
    }
}
