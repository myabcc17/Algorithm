import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int[] answer = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];

        for (int i = 0; i < N; ++i) {
            int j = 0;
            for (String s : br.readLine().split(" ")) {
                paper[i][j++] = Integer.parseInt(s);
            }
        }

        cut(N, 0, 0, paper);

        for (int i = 0; i < 3; ++i) {
            bw.write(answer[i] + "\n");
        }
        bw.close();
    }

    public static void cut(int size, int x, int y, int[][] paper) {
        int startNum = paper[y][x];
        if (size == 1) {
            ++answer[startNum + 1];
            return;
        }

        boolean isCut = false;

        for (int i = x; i < x + size && !isCut; ++i) {
            for (int j = y; j < y + size && !isCut; ++j) {
                if (startNum != paper[j][i]) {
                    isCut = true;
                }
            }
        }

        if (!isCut) {
            ++answer[startNum + 1];
        } else {
            int cutSize = size / 3;
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    cut(cutSize, x + (cutSize * i), y + (cutSize * j), paper);
                }
            }
        }
    }
}
