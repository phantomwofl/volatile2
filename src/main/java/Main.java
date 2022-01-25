import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        LongAdder stat = new LongAdder();

        Future<Integer> shop1 = executorService.submit(thread1);
        Future<Integer> shop2 = executorService.submit(thread2);
        Future<Integer> shop3 = executorService.submit(thread3);

        int profit1 = shop1.get();
        int profit2 = shop2.get();
        int profit3 = shop3.get();

        stat.add(profit1);
        stat.add(profit2);
        stat.add(profit3);

        System.out.println("\nРезультат: " + stat.sum());
        executorService.shutdown();
    }
}
