import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            int n = Integer.parseInt(br.readLine());
            int answer = 1;

            Map<String, List<String>> map = new HashMap<>();

            for (int i = 0; i < n; ++i) {
                String[] input = br.readLine().split(" ");
                List<String> names = map.getOrDefault(input[1], new ArrayList<>());
                names.add(input[0]);

                map.put(input[1], names);
            }

            for (String key : map.keySet()) {
                answer *= map.get(key).size() +  1;
            }

            bw.write(Integer.toString(n == 0 ? 0 : answer - 1) + "\n");
        }

        bw.close();
    }
}