import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();
            if (input.equals(".")) {
                break;
            }

            Stack<Integer> stack = new Stack<>();
            boolean invalid = false;

            for (int i = 0; i < input.length() && !invalid; ++i) {
                switch (input.charAt(i)) {
                    case '(':
                        stack.push(0);
                        break;
                    case ')':
                        if (!stack.isEmpty() && stack.peek() == 0) {
                            stack.pop();
                        } else {
                            invalid = true;
                        }
                        break;
                    case '[':
                        stack.push(1);
                        break;
                    case ']':
                        if (!stack.isEmpty() && stack.peek() == 1) {
                            stack.pop();
                        } else {
                            invalid = true;
                        }
                        break;
                }
            }
            if (invalid || !stack.isEmpty()) {
                bw.write("no\n");
            } else {
                bw.write("yes\n");
            }
        }
        bw.close();
    }
}
