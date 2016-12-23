package Server;

import Server.Controller.GroupController;
import Server.Controller.StudentController;
import Server.Exceptions.GroupNotFoundException;
import Server.Exceptions.IdAlreadyExsistsException;
import Server.Model.Root;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by artur_v on 04.12.16.
 */
public class ServerMainClass {
    public static void main(String [] args) throws IOException, ParserConfigurationException, SAXException, JAXBException, GroupNotFoundException, IdAlreadyExsistsException {
        StudentController studentController = new StudentController();
        GroupController groupController = new GroupController(studentController.getGropList());
        File storage = new File("Students_lab2\\src\\Server\\Storage.xml");
        Root root = new Root();
        root.setGroupModelList(groupController.getArrayListOfModels());
        root.setStudentModelList(studentController.getStudentList());
        System.out.println("Server Started");
        try (ServerSocket s = new ServerSocket(8080)) {
            while (true) {
                Socket socket = s.accept();
                try {
                    new Server(socket, storage, studentController, groupController, root);
                } catch (IOException e) {
                    // Если завершится неудачей, закрывается сокет,
                    // в противном случае, нить закроет его:
                    s.close();
                } catch (IdAlreadyExsistsException | GroupNotFoundException | NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
