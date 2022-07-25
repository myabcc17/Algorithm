import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String input = sc.nextLine();
            if (input.equals("0")) {
                break;
            }

            boolean isAnswer = true;
            for (int i = 0; i < input.length() / 2; i++) {
                if (input.charAt(i) != input.charAt(input.length() - (i + 1))) {
                    isAnswer = false;
                    break;
                }
            }
            if (isAnswer) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}