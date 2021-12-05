package org.academiadecodigo.speedTyper;

public final class Waiter {

    public static void wait(int number){
        try {
            Thread.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
