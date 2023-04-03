import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseNine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số hàng : ");
        int m = scanner.nextInt();
        System.out.println("Nhập số cột : ");
        int n = scanner.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("Nhập phần tử tại vị trí [%d][%d] : ", i, j);
                a[i][j] = scanner.nextInt();
            }
        }

        int tich = 1;
        for (int i = 0; i < n; i++) {
            if (a[0][i] % 3 == 0) {
                tich *= a[0][i];
            }
        }
        System.out.println("Tích bội số chung của 3 nằm trên dòng đầu tiên là : " + tich);


        List<Integer> rs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int max = a[i][0];
            for (int j = 0; j < n; j++) {
                if (max < a[i][j]) {
                    max = a[i][j];
                }
            }
            rs.add(max);
        }
        for (int element : rs
        ) {
            System.out.println("max trên từng dòng : " + element);
        }
    }
}
