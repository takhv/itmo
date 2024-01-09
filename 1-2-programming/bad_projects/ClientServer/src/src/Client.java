import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 2222);
        System.out.println("You've been accepted");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        client.getInputStream()));
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        client.getOutputStream()));

        Scanner in = new Scanner(System.in);
        writer.write("hui");
        writer.newLine();
        writer.flush();

        String answer = reader.readLine();
        System.out.println(answer);

        reader.close();
        writer.close();
        client.close();
    }
}
