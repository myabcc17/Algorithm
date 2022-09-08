import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        Map<String, String> names = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            String name = br.readLine();
            names.put(Integer.toString(i + 1), name);
            names.put(name, Integer.toString(i + 1));
        }
        for (int i = 0; i < M; ++i) {
            String question = br.readLine();
            bw.write(names.get(question) + "\n");
        }
        bw.close();
    }
}
