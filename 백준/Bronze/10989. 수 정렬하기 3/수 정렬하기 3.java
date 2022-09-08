import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[10001];

        for (int i = 0; i < N; ++i) {
            ++nums[Integer.parseInt(br.readLine())];
        }

        for (int i = 1; i <= 10000; ++i) {
            if (nums[i] != 0){
                for (int j = 0; j < nums[i]; ++j) {
                    bw.write(i + "\n");
                }
            }
        }
        bw.flush();
    }
}
