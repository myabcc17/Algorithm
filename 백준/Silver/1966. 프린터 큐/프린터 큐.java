import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Print {
        int idx;
        int priority;

        Print(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(tk.nextToken());
            int M = Integer.parseInt(tk.nextToken());
            tk = new StringTokenizer(br.readLine());

            Queue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            Queue<Print> printQueue = new LinkedList<>();
            int idx = 0;
            while (tk.hasMoreTokens()) {
                int order = Integer.parseInt(tk.nextToken());
                maxQueue.add(order);
                printQueue.add(new Print(idx++, order));
            }

            int answer = -1;
            int printCount = -1;
            while (answer == -1) {
                int targetPriority = maxQueue.poll();

                while (true) {
                    Print head = printQueue.poll();
                    if (head.priority == targetPriority) {
                        printCount++;
                        if (head.idx == M) {
                            answer = printCount;
                        }
                        break;
                    } else {
                        printQueue.add(head);
                    }
                }
            }
            System.out.println(answer + 1);
        }
    }
}
