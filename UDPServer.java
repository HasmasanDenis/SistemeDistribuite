import java.net.*;
import java.util.Random;

public class UDPServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket(9876); // Portul pe care serverul ascultă
            byte[] receiveData = new byte[1024];

            System.out.println("Serverul UDP este pornit...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String request = new String(receivePacket.getData(), 0, receivePacket.getLength());
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                System.out.println("Server a primit un pachet de la " + clientAddress + ":" + clientPort + " - " + request);

                // Simulăm un timp de răspuns variabil
                Random random = new Random();
                int responseTime = random.nextInt(100) + 1;
                Thread.sleep(responseTime);

                // Răspunde la client
                String response = "Raspuns la cerere: " + request;
                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
