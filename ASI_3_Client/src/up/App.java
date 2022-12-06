package up;

import up.DB.DBConnection;
import up.DB.DBOperation;
import up.TestThread.StartTikTak;
import up.TestThread.TestRunnable;
import up.TestThread.TestThread;
import up.TestThread.TikTak;
import up.server.SecretInfo;
import up.server.UDPClient;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Savepoint;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
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
//
//        BoardGame bg = new BoardGame();
//        List<BoardGame> boardGameList = bg.initListGame();
//
        SecretInfo si = new SecretInfo();
        byte[] key = "1234567890qwerty".getBytes();
        byte[] encMsg = si.encryptMessage(key,
                "Dowolna wiadomosć do zaszyfrowania".getBytes(StandardCharsets.UTF_8));

        System.out.println( new String(encMsg));

        String decMsg = si.decryptMessage(key, encMsg);
        System.out.println("odszyfrowana wiadomość " + decMsg);

//        Supplier<Stream<BoardGame>> stream = () -> boardGameList.stream();
//        Map<Integer, List<BoardGame>> tempList = boardGameList.stream()
//                .filter(g -> g.name.contains("g"))
//                .filter(g -> g.minPlayers > 1)
//                .filter(g -> g.price < 50)
//                .collect(Collectors.groupingBy(BoardGame::getYear));
//
//        BoardGame firstBoardGame = boardGameList.stream()
//                .filter(g -> g.name.contains("g"))
//                .filter(g -> g.minPlayers > 1)
//                .max(Comparator.comparing(BoardGame::getRating))
//                .orElse(new BoardGame());
//        System.out.println(firstBoardGame);
//
//        List<BoardGame> boardGamesSorted = boardGameList.stream()
//                .sorted(Comparator.comparing(BoardGame::getYear).reversed())
//                .collect(Collectors.toList());

//        Predicate<BoardGame> find = g -> g.maxPlayers == 4;
//        bg.addYeadToGame(boardGameList, 4);
//        bg.gameListSorted(boardGameList);
//        if (stream.get().anyMatch(find)){
//            System.out.println("Tak");
//        }else {
//            System.out.println("Nie");
//        }
//        if (stream.get().allMatch(find)){
//            System.out.println("Tak");
//        }else {
//            System.out.println("Nie");
//        }

//        client.getMessage("end");
//        client.close();

        System.out.println("Zakończenie wątka main");
    }
}
