import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int[] dir_r = {-1, 0, 1, 0};
    static int[] dir_c = {0, -1, 0, 1};

    public static class Axis implements Comparable<Axis> {
        int r;
        int c;
        int t;

        public Axis(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }

        @Override
        public int compareTo(Axis o) {
            if (this.r < o.r) {
                return -1;
            } else if (o.r == this.r && this.c < o.c) {
                return -1;
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] visit = new boolean[N][N];

        Axis babyShark = null;
        int eat = 0;
        int sharkSize = 2;
        int answer = 0;

        for (int i = 0; i < N; ++i) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    babyShark = new Axis(i, j, 0);
                }
            }
        }

        Queue<Axis> q = new LinkedList<>();
        Queue<Axis> eatQ = new PriorityQueue<>();
        q.add(babyShark);

        while (true) {
            int eatDistance = 9999;
            while (!q.isEmpty()) {
                Axis curr = q.poll();
                visit[curr.r][curr.c] = true;

                if (curr.t > eatDistance) {
                    break;
                }

                for (int i = 0; i < 4; ++i) {
                    int new_r = curr.r + dir_r[i];
                    int new_c = curr.c + dir_c[i];

                    if (!(new_r >= 0 && new_r < N && new_c >= 0 && new_c < N)) {
                        continue;
                    }

                    if (map[new_r][new_c] <= sharkSize && !visit[new_r][new_c]) {
                        if (map[new_r][new_c] != 0 && map[new_r][new_c] < sharkSize
                                && curr.t + 1 <= eatDistance) {
                            eatDistance = curr.t + 1;
                            eatQ.add(new Axis(new_r, new_c, curr.t + 1));
                        }
                        visit[new_r][new_c] = true;
                        q.add(new Axis(new_r, new_c, curr.t + 1));
                    }
                }
            }

            if (eatQ.isEmpty()) {
                break;
            }

            Axis toEat = eatQ.poll();

            q.clear();
            eatQ.clear();

            map[toEat.r][toEat.c] = 0;
            answer = toEat.t;
            q.add(new Axis(toEat.r, toEat.c, toEat.t));
            visit = new boolean[N][N];

            if (++eat == sharkSize) {
                ++sharkSize;
                eat = 0;
            }
        }

        bw.write(Integer.toString(answer));
        bw.close();
    }
}