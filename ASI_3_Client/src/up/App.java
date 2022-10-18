package up;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws Exception {
//        up.Client c = new up.Client("localhost", 5501);
//        c.connection();
//        c.sendMessage();
//        c.disconnect();
//        up.FileClient fc = new up.FileClient("localhost", 5501, "pliki");
//        fc.connect();
//        // pobieranie plików z serwera
//        fc.getFileFromServer();
//        // wysyłanie plików do serwera
//        fc.sendFileToServer();
//        fc.disconnect();
        PackageZip pz = new PackageZip();
        File[] files = Paths.get("pliki").toFile().listFiles();
//        pz.packingArchive(files, "Archiwum.zip");
        pz.unpackingArchive(Path.of("pliki_out"), "Archiwum.zip");
    }
}
