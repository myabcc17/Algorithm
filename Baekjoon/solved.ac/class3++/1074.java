import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int count = 0;
        while (N != 0) {
            int size = (int)Math.pow(2, N);
            int halfN = size / 2;

            if (r < halfN && c < halfN) {

            } else if (r < halfN && c >= halfN) {
                c -= halfN;
                count += (halfN * halfN * 1);
            } else if (r >= halfN && c < halfN) {
                r -= halfN;
                count += (halfN * halfN * 2);
            } else {
                r -= halfN;
                c -= halfN;
                count += (halfN * halfN * 3);
            }
            N -= 1;
        }
        System.out.println(count);
    }
}
