import java.util.Scanner;

public class ExerciseTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s += +1 / i + 1;
        }
        System.out.println("s : " + s);
    }
}
