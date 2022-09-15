import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static class Pair {
        int v;
        String op;

        public Pair(int v, String op) {
            this.v = v;
            this.op = op;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        char[] ops = {'D', 'S', 'L', 'R'};
        while (T-- != 0) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            boolean[] visit = new boolean[10000];

            Queue<Pair> q = new LinkedList<>();
            visit[A] = true;
            q.add(new Pair(A, ""));

            while (!q.isEmpty()) {
                Pair curr = q.poll();
                int v = curr.v;

                if (v == B) {
                    bw.write(curr.op + "\n");
                    break;
                }

                for (int i = 0; i < ops.length; ++i) {
                    int newV = 0;
                    switch (ops[i]) {
                        case 'D':
                            newV = (v * 2) % 10000;
                            break;
                        case 'S':
                            newV = v == 0 ? 9999 : v - 1;
                            break;
                        case 'L':
                            newV = v % 1000 * 10 + v / 1000;
                            break;
                        case 'R':
                            newV = v % 10 * 1000 + v / 10;
                            break;
                    }

                    if (visit[newV]) {
                        continue;
                    }

                    visit[newV] = true;
                    q.add(new Pair(newV, curr.op + ops[i]));
                }
            }
        }

        bw.close();
    }
}
