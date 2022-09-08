import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] errors = new boolean[10];

        if (M > 0) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            while (tk.hasMoreTokens()) {
                errors[Integer.parseInt(tk.nextToken())] = true;
            }
        }

        int answer = Math.abs(N - 100);

        for (int i = 0; i < answer; ++i) {
            if (N - i >= 0) {
                int prevChannel = N - i;
                int clickCount = String.valueOf(prevChannel).length() + i;

                if (possible(prevChannel, errors) && clickCount < answer) {
                    answer = clickCount;
                    break;
                }
            }

            int nextChannel = N + i;
            int clickCount = String.valueOf(nextChannel).length() + i;
            if (possible(nextChannel, errors) && clickCount < answer) {
                answer = clickCount;
                break;
            }

        }

        bw.write(Integer.toString(answer));
        bw.close();
    }

    public static boolean possible(int n, boolean[] errors) {
        String str = Integer.toString(n);
        for (int i = 0; i < str.length(); ++i) {
            if (errors[str.charAt(i) - '0']) {
                return false;
            }
        }
        return true;
    }
}
