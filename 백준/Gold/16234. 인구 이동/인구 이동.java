import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, l, r;
    static int[][] map;
    static int[][] area;
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
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        area = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int moveCount = 0;
        while (existArea()) {
            movePerson();
            area = new int[n][n];
            moveCount++;
        }

        bw.write(String.valueOf(moveCount));
        bw.flush();
        bw.close();
        br.close();
    }

    static void movePerson() {
        boolean isMove;
        int areaNum = 1;
        do {
            isMove = false;

            int sum = 0;
            int areaCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (area[i][j] == areaNum) {
                        sum += map[i][j];
                        isMove = true;
                        areaCount++;
                    }
                }
            }

            if (isMove) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (area[i][j] == areaNum) {
                            map[i][j] = Math.floorDiv(sum, areaCount);
                        }
                    }
                }
                areaNum++;
            }

        } while (isMove);
    }

    static boolean existArea() {
        boolean[][] visit = new boolean[n][n];
        int areaNum = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j]) {
                    continue;
                }

                if (fillArea(i, j, visit, areaNum)) {
                    areaNum++;
                }
            }
        }
        return areaNum != 1;
    }

    static boolean fillArea(int row, int col, boolean[][] visit, int areaNum) {
        boolean isFilled = false;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row, col));

        while (!q.isEmpty()) {
            Point p = q.poll();
            visit[p.r][p.c] = true;

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dir[i].r;
                int nc = p.c + dir[i].c;

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                    continue;
                }

                if (visit[nr][nc]) {
                    continue;
                }

                int diff = Math.abs(map[p.r][p.c] - map[nr][nc]);
                if (diff >= l && diff <= r) {
                    area[p.r][p.c] = areaNum;
                    area[nr][nc] = areaNum;
                    q.add(new Point(nr, nc));
                    visit[nr][nc] = true;
                    isFilled = true;
                }
            }
        }

        return isFilled;
    }
}
