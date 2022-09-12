import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; ++i) {
            String input = br.readLine();
            for (int j = 0; j < N; ++j) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        if (canComp(N, 0, 0, map)) {
            sb.append(map[0][0]);
        } else {
            sb.append('(');
            comp(N, 0, 0, map);
            sb.append(')');
        }
        bw.write(sb.toString());
        bw.close();
    }

    public static boolean canComp(int size, int x, int y, int[][] map) {
        int n = map[x][y];
        for (int i = x; i < x + size; ++i) {
            for (int j = y; j < y + size; ++j) {
                if (n != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void comp(int size, int x, int y, int[][] map) {
        int startNum = map[x][y];

        if (canComp(size, x, y, map)) {
            sb.append(startNum);
        } else if (size > 1) {
            int cutSize = size / 2;
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < 2; ++j) {
                    if (canComp(cutSize, x + (cutSize * i), y + (cutSize * j), map)) {
                        comp(cutSize, x + (cutSize * i), y + (cutSize * j), map);
                    } else {
                        sb.append('(');
                        comp(cutSize, x + (cutSize * i), y + (cutSize * j), map);
                        sb.append(')');
                    }
                }
            }
        }
    }
}
