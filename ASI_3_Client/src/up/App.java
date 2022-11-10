package up;

import up.TestThread.StartTikTak;
import up.TestThread.TestRunnable;
import up.TestThread.TestThread;
import up.TestThread.TikTak;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static int[] tableInt;
    public static List<Integer> numberList;

    public static void main(String[] args) throws Exception {
//        tableInt = new int[2000];
        numberList = new ArrayList<>();
//        for(int i =0; i< 2000; i++){
//            tableInt[i] = -1;
//        }

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
//        PackageZip pz = new PackageZip();
//        File[] files = Paths.get("pliki").toFile().listFiles();
////        pz.packingArchive(files, "Archiwum.zip");
//        pz.unpackingArchive(Path.of("pliki_out"), "Archiwum.zip");

//        TestThread tsR = new TestThread(200, 10);
//        tsR.startRunnambleFixed(10);
//        tsR.statCallble(10);
        TikTak tt = new TikTak();

        StartTikTak t1 = new StartTikTak("Tik", tt);
        StartTikTak t2 = new StartTikTak("Tak", tt);

        System.out.println("Zakończenie wątka main");


    }
}
