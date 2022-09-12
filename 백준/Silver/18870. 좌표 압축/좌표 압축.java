import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] arr = new int[N];
        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(input[i]);
            s.add(arr[i]);
        }

        List<Integer> nums = new ArrayList<>(s);
        Collections.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.size(); ++i) {
            map.put(nums.get(i), i);
        }

        for (int i = 0; i < N; ++i) {
            bw.write(map.get(arr[i]) + " ");
        }

        bw.close();
    }
}
