import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static Axis[] dirs = {new Axis(0,0,1,1), new Axis(0,0,-1,1), new Axis(0,1,0,1), new Axis(0,-1,0,1), new Axis(1,0,0,1), new Axis(-1,0,0,1)};
    public static class Axis {
        int x;
        int y;
        int z;
        int day;

        public Axis(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }

        public Axis addAxis(Axis axis) {
            return new Axis(this.x + axis.x, this.y + axis.y, this.z + axis.z, this.day + axis.day);
        }

        public boolean inRange(int m, int n, int h) {
            if (0 <= this.x && this.x < m && 0 <= this.y && this.y < n && 0 <= this.z && this.z < h) {
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int H = Integer.parseInt(input[2]);

        int[][][] tomato = new int[H][N][M];

        Queue<Axis> q = new LinkedList<>();

        for (int h = 0; h < H; ++h) {
            for (int r = 0; r < N; ++r) {
                input = br.readLine().split(" ");
                for (int c = 0; c < M; ++c) {
                    tomato[h][r][c] = Integer.parseInt(input[c]);
                    if (tomato[h][r][c] == 1) {
                        q.add(new Axis(c, r, h, 0));
                    }
                }
            }
        }

        int answer = 0;
        while (!q.isEmpty()) {
            Axis curr = q.poll();
            answer = curr.day;

            for (Axis dir : dirs) {
                Axis nextAxis = curr.addAxis(dir);
                if (nextAxis.inRange(M, N, H) && tomato[nextAxis.z][nextAxis.y][nextAxis.x] == 0) {
                    tomato[nextAxis.z][nextAxis.y][nextAxis.x] = 1;
                    q.add(nextAxis);
                }
            }
        }

        boolean valid = true;
        for (int h = 0; h < H && valid; ++h) {
            for (int r = 0; r < N && valid; ++r) {
                for (int c = 0; c < M && valid; ++c) {
                    if (tomato[h][r][c] == 0) {
                        valid = false;
                    }
                }
            }
        }
        if (valid) {
            bw.write(Integer.toString(answer));
        } else {
            bw.write("-1");
        }

        bw.close();
    }
}
