import java.util.Scanner;

public class ExerciseFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = 0;
        int s = 0;
        int m = 1;

        while (n > 0) {
            c = n % 10;
            n = n / 10;
            s += c;
            m *= c;
        }
        System.out.println("Sum:" + s);
        System.out.println("Multiply:" + m);
    }
}
