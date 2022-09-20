import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; ++i) {
            input = br.readLine().split(" ");
            map.put(input[0], input[1]);
        }

        for (int i = 0; i < M; ++i) {
            bw.write(map.get(br.readLine()) + "\n");
        }
        bw.close();
    }
}