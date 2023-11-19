import java.net.*;
import java.util.Date;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("192.168.37.112"); // Adresa IP a serverului
            int serverPort = 9876; // Portul serverului

            // Dimensiunile pachetelor
            int[] packetSizes = {128, 512, 1024};

            for (int size : packetSizes) {
                String requestData = "Cerere de dimensiune " + size + " bytes";
                byte[] sendData = requestData.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

                Date startTime = new Date();
                socket.send(sendPacket);

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                Date endTime = new Date();
                long responseTime = endTime.getTime() - startTime.getTime();

                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Raspuns de la server: " + response);
                System.out.println("Timpul de raspuns: " + responseTime + " ms");
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
