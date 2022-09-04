import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<String>> map = new TreeMap<>();

        for (int i = 0; i < N; ++i) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(tk.nextToken());
            String name = tk.nextToken();

            List<String> names = map.getOrDefault(age, new ArrayList<>());
            names.add(name);
            map.put(age, names);
        }

        for (Entry<Integer, List<String>> e : map.entrySet()) {
            int key = e.getKey();
            for (String s : e.getValue()) {
                System.out.println(key + " " + s);
            }
        }
    }
}
