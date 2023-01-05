import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5065);
        System.out.println("Connected to server");
        System.out.println("Remote port: " + socket.getPort());
        System.out.println("Local port: " + socket.getLocalPort());

        //OUTPUT BUFFER and INPUT BUFFER
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        //SENDING DATA
        out.writeObject("Hello server!");

        //RECEIVING DATA
        try {
            String message = (String) in.readObject();
            System.out.println("Message from server: " + message);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
