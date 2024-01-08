import java.io.IOException;
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
                // Procesează conexiunea primită într-un alt fir de execuție sau într-un mod concurent
            }
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
