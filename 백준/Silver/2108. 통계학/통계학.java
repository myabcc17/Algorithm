import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        int max = -4000;
        int min = 4000;
        Map<Integer, Integer> modeList = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(br.readLine());
            modeList.put(nums[i], modeList.getOrDefault(nums[i], 0) + 1);
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        System.out.println(Math.round(Arrays.stream(nums).average().getAsDouble()));

        Arrays.sort(nums);
        int median = nums.length % 2 == 0 ? (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2 : nums[nums.length / 2];
        System.out.println(median);

        int maxMode = 0;
        for (int i : modeList.values()) {
            if (i > maxMode) {
                maxMode = i;
            }
        }
        Queue<Integer> q = new PriorityQueue<>();
        for (Entry<Integer, Integer> e : modeList.entrySet()) {
            if (maxMode == e.getValue()) {
                q.add(e.getKey());
            }
        }
        if (q.size() > 1) q.poll();
        System.out.println(q.poll());

        System.out.println(max - min);
    }
}
