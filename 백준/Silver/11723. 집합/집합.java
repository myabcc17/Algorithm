import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        Set<Integer> s = new HashSet<>();

        while (M-- != 0) {
            String[] input = br.readLine().split(" ");
            String op = input[0];
            int x = 0;
            if (input.length == 2) {
                x = Integer.parseInt(input[1]);
            }

            if (op.equals("add") && !s.contains(x)) {
                s.add(x);
            } else if (op.equals("remove") && s.contains(x)) {
                s.remove(x);
            } else if (op.equals("check")) {
                if (s.contains(x)) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (op.equals("toggle")) {
                if (s.contains(x)) {
                    s.remove(x);
                } else {
                    s.add(x);
                }
            } else if (op.equals("all")) {
                for (int i = 1; i <= 20; ++i) {
                    s.add(i);
                }
            } else if (op.equals("empty")) {
                s.clear();
            }
        }
        bw.close();
    }
}
