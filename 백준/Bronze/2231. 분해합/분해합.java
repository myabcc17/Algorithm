import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        bw.write(String.format("%d", partSum(N)));
        bw.close();
    }
    
    public static int partSum(int n) {
        for (int i = 1; i <= 1000000; ++i) {
            String numString = String.valueOf(i);

            int partSum = 0;
            for (int j = 0; j < numString.length(); ++j) {
                partSum += numString.charAt(j) - '0';
            }
            if (i + partSum == n) {
                return i;
            }
        }
        return 0;
    }
}
