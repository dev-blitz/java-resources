package blitz.revision.java_resources.multi_threading.producer_consumer;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerDemo {

  private static class Sandbox {
    //shared-resource
    private final List<Integer> container;
    private final Object LOCK;
    private final int limit;
    private int counter;
    private int turn;

    protected Sandbox(int limit) {
      container = new ArrayList<>();
      LOCK = new Object();
      this.limit = limit;
      counter = 0;
    }

    public void produce() {
      synchronized(LOCK) {
        while (turn <= 4) {
          if (container.size() < limit) {
            LOCK.notify();
            System.out.println("produced: " + (++counter));
            container.add(counter);
            try {
              Thread.sleep(500);
            } catch(InterruptedException exc) {
              System.out.println("interrupted-exception: " + exc.getMessage());
            } catch(Exception exc) {
              System.out.println("exception: " + exc.getClass().getName() + "\nmessage: " + exc.getMessage());
            }
          } else {
            System.out.println("container-full:\t\tcall the consumer");
            turn++;
            System.out.println("turns: " + turn);
            try {
              LOCK.wait();
              Thread.sleep(500);
            } catch(InterruptedException exc) {
              System.out.println("interrupted-exception: " + exc.getMessage());
            } catch(Exception exc) {
              System.out.println("exception: " + exc.getClass().getName() + "\nmessage: " + exc.getMessage());
            }
          }
        }
      }
    }

    public void consume() {
      synchronized(LOCK) {
        while (turn < 4) {
          if (!container.isEmpty()) {
            LOCK.notify();
            System.out.println("consumed: " + container.removeFirst());
            try {
              Thread.sleep(500);
            } catch(InterruptedException exc) {
              System.out.println("interrupted-exception: " + exc.getMessage());
            } catch(Exception exc) {
              System.out.println("exception: " + exc.getClass().getName() + "\nmessage: " + exc.getMessage());
            }
          } else {
            System.out.println("container-empty:\tcall producer");
            turn++;
            System.out.println("turns: " + turn);
            try {
              Thread.sleep(500);
              LOCK.wait();
            } catch(InterruptedException exc) {
              System.out.println("interrupted-exception: " + exc.getMessage());
            } catch(Exception exc) {
              System.out.println("exception: " + exc.getClass().getName() + "\nmessage: " + exc.getMessage());
            }
          }
        }
      }
    }
  }

  public static void main(String[] args) {

    Sandbox sandbox = new Sandbox(5);
    Thread producer = new Thread(new Runnable() {
      @Override
      public void run() {
        sandbox.produce();
      }
    }, "producer-thread");

    Thread consumer = new Thread(() -> {
      sandbox.consume();
    }, "consumer-thread");
    producer.start();
    consumer.start();

    new Thread(() -> {
      producer.setDaemon(true);
      consumer.setDaemon(true);
    }, "killer-thread").setDaemon(true);
  }
}
