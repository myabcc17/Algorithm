import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();

        List<String> strings = List.of(s1, s2, s3);

        int nextN = 0;

        for (int i = 0; i < 3; i++) {
            try {
                int n = Integer.parseInt(strings.get(i));
                nextN = n + (3 - i);
            } catch (NumberFormatException e) {
                continue;
            }
        }

        if (nextN % 3 == 0 && nextN % 5 == 0) {
            bw.write("FizzBuzz");
        } else if (nextN % 3 == 0) {
            bw.write("Fizz");
        } else if (nextN % 5 == 0) {
            bw.write("Buzz");
        } else {
            bw.write(String.valueOf(nextN));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
