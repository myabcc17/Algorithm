import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 0;;++i) {
            int start = (int)Math.pow(2, i - 1);
            int end = (int)Math.pow(2, i);

            if (N > start && N <= end) {
                System.out.println(2 * (N - start));
                break;
            }
        }
    }
}
