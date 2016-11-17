import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SendMessage extends Thread {
    private Socket socket;
    private String message;

    public SendMessage(Socket socket, String message) {
        this.socket = socket;
        this.message = message;
    }

    public void run(){
        try {
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("Sending a message to the server");
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(message);
            printWriter.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
