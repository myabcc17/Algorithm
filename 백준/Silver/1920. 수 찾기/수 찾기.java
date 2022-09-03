import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        Map<Integer, Integer> exist = new HashMap<>();
        for (String s : br.readLine().split(" ")) {
            exist.put(Integer.valueOf(s), 1);
        }

        br.readLine();

        for (String s : br.readLine().split(" ")) {
            System.out.println(String.format("%d", exist.getOrDefault(Integer.valueOf(s), 0)));
        }
    }
}
