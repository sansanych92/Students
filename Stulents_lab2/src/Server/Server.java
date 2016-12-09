package Server;

import Server.Controller.StudentController;
import Server.Exceptions.*;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by artur_v on 04.12.16.
 */
public class Server {

    BufferedReader in;
    ObjectOutputStream out;
    StudentController controller;

    Server() throws IOException, GroupNotFoundException, IdAlreadyExsistsException {

        controller = new StudentController();

        ServerSocket socket = new ServerSocket(8080);

        try {
            Socket client = socket.accept();
            try{
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new ObjectOutputStream(client.getOutputStream());

                out.writeObject(controller.getStudentList());
            }
            finally{
                client.close();
            }
        }
        finally{
            socket.close();
        }
    }
}
