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
        int left = 0;
        int right = 0;

        String[] woodsStr = br.readLine().split(" ");
        int[] woods = new int[N];

        for (int i = 0; i < N; ++i) {
            woods[i] = Integer.parseInt(woodsStr[i]);
            if (woods[i] > right) {
                right = woods[i];
            }
        }

        int answer = 0;
        long cutSum;
        while (left + 1 < right) {
            cutSum = 0;
            int mid = (left + right) / 2;

            for (int i = 0; i < N; ++i) {
                int t = woods[i] - mid;
                if (t > 0) cutSum += t;
            }

            if (cutSum >= M) {
                if (mid > answer) {
                    answer = mid;
                }
                left = mid;
            } else {
                right = mid;
            }
        }

        bw.write(String.format("%d", answer));
        bw.close();
    }
}
