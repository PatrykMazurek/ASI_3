package up;

import up.DB.DBConnection;
import up.DB.DBOperation;
import up.TestThread.StartTikTak;
import up.TestThread.TestRunnable;
import up.TestThread.TestThread;
import up.TestThread.TikTak;
import up.server.UDPClient;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Savepoint;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
//        TikTak tt = new TikTak();
//
//        StartTikTak t1 = new StartTikTak("Tik", tt);
//        StartTikTak t2 = new StartTikTak("Tak", tt);

//        DBConnection conn = new DBConnection();
////        Connection c = conn.connectToSqlite();
//        Connection c = conn.connectionToMySql();
////        conn.createTable();
//        DBOperation operation = new DBOperation(c);
//        Savepoint s = conn.getPoint();
//        operation.updatePerson("Jan", "Mazurek");
////        operation.GetPersonProc(3);
//        operation.getAllPersonProc();
//        conn.getRollback(s);
//        System.out.println("powrót do punktu przywracania");
//        operation.getAllPersonProc();
//        conn.disconnect();

//        UDPClient client = new UDPClient();
//
//        Thread t1 = new Thread(new UDPClient());
//        Thread t2 = new Thread(new UDPClient());
//        Thread t3 = new Thread(new UDPClient());
//
//        t1.start();
//        t2.start();
//        t3.start();

        BoardGame bg = new BoardGame();
        List<BoardGame> boardGameList = bg.initListGame();

//        Stream<BoardGame> stream = boardGameList.stream();
//        Map<Integer, List<BoardGame>> tempList = boardGameList.stream()
//                .filter(g -> g.name.contains("g"))
//                .filter(g -> g.minPlayers > 1)
//                .filter(g -> g.price < 50)
//                .collect(Collectors.groupingBy(BoardGame::getYear));

        BoardGame firstBoardGame = boardGameList.stream()
                .filter(g -> g.name.contains("g"))
                .filter(g -> g.minPlayers > 1)
                .max(Comparator.comparing(BoardGame::getRating)).get();


        System.out.println(firstBoardGame);

//        client.getMessage("end");
//        client.close();

        System.out.println("Zakończenie wątka main");
    }
}
