import server.UDPServer;

public class App {

    public static void main(String[] args) throws Exception {
//        Server s = new Server(5501);
//        s.serverConnection();

        UDPServer server = new UDPServer();
        server.getConncetion();

//        FileServer fs = new FileServer(5501, "pliki_server");
//        fs.clientConnection();
//        // pobieranie plików od klienta
//        fs.getFileFromClient();
//        // przesyłanie plików do klienta
//        fs.sendFileToClient();
//        fs.cloesSocket();
    }
}
