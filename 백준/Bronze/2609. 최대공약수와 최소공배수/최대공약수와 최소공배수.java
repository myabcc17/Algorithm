import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> primes = new ArrayList<>();

    public static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(tk.nextToken());
        int b = Integer.parseInt(tk.nextToken());

        for (int i = 2; i < 10000; ++i) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        Map<Integer, Integer> ma = extract(a);
        Map<Integer, Integer> mb = extract(b);

        int gcd = 1;
        for (int primeA : ma.keySet()) {
            if (mb.containsKey(primeA)) {
                gcd *= (int)Math.pow(primeA, Math.min(ma.get(primeA), mb.get(primeA)));
            }
        }

        int lcm = 1;
        for (int primeA : ma.keySet()) {
            if (mb.containsKey(primeA)) {
                lcm *= (int)Math.pow(primeA, Math.max(ma.get(primeA), mb.get(primeA)));
            } else {
                lcm *= (int)Math.pow(primeA, ma.get(primeA));
            }
        }
        for (int primeB : mb.keySet()) {
            if (!ma.containsKey(primeB)) {
                lcm *= (int)Math.pow(primeB, mb.get(primeB));
            }
        }

        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static Map<Integer, Integer> extract(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; n != 1; ++i) {
            int prime = primes.get(i);
            while (n != 1 && n % prime == 0) {
                n /= prime;
                map.put(prime, map.getOrDefault(prime, 0) + 1);
            }
        }
        return map;
    }
}
