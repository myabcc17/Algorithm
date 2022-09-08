import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int[] answers = new int[2]; // 0: white, 1: blue
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        cutPaper(0, 0, N, N, map, 0);
        cutPaper(0, 0, N, N, map, 1);
        bw.write(answers[0] + "\n");
        bw.write(answers[1] + "\n");
        bw.close();
    }

    public static void cutPaper(int x1, int y1, int x2, int y2, int[][] map, int color) {
        int size = x2 - x1;

        if (size == 1) {
            if (map[y1][x1] == color) {
                ++answers[color];
            }
            return;
        }

        boolean isPaper = true;

        for (int i = x1; i < x2 && isPaper; ++i) {
            for (int j = y1; j < y2; ++j) {
                if (map[j][i] != color) {
                    isPaper = false;
                    break;
                }
            }
        }

        if (isPaper) {
            ++answers[color];
            return;
        } else {
            int cutSize = size / 2;
            cutPaper(x1, y1, x2 - cutSize, y2 - cutSize, map, color);
            cutPaper(x1 + cutSize, y1, x2, y2 - cutSize, map, color);
            cutPaper(x1, y1 + cutSize, x2 - cutSize, y2, map, color);
            cutPaper(x1 + cutSize, y1 + cutSize, x2, y2, map, color);
        }
    }
}
