package org.example;

class Rune implements Runnable{
    public synchronized void run(){
        System.out.println("run");
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        Runnable x = () -> {
            System.out.println("x");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread t1 = new Thread(x);

        t1.start();
    }
}
