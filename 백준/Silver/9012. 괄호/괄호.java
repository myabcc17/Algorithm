import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; ++t) {
            String input = br.readLine();

            int count = 0;
            for (int i = 0; i < input.length(); ++i) {
                if (input.charAt(i) == '(') {
                    count += 1;
                } else {
                    count -= 1;
                }

                if (count < 0) {
                    break;
                }
            }
            if (count != 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
