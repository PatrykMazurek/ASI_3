package up;

import up.TestThread.TestRunnable;
import up.TestThread.TestThread;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static int[] tableInt;
    public static List<File> fileList;
    public static void main(String[] args) throws Exception {
        tableInt = new int[2000];
        fileList = new ArrayList<>();
        for(int i =0; i< 2000; i++){
            tableInt[i] = -1;
        }

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
        Thread threadFile = new Thread(new Runnable() {
            @Override
            public void run() {
                File[] fils = Paths.get("pliki").toFile().listFiles();
                fileList = Arrays.stream(fils).collect(Collectors.toList());
                for (int i = 0; i< 15; i++){
                    fils = Paths.get("pliki").toFile().listFiles();
                    if (fils.length != fileList.size()){
                        System.out.println("Zmieniła się liczba plików");
                    }
                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread th =new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i < 20; i++){
                    System.out.println("Wartość " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
//        th.start();
//        th.join();
        TestThread tsR = new TestThread();
        tsR.startRunnamble(10);
        System.out.println("Zakończenie wątka main");
    }
}
