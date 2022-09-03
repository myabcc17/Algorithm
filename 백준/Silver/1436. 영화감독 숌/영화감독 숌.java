import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int num = 666;
        int count = 0;

        while (true) {
            if (String.valueOf(num).contains("666")) {
                ++count;
                if (count == N) {
                    break;
                }
            }
            ++num;
        }

        System.out.println(num);
    }
}
