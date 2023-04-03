import java.util.Scanner;

public class ExerciseFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int bcnn = 0;
        bcnn = (a > b) ? a : b;
        while (true) {
            if (bcnn % a == 0 && bcnn % b == 0) {
                System.out.printf("bội chung nhỏ nhất là: %d", bcnn);
                break;
            }
            ++bcnn;
        }
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        System.out.printf("Ước chung lớn nhất là: %d", b);
    }
}
