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
        int K = Integer.parseInt(tk.nextToken());

        int answer = 1;
        for (int i = 2; i <= N; ++i) answer *= i;
        for (int i = 2; i <= K; ++i) answer /= i;
        for (int i = 2; i <= (N - K); ++i) answer /= i;
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
