import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5065);
        System.out.println("Server started");
        System.out.println("Waiting for a client ...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client accepted");

            //OUTPUT BUFFER and INPUT BUFFER
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            System.out.println("hello");

            //RECEIVING DATA
            try {
                String message = (String) in.readObject();
                System.out.println("Message from client: " + message);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            //SENDING DATA
            out.writeObject("Hello client!");
        }
    }
}
