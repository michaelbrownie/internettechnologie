import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class OnReceived extends Thread {
    private Socket socket;
    private InputStream inputStream;

    public OnReceived(Socket socket, InputStream inputStream) {
        this.socket = socket;
        this.inputStream = inputStream;
    }

    public void run(){
        try {
            inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();

            System.out.println("Message received: " + line);

            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
