package on2017_08.on2017_08_20_ARC081.TaskA;



import net.ogiekako.algorithm.io.MyScanner;
import net.ogiekako.algorithm.io.MyPrintWriter;

import java.util.Arrays;
import java.util.HashSet;

public class TaskA {
    public void solve(int testNumber, MyScanner in, MyPrintWriter out) {
        int n = in.nextInt();
        HashSet<Integer> dejavu = new HashSet<>();
        int x=0,y=0;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            if (dejavu.contains(a)) {
                dejavu.remove(a);
                if (y < a) {
                    x = y;
                    y = a;
                } else if (x < a) {
                    x = a;
                }
            } else {
                dejavu.add(a);
            }
        }
        out.println((long) x * y);
    }
}
