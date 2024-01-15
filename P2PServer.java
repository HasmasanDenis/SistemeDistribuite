import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class P2PServer extends Thread {
    private int port;
    private ServerSocket serverSocket;

    public P2PServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {

            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                    System.out.println("Am ajuns aici" + port);
                // Crează un fir de execuție separat pentru a trata conexiunea
                Thread clientThread = new Thread(() -> handleConnection(socket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleConnection(Socket socket) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Așteaptă și citește mesajul de la client
            String clientMessage = reader.readLine();
            System.out.println("Mesaj primit de la client: " + clientMessage);

            // Trimite un răspuns către client
            writer.println("Mesaj primit cu succes!");

            // Închide resursele
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
