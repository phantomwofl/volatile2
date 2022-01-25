import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable <Integer> {

    final int SIZE = 10;
    @Override
    public Integer call () {
        Random random = new Random();
        int [] array = new int[SIZE];
        int sum = 0;
        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(100);
            sum += array[i];
        }
        return sum;
    }
}
