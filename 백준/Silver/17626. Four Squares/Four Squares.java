import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        for (int i = 1; i * i <= n; ++i) {
            dp[i * i] = 1;
        }

        for (int i = 1; i <= n; ++i) {
            if (dp[i] != 0) {
                continue;
            }

            int sqrt = (int) Math.floor(Math.sqrt(i));

            for (int j = 1; j <= sqrt; ++j) {
                int min = dp[j * j] + dp[i - j * j];
                if (dp[i] == 0) {
                    dp[i] = min;
                } else {
                    dp[i] = Math.min(dp[i], min);
                }
            }
        }

        bw.write(Integer.toString(dp[n]));
        bw.close();
    }
}