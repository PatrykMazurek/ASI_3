package up.TestThread;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class TestThread {

    private List<File> fileList;
    private int taskNumber;
    private int threadNumber;
    public TestThread(int tsNumber, int thNumber){
        taskNumber = tsNumber;
        threadNumber = thNumber;
    }

    public void startThread(){
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
        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startRunnamble(){
        ExecutorService service = Executors.newCachedThreadPool();
        ThreadPoolExecutor thredPool = (ThreadPoolExecutor) service;
        int numberTask = 0;
        while (numberTask < 200){
            if (thredPool.getActiveCount() < threadNumber){
                service.submit(new TestRunnable(numberTask));
                numberTask++;
            }
        }
        service.shutdown();
    }

    public void startRunnambleFixed(int maxThread){
        ExecutorService service = Executors.newFixedThreadPool(maxThread);
        for (int i = 0; i< taskNumber; i++){
            service.submit(new TestRunnable( i ));
        }
        service.shutdown();
    }

    public void statCallble(int maxThread){
        ExecutorService service = Executors.newFixedThreadPool(threadNumber);
        List<Future<String>> futureList = new ArrayList<>();
        // do uzupełnienia
        BlockingDeque<Future<String>> futureDeque = new LinkedBlockingDeque<>();
        System.out.println("Dodawanie elementów do wykonaia");
        for (int i = 0; i< taskNumber; i++){
            TestCallable tc = new TestCallable(i);
            futureList.add(service.submit(tc));
        }
        System.out.println("obdieranie wyników ");
        for (int i = 0; i< taskNumber; i++){
            Future<String> f = futureList.get(i);
            try {
                String message = f.get(2, TimeUnit.SECONDS);
                System.out.println(message);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }

    public void listingForFile(){
        fileList = new ArrayList<>();
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
        threadFile.start();
    }
}
