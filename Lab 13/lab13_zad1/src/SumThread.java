public class SumThread extends Thread {
    private int n;
    private long sum;

    public SumThread(int n) {
        this.n = n;
        this.sum = 0;
    }

    @Override
    public void run() {
        System.out.println("SumThread: Rozpoczęto obliczanie sumy dla N=" + n);
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("SumThread: Zakończono obliczanie sumy. Suma = " + sum);
    }

    public long getSum() {
        return sum;
    }
}