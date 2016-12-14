package Server;

import Server.Exceptions.GroupNotFoundException;
import Server.Exceptions.IdAlreadyExsistsException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by artur_v on 04.12.16.
 */
public class ServerMainClass {
    public static void main(String [] args) throws IOException {

        try (ServerSocket server = new ServerSocket(8080)) {
            while (true) {

                Socket socket = server.accept();
                try {
                    new Server(socket);
                } catch (IOException e) {

                    socket.close();
                } catch (NoSuchFieldException | GroupNotFoundException | IdAlreadyExsistsException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
