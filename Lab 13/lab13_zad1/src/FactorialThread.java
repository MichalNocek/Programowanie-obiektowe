public class FactorialThread extends Thread {
    private int n;
    private long factorial;

    public FactorialThread(int n) {
        this.n = n;
        this.factorial = 1;
    }

    @Override
    public void run() {
        System.out.println("FactorialThread: Rozpoczęto obliczanie silni dla N=" + n);
        if (n < 0) {
            System.out.println("FactorialThread: Silnia nie jest zdefiniowana dla liczb ujemnych.");
            this.factorial = 0;
        } else if (n == 0) {
            this.factorial = 1;
        } else {
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
        }
        System.out.println("FactorialThread: Zakończono obliczanie silni. Silnia = " + factorial);
    }

    public long getFactorial() {
        return factorial;
    }
}