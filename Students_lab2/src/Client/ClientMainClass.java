package Client;

import java.io.IOException;

/**
 *@author artur_v
 */
public class ClientMainClass {
    public static void main(String[] args) throws IOException, InterruptedException {
        Client client = new Client();
        Thread.sleep(1000);
        Client client1 = new Client();
        System.out.println("Клиент завершил работу");
    }
}
