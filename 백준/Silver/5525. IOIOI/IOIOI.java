import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int answer = 0;
        int left = 0;
        int right = 2 * N;

        while (right < M) {
            while (right < M && !(S.charAt(left) == 'I' && S.charAt(right) == 'I')) {
                ++left;
                ++right;
            }
            if (right >= M) {
                break;
            }

            boolean find = true;
            for (int i = left; i < right; ++i) {
                if (S.charAt(i) == S.charAt(i + 1)) {
                    find = false;
                    left = i + 1;
                    right = left + (2 * N);
                    break;
                }
            }

            if (find) {
                ++answer;
                int i = right + 1;
                for (; i < M - 1; i = i + 2) {
                    if (S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                        ++answer;
                    } else {
                        break;
                    }
                }
                left = i;
                right = left + (2 * N);
            }
        }

        bw.write(Integer.toString(answer));
        bw.close();
    }
}
