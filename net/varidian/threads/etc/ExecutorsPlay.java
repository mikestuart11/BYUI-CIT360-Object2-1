package net.varidian.threads.etc;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorsPlay {

    public static void main(String[] args) {


        Executor executor1 = Executors.newCachedThreadPool();
        for (int threadCnt = 0; threadCnt < 3; threadCnt++) {
            RunnablesPlay runnable2 = new RunnablesPlay();
            executor1.execute(runnable2);
        }

        try {
            Thread.sleep(5000);
            System.out.println("Done Sleeping");
            for (int threadCnt = 0; threadCnt < 3; threadCnt++){
                RunnablesPlay runnable3 = new RunnablesPlay();
                executor1.execute(runnable3);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
