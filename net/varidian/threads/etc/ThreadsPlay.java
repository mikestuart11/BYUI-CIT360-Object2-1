package net.varidian.threads.etc;

public class ThreadsPlay extends Thread {
    public void run(){
        for (int i = 0; i < 3; i++){
            System.out.println("Thread ID:" + Thread.currentThread().getName());

            try {
                Thread.currentThread().sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        for (int threadCnt = 0; threadCnt < 3; threadCnt++){
            ThreadsPlay threadsTest = new ThreadsPlay();
            threadsTest.start();
        }
    }
}
