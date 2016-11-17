import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;
    private Main main;

    public ClientThread(Socket socket, Main main) {
        this.socket = socket;
        this.main = main;
    }

    public void run(){
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();

            System.out.println("Message received: " + line);

            main.broadcastAll(line);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
