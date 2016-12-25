package Client;

import Client.ui.frames.ExceptionFrame;
import Client.ui.frames.MainFrame;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 *@author artur_v
 */
public class Client implements Runnable {
    private MainFrame mainFrame;
    private File clientFile;
    private BufferedWriter outClientFile;
    private DataInputStream in;
    private DataOutputStream out;
    Thread t;

    public Client() throws IOException {
        clientFile = new File("Client.xml");
        Socket client = new Socket(InetAddress.getLocalHost(),8080);
        in = new DataInputStream(client.getInputStream());
        out = new DataOutputStream(client.getOutputStream());
        t = new Thread(this);
        t.start();
    }

    public void run(){

            while (true) {
                try {
                    String s = in.readUTF();
                    outClientFile = new BufferedWriter(new FileWriter(clientFile));
                    outClientFile.write(s);
                    outClientFile.flush();
                    xmlParser();
                } catch (ParserConfigurationException | IOException | SAXException e) {
                    e.printStackTrace();
                }
            }
    }

    private synchronized void xmlParser() throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(clientFile);
        Node node = document.getDocumentElement();

        switch (node.getNodeName()){
            case "root":{
                try {
                    JAXBContext context = JAXBContext.newInstance(Root.class);
                    Unmarshaller unmarshaller = context.createUnmarshaller();
                    Root root = (Root) unmarshaller.unmarshal(clientFile);
                    outClientFile.close();
                    if (MainFrame.getCountOfFrames() > 0) {
                        mainFrame.setVisible(false);
                    }
                    mainFrame = new MainFrame(root, out);
                    mainFrame.setVisible(true);

                } catch (JAXBException | IOException ex) {
                    ex.printStackTrace();
                }
                break;
            }

            case "exception":{
                new ExceptionFrame(node.getTextContent());
                break;
            }

            case "findedStudents":{
                break;
            }
            case "findedGroups":{
                break;
            }
        }

        outClientFile.close();
    }
}
