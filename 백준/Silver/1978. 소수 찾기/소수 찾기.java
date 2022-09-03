import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2 || n == 3) return true;

        for (int i = 2; i <= (int)Math.sqrt(n); ++i) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int answer = 0;
        while(tk.hasMoreTokens()) {
            if (isPrime(Integer.parseInt(tk.nextToken()))) ++answer;
        }
        System.out.println(answer);
    }
}
