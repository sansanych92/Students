package Server;

import Server.Controller.GroupController;
import Server.Controller.StudentController;
import Server.Exceptions.*;
import Server.Model.GroupModel;
import Server.Model.Root;
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
import java.util.Objects;

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
   public File storage;
   String resp;
    Root root;

   public Server(Socket client) throws IOException, NoSuchFieldException, GroupNotFoundException, IdAlreadyExsistsException, ParserConfigurationException, SAXException, JAXBException {

       this.client = client;
       storage = new File("C:\\Users\\Arsenii\\Desktop\\Students\\Students_lab2\\src\\Server\\Storage.xml");
       out = new DataOutputStream(client.getOutputStream());
       in = new DataInputStream(client.getInputStream());
       serverFile = new File("Server.xml");
       studentController = new StudentController();
       groupController = new GroupController(studentController.getGropList());
       t = new Thread(this);
       root = new Root();
       root.setStudentModelList(studentController.getStudentList());
       root.setGroupModelList(studentController.getGropList());
       JAXBContext context = JAXBContext.newInstance(Root.class);
       Marshaller marshaller = context.createMarshaller();
       marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
       marshaller.marshal( root, storage);
       t.start();
    }


    @Override
    public void run() {
        try {
            String req = "";
            resp = "";
            String s = "";
            while (true) {
                outServerWriter = new BufferedWriter(new FileWriter(serverFile));
                inFile = new BufferedReader(new FileReader(storage));
                while ((s = inFile.readLine()) != null) {
                    s = s.trim();
                    resp = resp.concat(s);
                }
                out.writeUTF(resp);
                out.flush();
                req = in.readUTF();
                outServerWriter.write(req);
                outServerWriter.flush();
               try {
                   serverHandler();
               }
               catch (NumberFormatException e){
                   writeExceptionInFile("Input data error");
               }
                writeXmlInFile();

            }
        } catch (IOException | SAXException | ParserConfigurationException | JAXBException e) {
            e.printStackTrace();
        }
        finally {
            try {
                client.close();
            }
            catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }

    }

    private void serverHandler() throws ParserConfigurationException, IOException, SAXException {

        // Создается построитель документа
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        // Создается дерево DOM документа из файла
        Document document = documentBuilder.parse(serverFile);
        Node root = document.getDocumentElement();
       switch (root.getNodeName()){
           case "addGroup":{
               NodeList groupData = root.getChildNodes();
               int grId = 0;
               for (GroupModel model:groupController.getArrayListOfModels()) {
                   if (grId<model.getIdOfGroup()){
                       grId = model.getIdOfGroup();
                   }
               }
               GroupModel newGroup = new GroupModel(++grId, Integer.parseInt(groupData.item(0).getTextContent()), groupData.item(1).getTextContent());
               try {
                   groupController.addGroup(newGroup);
               } catch (IdAlreadyExsistsException e) {
                   e.printStackTrace();
               }
           }
           case "deleteGroup":{}
           case "addStudent":{
               NodeList studData = root.getChildNodes();
               for (int i = 0; i <studData.getLength(); i++) {
                   System.out.println(studData.item(i).getTextContent());
               }
           }
           case "deleteStudent":{}
           case "editGroup":{}
           case "editStudent":{}
           case "searchStudByName":{}
           case "searchStudBySurname":{}
           case "searchStudByPatronymic":{}
           case "searchStudByNumberOfGroup":{}
           case "searchStudByDateOfEnvironment":{}
           case "searchGroupByNumber":{}
           case "searchGroupByFaculty":{}
       }

    }

    public void writeXmlInFile() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Root.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal( root, storage);
        resp = "";
    }

    public void writeExceptionInFile(String e) throws IOException {
       out.writeUTF("<exception>"+e+"</exception>");
    }
}
