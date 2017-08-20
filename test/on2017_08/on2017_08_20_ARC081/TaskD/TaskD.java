package on2017_08.on2017_08_20_ARC081.TaskD;



import net.ogiekako.algorithm.io.MyPrintWriter;
import net.ogiekako.algorithm.io.MyScanner;
import net.ogiekako.algorithm.misc.MaxRectangle;

public class TaskD {
    public void solve(int testNumber, MyScanner in, MyPrintWriter out) {
        int h = in.nextInt(), w = in.nextInt();
        char[][] map = new char[h][w];
        for (int i = 0; i < h; i++) {
            map[i] = in.next().toCharArray();
        }
        boolean[][] grid = new boolean[h - 1][w - 1];
        for (int i = 0; i < h - 1; i++) {
            for (int j = 0; j < w - 1; j++) {
                grid[i][j] = (map[i][j] != map[i][j + 1]) == (map[i + 1][j] != map[i + 1][j + 1]);
            }
        }
        int res = Math.max(h, w);
        int[] rect = MaxRectangle.maximalRectangles(grid);
        for (int i = 1; i < rect.length; i++) {
            res = Math.max(res, (i + 1) * (rect[i] + 1));
        }
        out.println(res);
    }
}
