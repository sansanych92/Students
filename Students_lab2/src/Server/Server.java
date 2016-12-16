package Server;

import Server.Controller.GroupController;
import Server.Controller.StudentController;
import Server.Exceptions.*;
import Server.Model.Root;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by artur_v on 04.12.16.
 */
public class Server implements Runnable{

   private ObjectInputStream in;
   private ObjectOutputStream out;
   private Thread t;
   private Socket client;
   private StudentController studentController;
   private GroupController groupController;
   private Root root;

   public Server(Socket client) throws IOException, NoSuchFieldException, GroupNotFoundException, IdAlreadyExsistsException {

       this.client = client;
       out = new ObjectOutputStream(client.getOutputStream());
       in = new ObjectInputStream(client.getInputStream());
       studentController = new StudentController();
       groupController = new GroupController(studentController.getRoot());
       this.root = studentController.getRoot();
       t = new Thread(this);
       t.start();
    }


    @Override
    public void run() {
        try {
            while (true) {

                out.writeObject(root);
            //    root = (Root) in.readObject();
                serverHandler(root);
            }
        } catch (IOException e) {
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

    private void serverHandler(Root root){
        if (!root.getAddGroup().isEmpty()) {
            try {
                groupController.addGroup(root.getAddGroup().get(0));
            } catch (IdAlreadyExsistsException e) {
                root.getExceptions().add(e);
            }
        }

        if (!root.getAddStudent().isEmpty()){
            try {
                studentController.addStudent(root.getAddStudent().get(0));
            } catch (GroupNotFoundException | IdAlreadyExsistsException e) {
                root.getExceptions().add(e);
            }
        }

        if (!root.getDeleteGroup().isEmpty()){
            try {
                groupController.deleteGroup(root.getDeleteGroup().get(0));
            } catch (IdNotFoundException e) {
                root.getExceptions().add(e);
            }
        }

        if (!root.getDeleteStudent().isEmpty()){
            try {
                studentController.deleteStudent(root.getDeleteStudent().get(0));
            } catch (IdNotFoundException e) {
                root.getExceptions().add(e);
            }
        }

        if (!root.getSetStudent().isEmpty()){
            try {
                studentController.setStudent(root.getSetStudent().get(0));
            }  catch (GroupNotFoundException | IdNotFoundException e) {
                root.getExceptions().add(e);
            }
        }

        if (!root.getSetGroup().isEmpty()){
            try {
                groupController.setGroup(root.getSetGroup().get(0).getIdOfGroup(),root.getSetGroup().get(0));
            }  catch (IdNotFoundException | IdAlreadyExsistsException e) {
                root.getExceptions().add(e);
            }
        }

        if (!root.getSetStudent().isEmpty()){
            try {
                studentController.setStudent(root.getSetStudent().get(0));
            }  catch (IdNotFoundException | GroupNotFoundException e) {
                root.getExceptions().add(e);
            }
        }


    }
}
