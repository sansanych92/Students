package Client;

/**
 * Created by artur_v on 04.12.16.
 */
public class ClientMainClass {
    public static void main(String[] args){
        Client client = new Client();
        Thread clientThread = new Thread(client);
        clientThread.start();
        try{
            clientThread.join();
        } catch (InterruptedException e) {
            System.out.println("Поток прерван");
        }
        System.out.println("Клиент завершил работу");
    }
}
