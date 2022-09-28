import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        boolean[] knownTruth = new boolean[N + 1];

        token = new StringTokenizer(br.readLine());
        token.nextToken();
        while (token.hasMoreTokens()) {
            knownTruth[Integer.parseInt(token.nextToken())] = true;
        }

        List<List<Integer>> parties = new ArrayList<>();

        for (int i = 0; i < M; ++i) {
            token = new StringTokenizer(br.readLine());
            token.nextToken();

            List<Integer> peoples = new ArrayList<>();
            while (token.hasMoreTokens()) {
                peoples.add(Integer.parseInt(token.nextToken()));
            }
            parties.add(peoples);
        }

        for (int i = 0; i < M; ++i) {
            for (List<Integer> party : parties) {
                for (Integer n : party) {
                    if (knownTruth[n]) {
                        for (Integer m : party) {
                            knownTruth[m] = true;
                        }
                        break;
                    }
                }
            }
        }

        int answer = 0;

        for (List<Integer> party : parties) {
            boolean talk = true;

            for (Integer n : party) {
                if (knownTruth[n]) {
                    talk = false;
                }
                break;
            }

            if (talk) {
                ++answer;
            }
        }

        bw.write(Integer.toString(answer));
        bw.close();
    }
}