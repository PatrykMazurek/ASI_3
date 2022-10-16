public class App {
    public static void main(String[] args) throws Exception {
//        Client c = new Client("localhost", 5501);
//        c.connection();
//        c.sendMessage();
//        c.disconnect();
        FileClient fc = new FileClient("localhost", 5501, "pliki");
        fc.connect();
        // pobieranie plików z serwera
        fc.getFileFromServer();
        // wysyłanie plików do serwera
        fc.sendFileToServer();
        fc.disconnect();

    }
}
