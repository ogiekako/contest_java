package on2017_07.on2017_07_29_ARC079.TaskD;



import net.ogiekako.algorithm.io.MyScanner;
import net.ogiekako.algorithm.io.MyPrintWriter;

public class TaskD {
    public void solve(int testNumber, MyScanner in, MyPrintWriter out) {
        long K = in.nextLong();
        long N = 50;
        out.println(N);
        for (int i = 0; i < N; i++) {
            long r = N - 1 - i + K / N + (K % N > i ? 1 : 0);
            out.println(r);
        }
    }
}
