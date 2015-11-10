package net.varidian.threads.etc;


public class RunnablesPlayStarter {
    public static void main(String[] args){
        for (int threadCnt = 0; threadCnt < 3; threadCnt++){
            RunnablesPlay runnable1 = new RunnablesPlay();

            Thread thread1 = new Thread(runnable1);
            thread1.start();
        }
    }
}
