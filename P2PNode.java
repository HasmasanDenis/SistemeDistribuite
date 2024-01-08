public class P2PNode {
    private int port;

    public P2PNode() {
        // Inițializează portul și alte setări
        this.port = 3036;
    }

    public void start() {
        // Inițializează serverul pentru a asculta conexiuni
        P2PServer server = new P2PServer(port);
        server.start();

        // Inițializează clientul pentru a trimite și primi mesaje
        P2PClient client = new P2PClient();
        client.connect("localhost", port);

        // Implementează logica P2P specifică aplicației tale
        // ...

        // Oprește resursele atunci când este necesar
        server.close();
        client.disconnect();
    }
}
