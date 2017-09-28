import com.sun.istack.internal.NotNull;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductConsumer {



    public static void main(String[] args){
        BlockingQueue<Data> dataBlockingQueue = new LinkedBlockingQueue<Data>();
        new Thread(new Productor(dataBlockingQueue)).start();
        new Thread(new Comsumer(dataBlockingQueue)).start();
    }

}


class Productor implements Runnable{

    BlockingQueue<Data> taskQueue;

    public Productor(@NotNull BlockingQueue<Data> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (true) {
            Data data = new Data();
            taskQueue.add(data);
            System.out.println("向队列里添加苹果"+data.getId());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Comsumer implements Runnable{

    private BlockingQueue<Data> taskQueue;
    public Comsumer(BlockingQueue<Data> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Data data = taskQueue.take();
                System.out.println("从队列中拿到苹果"+data.getId());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Data {
    private static  int i =0;
    int id;
    String name = "apple";

    public Data() {
        id = i++;
    }

    public String getId() {
        return "" + id;
    }


}
