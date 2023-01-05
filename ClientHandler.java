import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("ClientHandler started");
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            String request = in.readLine();
            System.out.println("Request: " + request);
            String response = "HTTP/1.1 200 OK";
            out.println(response);
            out.println("Content-Type: text/html");
            out.println();
            out.println("<!Doctype html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <title>My First Angular App</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div ng-app=\"myApp\">\n" +
                    "        <div ng-controller=\"myController\">\n" +
                    "            <h1>{{message}}</h1>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "</html>");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
