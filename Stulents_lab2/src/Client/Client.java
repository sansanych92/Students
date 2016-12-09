package Client;

import Server.Model.StudentModel;
import Client.View.MainView;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

/**
 * Created by artur_v on 04.12.16.
 */
public class Client implements Runnable {
    MainView mainView;
    ObjectInputStream in;
    PrintWriter  out;
    List<StudentModel> studentModelList;
    Thread t;

    public Client() {

        t = new Thread(this);
        t.start();
    }

    public void run(){
        try {
            Socket client = new Socket(InetAddress.getLocalHost(),8080);


            try{
                in = new ObjectInputStream(client.getInputStream());
                out = new PrintWriter (new OutputStreamWriter(client.getOutputStream()),true);

                studentModelList = (List<StudentModel>) in.readObject();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                client.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        mainView = new MainView(studentModelList);
        mainView.beginWork();
    }
}
