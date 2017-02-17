import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;


public class Server {

    private static ServerSocket serverSocket = null;
    private static Socket clientSocket = null;
    private static final int maxClients = 10;
    private static final clientT[] threads = new clientT[maxClients];

    public static void main(String args[]) {

        int portNumber = 60000;
        if (args.length < 1) {
            System.out.println("Waiting for a client...");
        } else {
            portNumber = Integer.valueOf(args[0]).intValue();
        }

        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.out.println(e);
        }


        while (true) {
            try {
                clientSocket = serverSocket.accept();
                int i;
                for (i = 0; i < maxClients; i++) {
                    if (threads[i] == null) {
                        (threads[i] = new clientT(clientSocket, threads)).start();
                        break;
                    }
                }
                if (i == maxClients) {
                    PrintStream os = new PrintStream(clientSocket.getOutputStream());
                    os.println("Server is full!");
                    os.close();
                    clientSocket.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}

class clientT extends Thread {

    private DataInputStream is = null;
    private PrintStream os = null;
    private Socket clientSocket = null;
    private final clientT[] threads;
    private int maxClients;

    public clientT(Socket clientSocket, clientT[] threads) {
        this.clientSocket = clientSocket;
        this.threads = threads;
        maxClients = threads.length;
    }

    public void run() {
        int maxClients = this.maxClients;
        clientT[] threads = this.threads;
        System.out.println("Added client!");
        try {
            is = new DataInputStream(clientSocket.getInputStream());
            os =  new PrintStream(clientSocket.getOutputStream());
            os.println("Enter your name");
            String name = is.readLine().trim();
            os.println("Enter \"/exit\" to exit");
            while (true) {
                String line = is.readLine();
                if (line.equals("/exit")) {
                    System.out.println(name + " exit chat ");
                    break;
                }
                for (int i = 0; i < maxClients; i++) {
                    if (threads[i] != null) {
                        threads[i].os.println(name + ": " + line);
                    }
                }
            }
            for (int i = 0; i < maxClients; i++) {
                if (threads[i] != null && threads[i] != this) {
                    threads[i].os.println("The user is leaving the chat!");
                }
            }
            for (int i = 0; i < maxClients; i++) {
                if (threads[i] == this) {
                    threads[i] = null;
                }
            }

            is.close();
            os.close();
            clientSocket.close();
        } catch (IOException e) {
        }
    }
}
