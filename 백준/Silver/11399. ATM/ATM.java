import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int i = 0;
        for (String nStr : br.readLine().split(" ")) {
            nums[i++] = Integer.parseInt(nStr);
        }

        Arrays.sort(nums);

        int answer = 0;
        int sum = 0;
        for (i = 0; i < N; ++i) {
            sum += nums[i];
            answer += sum;
        }
        bw.write(Integer.toString(answer));
        bw.close();
    }
}
