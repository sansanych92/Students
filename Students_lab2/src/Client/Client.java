package Client;

import Server.Model.Root;
import Client.View.MainView;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by artur_v on 04.12.16.
 */
public class Client implements Runnable {
    MainView mainView;
    ObjectInputStream in;
    ObjectOutputStream  out;
    Root root;
    Thread t;

    public Client() throws IOException {

        Socket client = new Socket(InetAddress.getLocalHost(),8080);
        in = new ObjectInputStream(client.getInputStream());
        out = new ObjectOutputStream(client.getOutputStream());
        t = new Thread(this);
        t.start();
    }

    private void clientHandler(Root root){}

    public void run(){
        try {
            while (true){
                root = (Root) in.readObject();
                break;
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        mainView = new MainView(root);
        mainView.beginWork();
    }
}
