import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class P2PClient {
    private Socket socket;
    private PrintWriter writer;

    public void connect(String host, int port) {
        try {
            socket = new Socket(host, port);
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metode pentru a trimite și primi mesaje
}
