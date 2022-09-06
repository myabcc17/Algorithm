import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tk = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(tk.nextToken());
        int B = Integer.parseInt(tk.nextToken());
        int V = Integer.parseInt(tk.nextToken());

        int targetHeight = V - A;
        int day;
        if (targetHeight % (A - B) == 0) {
            day = targetHeight / (A - B);
        } else {
            day = targetHeight / (A - B) + 1;
        }
        bw.write(String.format("%d", day + 1));
        bw.close();
    }
}
