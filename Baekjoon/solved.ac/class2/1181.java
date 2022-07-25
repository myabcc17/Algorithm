import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        List<Set<String>> q = new ArrayList<>();

        for (int i = 0; i <= 50; i++) {
            q.add(new HashSet<>());
        }

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            q.get(s.length()).add(s);
        }

        for (int i = 0; i <= 50; i++) {
            Set<String> list = q.get(i);
            if (!list.isEmpty()) {
                List<String> list2 = new ArrayList<>(list);
                Collections.sort(list2);
                for (String s : list2) {
                    System.out.println(s);
                }
            }
        }
    }
}