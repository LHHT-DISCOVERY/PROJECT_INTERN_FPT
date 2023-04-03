import java.util.Scanner;
import java.util.Stack;

public class ExerciseSix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> integerStack = new Stack<>();
        System.out.print("Input Number : ");
        int number = scanner.nextInt();
        while (number > 0) {
            int x = number % 2;
            integerStack.push(x);
            number = number / 2;
        }
        System.out.print(" => output : ");
        while (!integerStack.isEmpty()) {
            System.out.print(integerStack.pop());
        }
    }
}
