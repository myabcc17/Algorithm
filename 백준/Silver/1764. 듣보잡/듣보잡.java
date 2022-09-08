import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        Set<String> names = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            names.add(br.readLine());
        }

        List<String> answers = new ArrayList<>();
        for (int i = 0; i < M; ++i) {
            String name = br.readLine();
            if (names.contains(name)) {
               answers.add(name);
            }
        }

        Collections.sort(answers);
        bw.write(answers.size() + "\n");
        for (String s : answers) {
            bw.write(s + "\n");
        }
        bw.close();
    }
}
