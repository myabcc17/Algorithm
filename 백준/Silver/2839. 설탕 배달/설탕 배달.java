import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 5000;
        if (N % 3 == 0) {
            answer = N / 3;
        }
        if (N % 5 == 0) {
            answer = N / 5;
        }

        for (int i = 1; i <= N / 5; ++i) {
            if ((N - (i * 5)) % 3 == 0) {
                int count = i + ((N - (i * 5)) / 3);
                if (answer > count) {
                    answer = count;
                }
            }
        }
        System.out.println(answer == 5000 ? -1 : answer);
    }
}
