import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] nums = new int[N];
        StringTokenizer tk = new StringTokenizer(br.readLine());
        for (int i = 0;tk.hasMoreTokens();++i) {
            nums[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(nums);

        dfs(nums, 0, 0, 0, M);

        System.out.println(answer);
    }

    public static void dfs(int[] nums, int start, int selectCount, int sum, int M) {
        if (selectCount == 3) {
            if (sum > answer) {
                answer = sum;
            }
            return;
        }

        for (int i = start; i < nums.length; ++i) {
            if (nums[i] >= M || (nums[i] + sum) > M) {
                break;
            }

            dfs(nums, i + 1, selectCount + 1, sum + nums[i], M);
        }
    }
}
