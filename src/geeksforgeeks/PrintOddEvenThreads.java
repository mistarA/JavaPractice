package geeksforgeeks;

import java.util.Objects;

/**
 * Created by anandmishra on 07/06/17.
 */
public class PrintOddEvenThreads {

    final OddEven lock = new OddEven();

    public static void main(String[] args) {

        PrintOddEvenThreads printOddEvenThreads = new PrintOddEvenThreads();
        Thread threadEven = new Thread(() -> {
            synchronized (printOddEvenThreads.lock) {
                for (int i = 0; i < 19; i = i + 2) {
                    if (printOddEvenThreads.lock.isEven) {
                        System.out.println("Thread1: "+ i);
                        printOddEvenThreads.lock.isEven = false;
                        printOddEvenThreads.lock.notify();
                        try {
                            printOddEvenThreads.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        });
        Thread threadOdd = new Thread(() -> {
            synchronized (printOddEvenThreads.lock) {
                for (int i = 1; i < 18; i = i + 2) {
                    if (!printOddEvenThreads.lock.isEven) {
                        System.out.println("Thread2: " + i);
                        printOddEvenThreads.lock.isEven = true;
                        printOddEvenThreads.lock.notify();
                        try {
                            printOddEvenThreads.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        threadEven.start();
        threadOdd.start();

        try {
            threadEven.join();
            threadOdd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class OddEven {
        public int count = 0;
        public volatile boolean isEven = true;
    }
}
