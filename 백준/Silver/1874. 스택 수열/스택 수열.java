import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        List<String> ops = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; ++i) {
            q.add(Integer.valueOf(br.readLine()));
        }

        int n = 1;
        boolean impossible = false;
        while(!q.isEmpty()) {
            int target = q.peek();

            if (!stack.isEmpty()) {
                int top = stack.peek();
                if (target < top) {
                    impossible = true;
                    break;
                }

                if (top == target) {
                    q.remove();
                    stack.pop();
                    ops.add("-");
                } else {
                    stack.push(n++);
                    ops.add("+");
                }
            } else {
                stack.push(n++);
                ops.add("+");
            }
        }

        if (impossible) {
            System.out.println("NO");
        } else {
            for (String op : ops) {
                System.out.println(op);
            }
        }
    }
}
