import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int nums[] = new int[N];
        int sums[] = new int[N + 1];
        sums[0] = 0;

        input = br.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(input[i]);
            sums[i + 1] += nums[i] + sums[i];
        }

        for (int i = 0; i < M; ++i) {
            input = br.readLine().split(" ");
            int left = Integer.parseInt(input[0]);
            int right = Integer.parseInt(input[1]);

            bw.write(sums[right] - sums[left - 1] + "\n");
        }

        bw.close();
    }
}