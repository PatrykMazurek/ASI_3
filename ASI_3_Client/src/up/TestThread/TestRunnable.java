package up.TestThread;

import com.sun.tools.javac.Main;
import up.App;

import java.util.Random;

public class TestRunnable implements Runnable {

    private int nrTask;

    public TestRunnable(int task){
        nrTask = task;
    }

    @Override
    public void run() {
        String nameThread = Thread.currentThread().getName();
        System.out.println(nameThread + " " + nrTask);
        int idTh = Integer.parseInt( nameThread.split("-")[3] );
        Random rand = new Random();
        App.tableInt[rand.nextInt(2000)] = idTh;
        try {
            int w = rand.nextInt(1000);
            Thread.sleep(w);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
