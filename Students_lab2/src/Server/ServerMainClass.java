package Server;

import Server.Exceptions.GroupNotFoundException;
import Server.Exceptions.IdAlreadyExsistsException;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by artur_v on 04.12.16.
 */
public class ServerMainClass {
    public static void main(String [] args) throws IOException, ParserConfigurationException, SAXException, JAXBException {

        System.out.println("Server Started");
        try (ServerSocket s = new ServerSocket(8080)) {
            while (true) {
                // Блокируется до возникновения нового соединения:
                Socket socket = s.accept();
                try {
                    new Server(socket);
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
