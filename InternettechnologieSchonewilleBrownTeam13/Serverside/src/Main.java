import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    private final static int SERVER_PORT = 3000;
    private ArrayList<Socket> sockets = new ArrayList<>();

    public static void main(String[] args) {
        try {
            new Main().clientAfhandeling();
        } catch (IOException io){
            System.err.print(io.getMessage());
        }
    }

    public void clientAfhandeling() throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

        while (true){
            System.out.println("Server online and waiting for clients");
            Socket socket = serverSocket.accept();
            sockets.add(socket);

            System.out.println("Setting up client connection");

            ClientThread clientThread = new ClientThread(socket, this);
            clientThread.start();
        }
    }

    public void broadcastAll(String message) throws IOException {
        System.out.println("Sending message to all sockets");
//        for(Socket s: sockets){
//            OutputStream outputStream = s.getOutputStream();
//            PrintWriter printWriter = new PrintWriter(outputStream);
//            printWriter.println(message);
//            printWriter.flush();
//            outputStream.close();
//        }
    }
}
