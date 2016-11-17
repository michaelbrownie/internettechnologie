import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    Socket socket;

    public static void main(String[] args) {
        new Main().connectToServer();
    }

    public void connectToServer(){
        try {
          //  socket = new Socket(InetAddress.getLocalHost(), 3000);

            while (true){
                socket = new Socket(InetAddress.getLocalHost(), 3000);
                System.out.println("Send message to server:");
                Scanner sc = new Scanner(System.in);
                String message = sc.next();

                SendMessage sendMessage = new SendMessage(socket, message);
                sendMessage.start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
