import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();

        bw.write(String.valueOf(hash(br.readLine())));
        bw.close();
    }

    public static long hash(String input) {
        int r = 31;
        int M = 1234567891;

        long sum = 0;
        for (int i = 0; i < input.length(); ++i) {
            long a = input.charAt(i) - 'a' + 1;

            long pow = 1;
            for (int j = 1; j <= i; ++j) {
                pow = (pow * r) % M;
            }

            sum += (a * pow) % M;
        }

        return sum % M;
    }
}
