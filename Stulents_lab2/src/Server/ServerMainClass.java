package Server;

import Server.Exceptions.GroupNotFoundException;
import Server.Exceptions.IdAlreadyExsistsException;


import java.io.IOException;

/**
 * Created by artur_v on 04.12.16.
 */
public class ServerMainClass {
    public static void main(String [] args) throws GroupNotFoundException, IOException, IdAlreadyExsistsException {

        Server server = new Server();

        System.out.println("Сервер запущен");
    }
}
