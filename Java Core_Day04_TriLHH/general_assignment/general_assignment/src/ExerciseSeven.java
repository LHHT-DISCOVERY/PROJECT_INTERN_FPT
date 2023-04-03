import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ExerciseSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        String reverser = " ";
        for (int i = s.length(); i > 0; i--) {
            reverser += s.charAt(i - 1);
        }
        System.out.println("đảo ngược : " + reverser);
        System.out.println("In hoa : " + s.toUpperCase());
        System.out.println("In thường : " + s.toLowerCase());

        Map<Character, Integer> map = new HashMap<>();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                if (!map.containsKey(s.charAt(i))) {
                    // put(key = Char from s , value = ++count )
                    map.put(s.charAt(i), ++count);
                } else {
                    // value = Lấy giá trị tại vị trí i + ++count
                    // vì get sẽ lấy Object key và trả về value và sau đó ++count
                    map.put(s.charAt(i), map.get(s.charAt(i)) + ++count);
                }
            }
        }

        // Output
        System.out.println("Tần số suất hiện của kí tự trong S : ");
        Set<Map.Entry<Character, Integer>> mapSet = map.entrySet();
        for (Map.Entry<Character, Integer> entry : mapSet) {
            System.out.println("Character " + entry.getKey() + " : " + entry.getValue());
        }

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.printf("Character %s , %s is : ", n, m);
        System.out.println(s.substring(n, m));

    }
}
