import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        int B = Integer.parseInt(tk.nextToken());
        int[][] map = new int[N][M];

        for (int i = 0; i < N; ++i) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        int answerTime = 987654321;
        int answerHeight = 0;

        int time = 0;
        while (answerTime >= time) {
            int maxHeight = getMaxHeight(N, M, map);
            if (maxHeight < 0) {
                break;
            }
            int fillCount = checkFillBlock(N, M, B, maxHeight, map);

            if (fillCount > 0 && answerTime > time + fillCount) {
                answerTime = time + fillCount;
                answerHeight = maxHeight;
            }

            if (isFlat(N, M, map) && answerTime > time) {
                answerTime = time;
                answerHeight = maxHeight;
            }

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (map[i][j] == maxHeight) {
                        time += 2;
                        map[i][j] -= 1;
                        B += 1;
                    }
                }
            }
        }

        bw.write(String.format("%d %d", answerTime, answerHeight));
        bw.close();
    }

    public static boolean isFlat(int N, int M, int[][] map) {
        int height = map[0][0];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (height != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int checkFillBlock(int N, int M, int B, int maxHeight, int[][] map) {
        boolean possible = true;
        int useBlock = 0;
        for (int i = 0; i < N && possible; ++i) {
            for (int j = 0; j < M && possible; ++j) {
                useBlock += (maxHeight - map[i][j]);
                if (useBlock > B) {
                    possible = false;
                }
            }
        }

        return possible ? useBlock : -1;
    }

    public static int getMaxHeight(int N, int M, int[][] map) {
        int maxHeight = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (maxHeight < map[i][j]) {
                    maxHeight = map[i][j];
                }
            }
        }
        return maxHeight;
    }
}
