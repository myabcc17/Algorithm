import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Axis implements Comparable<Axis> {
        int x;
        int y;

        public Axis(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Axis o) {
            if (o.y < this.y) {
                return 1;
            } else if (o.y == this.y) {
                if (o.x <= this.x) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return String.format("%d %d\n", x, y);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Axis> list = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tk.nextToken());
            int y = Integer.parseInt(tk.nextToken());
            list.add(new Axis(x, y));
        }

        Collections.sort(list);
        for (Axis a : list) {
            bw.write(a.toString());
        }
        bw.close();
    }
}
