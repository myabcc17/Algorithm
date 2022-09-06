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

        int prev = 1;
        for (int i = 1;;++i) {
            int next = prev + (6 * i);

            if (N == 1) {
                bw.write(String.format("%d", 1));
                break;
            } else if (next >= N) {
                bw.write(String.format("%d", i + 1));
                break;
            } else {
                prev = next;
                continue;
            }
        }
        bw.close();
    }
}
