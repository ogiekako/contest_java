package on2017_08.on2017_08_20_ARC081.TaskB;



import net.ogiekako.algorithm.io.MyScanner;
import net.ogiekako.algorithm.io.MyPrintWriter;

public class TaskB {
    int MOD = 1000000007;

    public void solve(int testNumber, MyScanner in, MyPrintWriter out) {
        int n = in.nextInt();
        String s1 = in.next();
        String s2 = in.next();
        long res = 1;
        for (int i = 0; i < n; i++) {
            long cur;
            if (s1.charAt(i) == s2.charAt(i)) {
                if (i == 0) {
                    cur = 3;
                } else {
                    if (s1.charAt(i - 1) != s2.charAt(i - 1)) {
                        cur = 1;
                    } else {
                        cur = 2;
                    }
                }
            } else {
                if (i == 0) {
                    cur = 6;
                } else {
                    if (s1.charAt(i - 1) != s2.charAt(i - 1)) {
                        cur = 3;
                    } else {
                        cur = 2;
                    }
                }
                i++;
            }
            res = res * cur % MOD;
        }
        out.println(res);
    }
}
