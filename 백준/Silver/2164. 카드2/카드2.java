import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; ++i) q.add(i);

        int i = 0;
        while (q.size() != 1) {
            if (i % 2 == 0) {
                q.remove();
            } else {
                q.add(q.poll());
            }
            i++;
        }
        System.out.println(q.peek());
    }
}
