package Client;

import java.io.IOException;

/**
 * Created by artur_v on 04.12.16.
 */
public class ClientMainClass {
    public static void main(String[] args) throws IOException, InterruptedException {
        Client client = new Client();
        client.t.sleep(1000);
        Client client1 = new Client();
       // client.t.join();
        System.out.println("Клиент завершил работу");
    }
}
