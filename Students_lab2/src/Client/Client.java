package Client;

import Client.ui.frames.MainFrame;
import Client.Root;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by artur_v on 04.12.16.
 */
public class Client implements Runnable {
    MainFrame mainFrame;
    File clientFile;
    private BufferedWriter outClientFile;
    private DataInputStream in;
    private DataOutputStream out;
    Root root;
    Thread t;

    public Client() throws IOException {
        Socket client = new Socket(InetAddress.getLocalHost(),8080);
        in = new DataInputStream(client.getInputStream());
        out = new DataOutputStream(client.getOutputStream());
        t = new Thread(this);
        t.start();
    }

    public void run(){
        try {
            String s = "";
            while (true) {
                outClientFile = new BufferedWriter(new FileWriter(clientFile = new File("Client.xml")));
                s = in.readUTF();
                outClientFile.write(s);
                outClientFile.flush();
                DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document document = documentBuilder.parse("Client.xml");
                Node node = document.getDocumentElement();
                if (Objects.equals(node.getNodeName(), "root")) {
                    xmlParser();
                }
                else{
                    JOptionPane.showMessageDialog(mainFrame,node.getTextContent());
                }
                if (MainFrame.countOfFrames > 0) {
                    mainFrame.setVisible(false);
                }
                mainFrame = new MainFrame(root, out);
                mainFrame.setVisible(true);
            }

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    public void xmlParser(){
        try {
            JAXBContext context = JAXBContext.newInstance(Root.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            this.root = (Root) unmarshaller.unmarshal(clientFile);
            outClientFile.close();


        } catch (JAXBException ex) {
            Logger.getLogger(Root.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
