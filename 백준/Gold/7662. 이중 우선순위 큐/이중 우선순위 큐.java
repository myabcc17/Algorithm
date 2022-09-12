import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- != 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; ++i) {
                StringTokenizer tk = new StringTokenizer(br.readLine());
                String op = tk.nextToken();
                int n = Integer.parseInt(tk.nextToken());

                if (op.equals("I")) {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }

                    Entry<Integer, Integer> target;
                    if (n == 1) {
                        target = map.lastEntry();
                    } else {
                        target = map.firstEntry();
                    }

                    if (target.getValue() == 1) {
                        map.remove(target.getKey());
                    } else {
                        map.put(target.getKey(), target.getValue() - 1);
                    }
                }
            }

            if (map.isEmpty()) {
                bw.write("EMPTY\n");
            } else {

                bw.write(String.format("%d %d\n", map.lastKey(), map.firstKey()));
            }
        }
        bw.close();
    }
}
