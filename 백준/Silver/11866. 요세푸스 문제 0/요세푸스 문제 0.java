import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken()) - 1;

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; ++i) list.add(i);

        List<Integer> answer = new ArrayList<>();
        int targetIdx = K;
        while (list.size() != 0) {
            targetIdx %= list.size();
            answer.add(list.get(targetIdx));
            list.remove(targetIdx);
            targetIdx += K;
        }

        bw.write('<');
        for (int i = 0; i < N; ++i) {
            if (i != N - 1) {
                bw.write(String.format("%d, ", answer.get(i)));
            } else {
                bw.write(String.valueOf(answer.get(i)));
            }
        }
        bw.write('>');
        bw.close();
    }
}
