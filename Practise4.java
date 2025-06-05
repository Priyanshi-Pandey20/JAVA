class Buffer {

    boolean hasData = false;

    public synchronized void produce() {
        System.out.println("producer : fetching the signal");
        try {
            Thread.sleep(2000);
            hasData = true;
            System.out.println("produced : giving out signal ");
            notify();
        } catch (Exception e) {
        }

    }

    public synchronized void consume() {
        while (!hasData) {
            try {
                System.out.println("consumer: is waiting ... ");
                wait();
            } catch (Exception e) {

            }
            System.out.println(" consumer : got the signal ! Proceeding ");
          
        }
    }
}

class MyThread extends Thread{
     static int balance = 1000;
    int amount;

    MyThread(int amount) {
        this.amount = amount;
    }

    public void run() {
        synchronized (MyThread.class) {
            if (balance >= amount) {

                System.out.println(" is going to withdrawl " + amount);
                try {
                    Thread.sleep(1000);
                    notify();
                } catch (InterruptedException e) {
                }

                balance -= amount;
                System.out.println("Remaining balance " + balance);
            } else {
                System.out.println("sorry not have enough balance to withdraw ");
            }
        }

    }
}

public class Practise4 {
    public static void main(String[] args) {
        Buffer b = new Buffer();
        Thread d1 = new Thread(() -> {
             b.consume();
          
        });

        Thread d2 = new Thread(() -> {
           
             b.produce();
        });
        d1.start();
        d2.start();

    }
}
