package up.TestThread;

public class TikTak {

    public synchronized void tik(boolean work){
        if(!work){
            notify();
            return;
        }
        System.out.println("Wyświetlam Tik");
        notify();
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void tak(boolean work){
        if(!work){
            notify();
            return;
        }
        System.out.println("Wyświetlam Tak");
        notify();
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
