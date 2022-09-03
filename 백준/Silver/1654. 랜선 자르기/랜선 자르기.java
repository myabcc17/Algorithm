import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer t = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(t.nextToken());
        int K = Integer.valueOf(t.nextToken());

        int[] inputs = new int[N];

        long max = 0;
        for (int i = 0; i < N; ++i) {
            inputs[i] = Integer.valueOf(br.readLine());
            if (max < inputs[i]) {
                max = inputs[i];
            }
        }

        long low = 0;
        long high = max;
        long answer = 0;
        long lines = 0;
        while (low + 1 < high) {
            lines = 0;
            long mid = (low + high) / 2;

            for (int i = 0; i < N; ++i) {
                lines += inputs[i] / mid;
            }

            if (lines >= K) {
                if (mid >= answer) {
                    answer = mid;
                }
                low = mid;
            } else {
                high = mid;
            }
        }

        lines = 0;
        for (int i = 0; i < N; ++i) {
            lines += inputs[i] / high;
        }

        if (lines >= K) {
            if (high >= answer) {
                answer = high;
            }
        }

        System.out.println(answer);
    }
}
