package abhinab.revision.java.multi_threading.producer_consumer;

import java.util.*;

public class ProducerConsumerDemo {
  public static void main(String[] args) {
    ProducerConsumer obj = new ProducerConsumer(5, 4);
    Thread producer = new Thread(() -> {
      try {
        obj.produce();
      } catch (Exception exp) {
        System.out.println(exp.getClass().getName() + " was triggered\n\tmessage: " + exp.getMessage());
      }
    }, "producer-thread");

    Thread consumer = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          obj.consume();
        } catch (Exception exp) {
          System.out.println(exp.getClass().getName() + " was triggered\n\tmessage: " + exp.getMessage());
        }
      }
    }, "consumer-thread");

    producer.start();
    consumer.start();

    while (true) {
      if (!producer.isAlive() && !consumer.isAlive()) {
        System.out.println("==============");
        System.out.println("demo-completed");
        System.out.println("==============\n");
        break;
      }
    }
  }
}

class ProducerConsumer {
  private final List<Integer> resource; // shared-resource
  private final Object LOCK; // KEY                          
  private final int limit; // max size of the shared-resource
  private int counter; // counting the numbers
  private int runCounter; // how many times it was run
  private final int runLimit; // how many times it can run

  ProducerConsumer(int limit, int runLimit) {
    LOCK = new Object();
    resource = new ArrayList<Integer>();
    this.limit = limit;
    this.runLimit = runLimit;
    counter = 0;
    runCounter = 0;
    System.out.println("\n=====================");
    System.out.println("initializing-the-demo");
    System.out.println("=====================\n");
    try {
      Thread.sleep(1000);
    } catch (Exception e) {
      System.out.println(e.getClass().getName() + " was triggered\n\tmessage: " + e.getMessage());
    }
  }

  public void produce() throws InterruptedException {
    synchronized (LOCK) {
      while (runCounter < runLimit) {
        if (resource.size() < limit) {
          System.out.println("\tproduced: [" + (++counter) + ']');
          resource.add(counter);
          LOCK.notify();
        } else {
          System.out.println("resource-full\n\thanding over to consumer");
          runCounter += 1;
          if (runCounter == runLimit) {
            LOCK.notify();
            break;
          }
          LOCK.wait();
        }
        Thread.sleep(300);
      }
    }
  }

  public void consume() throws InterruptedException {
    synchronized (LOCK) {
      while (runCounter < runLimit) {
        if (!resource.isEmpty()) {
          System.out.println("\tconsumed: [" + resource.remove(0) + ']');
          LOCK.notify();
        } else {
          System.out.println("resource-empty\n\thanding over to producer");
          runCounter += 1;
          if (runCounter == runLimit) {
            LOCK.notify();
            break;
          }
          LOCK.wait();
        }
        Thread.sleep(300);
      }
    }
  }
}
