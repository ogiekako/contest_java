package on2017_07.on2017_07_29_ARC079.TaskF;



import net.ogiekako.algorithm.graph.Edge;
import net.ogiekako.algorithm.graph.Graph;
import net.ogiekako.algorithm.graph.algorithm.SCC;
import net.ogiekako.algorithm.io.MyScanner;
import net.ogiekako.algorithm.io.MyPrintWriter;
import net.ogiekako.algorithm.utils.Pair;

import java.util.Arrays;
import java.util.BitSet;

public class TaskF {
    public void solve(int testNumber, MyScanner in, MyPrintWriter out) {
        int N = in.nextInt();
        Graph graph = new Graph(N);
        for (int i = 0; i < N; i++) {
            int p = in.nextInt() - 1;
            graph.add(p, i);
        }
        int cycle = -1;
        Pair<int[], int[][]> comp = SCC.sccWithComponents(graph);
        for (int i = 0; i < comp.second.length; i++) {
            if (comp.second[i].length > 1) {
                if (cycle >= 0) throw new RuntimeException();
                cycle = i;
            }
        }
        int[] grundy = new int[N];
        Arrays.fill(grundy, -1);
        for (int i = 0; i < N; i++) {
            if (comp.first[i] != cycle) {
                recur(grundy, graph, i);
            }
        }
        for (int i = 0; i < N; i++) {
            if (comp.first[i] == cycle) {
                BitSet b = new BitSet();
                int nxt = -1;
                for (Edge e : graph.edges(i)) {
                    if (grundy[e.to()] != -1) {
                        b.set(grundy[e.to()]);
                    } else {
                        if (nxt >= 0) throw new RuntimeException();
                        nxt = e.to();
                    }
                }
                int[] tmp = grundy.clone();
                int g = b.nextClearBit(0);
                tmp[i] = g;
                recur(tmp, graph, nxt);
                if (tmp[nxt] != g) {
                    out.println("POSSIBLE");
                    return;
                }

                tmp = grundy.clone();
                b.set(g);
                tmp[i] = b.nextClearBit(0);
                recur(tmp, graph, nxt);
                if (tmp[nxt] == g) {
                    out.println("POSSIBLE");
                    return;
                }
                out.println("IMPOSSIBLE");
                return;
            }
        }
    }

    private void recur(int[] grundy, Graph graph, int i) {
        BitSet b = new BitSet();
        for (Edge e : graph.edges(i)) {
            if (grundy[e.to()] == -1) recur(grundy, graph, e.to());
            b.set(grundy[e.to()]);
        }
        grundy[i] = b.nextClearBit(0);
    }
}
