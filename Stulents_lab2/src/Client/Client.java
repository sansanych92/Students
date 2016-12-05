package Client;

import Client.View.MainView;

/**
 * Created by artur_v on 04.12.16.
 */
public class Client implements Runnable {
    MainView mainView;

    public Client() {
        mainView = new MainView();
    }

    public void run(){
        mainView.beginWork();
    }
}
