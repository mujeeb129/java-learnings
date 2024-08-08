package org.example;

class A extends Thread{
    public void run(){
        System.out.println("thread");
    }
}

public class ThreadsExample {
    public static void main(String[] args) {
        A obj = new A();
        obj.start();
    }
}
