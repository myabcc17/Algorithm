import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int skip = (int) Math.round(n * 0.15);
        int sum = 0;
        int i = 0;

        while (!pq.isEmpty()) {
            int v = pq.poll();
            if (i < skip || i >= (n - skip)) {
                i++;
                continue;
            } else {
                i++;
                sum += v;
            }
        }

        bw.write(String.valueOf(Math.round(sum / (double) (n - skip * 2))));
        bw.flush();
        bw.close();
        br.close();
    }
}