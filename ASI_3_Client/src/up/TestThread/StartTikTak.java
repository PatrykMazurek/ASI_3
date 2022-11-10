package up.TestThread;

public class StartTikTak implements Runnable{

    Thread th;
    TikTak tikTakObj;

    public StartTikTak(String name, TikTak ttObj){
        th = new Thread(this, name);
        tikTakObj = ttObj;
        th.start();
    }

    @Override
    public void run() {
        if (th.getName().equals("Tik")){
            for (int i=0; i < 10; i++){
                tikTakObj.tik(true);
            }
            tikTakObj.tik(false);
        }else{
            for (int i=0; i < 10; i++){
                tikTakObj.tak(true);
            }
            tikTakObj.tak(false);
        }
    }
}
