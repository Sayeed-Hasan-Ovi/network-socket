import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer {
    static final int PORT = 5065;

    public static String readFileData(File file, int length) {
        return null;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client accepted");

            //create a new thread for each client
            new Thread(new ClientHandler(socket)).start();
        }
    }
}
