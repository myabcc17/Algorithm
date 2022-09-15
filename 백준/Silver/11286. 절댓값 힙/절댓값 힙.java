import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) < Math.abs(o2)) {
                return -1;
            } else if (Math.abs(o1) == Math.abs(o2)) {
                if (o1 < o2) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        });

        for (int i = 0; i < N; ++i) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (q.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(q.poll() + "\n");
                }
            } else {
                q.add(num);
            }
        }
        bw.close();
    }
}