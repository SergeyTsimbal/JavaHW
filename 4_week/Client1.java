import java.io.*;
import java.net.Socket;

public class Client1 implements Runnable {

    private static Socket clientSocket = null;
    private static PrintStream os;
    private static DataInputStream is = null;
    private static BufferedReader inputLine = null;
    private static boolean closed = false;

    public static void main(String[] args) {
        int portNumber = 60000;
        String host = "127.0.0.1";

        try {
            clientSocket = new Socket(host, portNumber);
            inputLine = new BufferedReader(new InputStreamReader(System.in));
            os = new PrintStream(clientSocket.getOutputStream());
            is = new DataInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            System.err.println("Error to connection " + host);
        }


        if (clientSocket != null && os != null && is != null) {
            try {

                new Thread(new Client1()).start();
                while (!closed) {
                    os.println(inputLine.readLine().trim());
                }
                os.close();
                is.close();
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
            }
        }
    }

    public void run() {
        String line;
        try {
            while ((line = is.readLine()) != null) {
                System.out.println(line);
            }
            closed = true;
        } catch (IOException e) {
            System.err.println("IOException:  " + e);
        }
    }
}