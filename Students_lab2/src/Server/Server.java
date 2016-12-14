package Server;

import Server.Controller.StudentController;
import Server.Exceptions.*;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by artur_v on 04.12.16.
 */
public class Server implements Runnable{

   private BufferedReader in;
   private PrintWriter out;
   private Thread t;
   private Socket client;

   public Server(Socket client) throws IOException, NoSuchFieldException, GroupNotFoundException, IdAlreadyExsistsException {

       StudentController controller = new StudentController();
       this.client = client;
       t = new Thread(this);
       in = new BufferedReader(new InputStreamReader(client.getInputStream()));
       out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
       t.start();
    }

    @Override
    public void run() {

    }
}
