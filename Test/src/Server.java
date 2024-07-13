import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class Server {

    public static final Map<String,Socket> socketList = new HashMap<>();
    public static void main(String[] args) {
        final int PORT = 8082;

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);
                socketList.put(clientSocket.getInetAddress().getHostAddress(),clientSocket);

                // Start a new thread to handle client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;
    private Socket recieverSocket;
    private PrintWriter out1;
    private BufferedReader in1;
    private PrintWriter out2;
    private BufferedReader in2;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            out1 = new PrintWriter(clientSocket.getOutputStream(), true);
            in1 = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String ip;
            do {
                ip = in1.readLine();
                System.out.println("ip recieved: " + ip);
                synchronized (Server.socketList){
                    recieverSocket = Server.socketList.get(ip);
                }
                if (recieverSocket.isConnected())
                    out1.println("Connected to " + ip);
            } while(recieverSocket==null && ip==null);

            out2 = new PrintWriter(recieverSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in1.readLine()) != null) {
                out2.println(inputLine);
            }

            in1.close();
            out1.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}