import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static class Pair {
        int two;
        int five;

        public Pair(int two, int five) {
            this.two = two;
            this.five = five;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Pair p = new Pair(0, 0);
        for (int i = 2; i <= N; ++i) {
            calc(i, p);
        }

        bw.write(Integer.toString(Math.min(p.two, p.five)));
        bw.close();
    }

    public static void calc(int n, Pair p) {
        while (n % 2 == 0) {
            p.two += 1;
            n /= 2;
        }

        while (n % 5 == 0) {
            p.five += 1;
            n /= 5;
        }
    }
}
