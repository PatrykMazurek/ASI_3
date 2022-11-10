package up.TestThread;

import java.util.Random;
import java.util.concurrent.Callable;

public class TestCallable implements Callable<String> {
    private int task;
    public TestCallable(int t){ task = t; }

    @Override
    public String call() throws Exception {
        Random rand = new Random();
        int number = rand.nextInt(300);
        String message = "Zadanie " + task + " wartość = " + number;
        Thread.sleep(rand.nextInt(3000));
        return message;
    }
}
