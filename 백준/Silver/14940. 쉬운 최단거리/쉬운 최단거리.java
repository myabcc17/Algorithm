import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visit;
    static Point start;
    static Point[] dir = {new Point(1, 0), new Point(-1, 0), new Point(0, 1), new Point(0, -1)};

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];

        visit = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 2) {
                    Point p = new Point(i, j);
                    start = p;
                    q.add(start);
                    visit[i][j] = true;
                }
                map[i][j] = v;
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dir[i].r;
                int nc = p.c + dir[i].c;

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }

                if (visit[nr][nc] || map[nr][nc] == 0) {
                    continue;
                }

                dist[nr][nc] = dist[p.r][p.c] + 1;
                q.add(new Point(nr, nc));
                visit[nr][nc] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == start.r && j == start.c) {
                    bw.write("0");
                } else if (map[i][j] == 1 && dist[i][j] == 0) {
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(dist[i][j]));
                }

                if (j != m - 1) {
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
