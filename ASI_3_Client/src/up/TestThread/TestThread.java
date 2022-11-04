package up.TestThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestThread {

    public void startRunnamble(int maxThread){
        ExecutorService service = Executors.newCachedThreadPool();
        ThreadPoolExecutor thredPool = (ThreadPoolExecutor) service;
        int numberTask = 0;
        while (numberTask < 2000){
            if (thredPool.getActiveCount() < maxThread){
                service.submit(new TestRunnable(numberTask));
                numberTask++;
            }
        }
        service.shutdown();
    }

    public void startRunnambleFixed(int maxThread){
        ExecutorService service = Executors.newFixedThreadPool(maxThread);
        for (int i = 0; i< 2000; i++){
            service.submit(new TestRunnable( i ));
        }
        service.shutdown();
    }

}
