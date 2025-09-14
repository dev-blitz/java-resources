package abhinab.revision.java.multi_threading.producer_consumer;

import java.util.*;

public class ProducerConsumerDemo {
  public static void main(String[] args) {
    ProducerConsumer obj = new ProducerConsumer(5);
    Thread producer = new Thread(() -> {
      try {
        obj.produce();
      } catch (Exception exp) {
        System.out.println(exp.getClass().getName() + " was triggered\n\tmessage: " + exp.getMessage());
      }
    }, "producer-thread");
    
    Thread consumer = new Thread (new Runnable() {
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
  }
}

class ProducerConsumer {
  private final List<Integer> resource; //shared-resource
  private final Object LOCK;
  private final int limit;
  private int counter = 0;
  private int run;

  ProducerConsumer(int limit) {
    LOCK = new Object();
    resource = new ArrayList<Integer>();
    this.limit = limit;
    run = 0;
    System.out.println("starting...");
  }

  public void produce() throws InterruptedException {
    synchronized(LOCK) {
      while (run < 6) {
        if (resource.size() < limit) {
          System.out.println("\tproduced: [" + (++counter) + ']');
          resource.add(counter);
        } else {
          System.out.println("resource-full\n\thanding over to consumer");
        }
          Thread.sleep(100);
      }
    }
  }

  public void consume() throws InterruptedException {
    synchronized(LOCK) {
      while (run < 6) {
        if (!resource.isEmpty()) {
          System.out.println("\tconsumed: [" + resource.remove(0) + ']');
        } else {
          System.out.println("resource-full\n\thanding over to producer");
        }
          Thread.sleep(100);
      }
    }
  }
}

