import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        long[] pibo = new long[100];
        pibo[0] = 1;
        pibo[1] = 1;
        pibo[2] = 1;

        for (int i = 3; i < 100; ++i) {
            pibo[i] = pibo[i - 2] + pibo[i - 3];
        }

        for (int t = 0; t < T; ++t) {
            int n = Integer.parseInt(br.readLine());
            bw.write(pibo[n - 1] + "\n");
        }

        bw.close();
    }
}