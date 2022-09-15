import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- != 0) {
            String[] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]) - 1;
            int y = Integer.parseInt(input[3]) - 1;

            int year = x;
            int initY = year % N;
            int nextY = year % N;
            do {
                if (nextY == y) {
                    break;
                }
                year += M;
                nextY = (nextY + M) % N;
            } while (initY != nextY);

            if (year != x && initY == nextY) {
                bw.write("-1\n");
            } else {
                bw.write(year + 1 + "\n");
            }
        }

        bw.close();
    }
}
