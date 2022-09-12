import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        StringBuilder sb = new StringBuilder();

        int positive = 0;
        int negative = 0;
        boolean startNegative = false;

        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);

            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                if (startNegative) {
                    negative += Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                } else {
                    positive += Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                }

                if (c == '-') {
                    startNegative = true;
                }
            }
        }
        if (startNegative) {
            negative += Integer.parseInt(sb.toString());
        } else {
            positive += Integer.parseInt(sb.toString());
        }

        bw.write(Integer.toString(positive - negative));
        bw.close();
    }
}
