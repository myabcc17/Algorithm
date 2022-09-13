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
        while (T-- != 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String nStr = br.readLine();

            int[] arr = new int[n];
            if (n > 0) {
                String newStr = nStr.substring(1, nStr.length() - 1);
                int i = 0;
                for (String s : newStr.split(",")) {
                    arr[i++] = Integer.parseInt(s);
                }
            }

            boolean possible = true;
            boolean reverse = false;
            int front = 0;
            int rear = n - 1;
            for (int i = 0; i < p.length() && possible; ++i) {
                if (p.charAt(i) == 'R') {
                    reverse = !reverse;
                    continue;
                }

                if (front > rear) {
                    possible = false;
                    continue;
                }

                if (reverse) {
                    --rear;
                } else {
                    ++front;
                }

            }

            if (possible) {
                bw.write("[");
                if (reverse) {
                    for (int i = rear; i >= front; --i) {
                        bw.write(Integer.toString(arr[i]));
                        if (i != front) {
                            bw.write(',');
                        }
                    }
                } else {
                    for (int i = front; i <= rear; ++i) {
                        bw.write(Integer.toString(arr[i]));
                        if (i != rear) {
                            bw.write(',');
                        }
                    }
                }
                bw.write("]\n");
            } else {
                bw.write("error\n");
            }
        }
        bw.close();
    }
}
