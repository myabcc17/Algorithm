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
        int K = Integer.parseInt(input[1]);
        int nums[] = new int[N];
        int answer = 0;

        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i >= 0; --i) {
            answer += K / nums[i];
            K %= nums[i];
        }

        bw.write(answer + "\n");
        bw.close();
    }
}