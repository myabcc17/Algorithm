
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; ++t) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(tk.nextToken());
            int w = Integer.parseInt(tk.nextToken());
            int n = Integer.parseInt(tk.nextToken());

            int row = n % h == 0 ? h : n % h;
            int col = n % h == 0 ? n / h : n / h + 1;

            System.out.println(String.format("%d%02d", row, col));
        }
    }
}
