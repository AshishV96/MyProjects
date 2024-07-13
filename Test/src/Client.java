import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "192.168.68.60"; // Server's IP address
        final int PORT = 8082;

        try {
            Socket socket = new Socket(SERVER_ADDRESS, PORT);
            if (socket.isConnected()) System.out.println("Successfully connected to server.");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter IP to connect to : ");
            String ip;
            while ((ip = stdIn.readLine()) != null) {
                out.println(ip);
                String echo = in.readLine();
                System.out.println("Server : " + echo);
                if(echo.contains("Connected"))
                    break;
            }

            Thread sender = new Thread(() -> {
                try {
                    sendMessage(stdIn,out);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            sender.start();

            Thread reciever = new Thread(() -> {
                try {
                    recieveMessage(in);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            reciever.start();

            Thread.currentThread().wait();
            out.close();
            in.close();
            socket.close();
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + SERVER_ADDRESS);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("I/O error occurred");
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendMessage(BufferedReader stdIn,PrintWriter out) throws IOException {
        String userInput;
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
        }
    }

    public static void recieveMessage(BufferedReader in) throws IOException {
        String userInput;
        while ((userInput = in.readLine()) != null) {
            System.out.println(userInput);
        }
    }
}