import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(2222);
        System.out.println("Server started");
        int clientCnt = 0;

        while(true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client " + ++clientCnt);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            clientSocket.getOutputStream()));

            String request = reader.readLine();
            Thread.sleep(200);
            System.out.println("Request: " + request);

            String response = "I don't understand, I'm just stupid machine";
            writer.write(response);
            writer.newLine();
            writer.flush();

            reader.close();
            writer.close();
            clientSocket.close();
        }
    }
}