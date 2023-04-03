import java.util.Scanner;

public class ExerciseThree {
    public static int giaithua(int n) {
        int giaithua = 1;
        for (int i = 1; i <= n; i++) {
            giaithua *= i;
        }
        return giaithua;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s += 1 / (giaithua((2 * i) - 1));
        }
        System.out.println(s);
    }
}
