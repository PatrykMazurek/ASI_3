public class App {
    public static void main(String[] args) throws Exception {
        Client c = new Client("localhost", 5501);
        c.connection();
        c.sendMessage();
        c.disconnect();
    }
}
