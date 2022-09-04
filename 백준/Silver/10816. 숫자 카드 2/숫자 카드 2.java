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

        br.readLine();
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer tk = new StringTokenizer(br.readLine());
        while (tk.hasMoreTokens()) {
            int num = Integer.parseInt(tk.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        br.readLine();
        tk = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (tk.hasMoreTokens()) {
            int num = Integer.parseInt(tk.nextToken());
            sb.append(map.getOrDefault(num, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
