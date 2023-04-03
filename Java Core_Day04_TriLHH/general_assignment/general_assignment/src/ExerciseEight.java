import java.util.Arrays;
import java.util.Scanner;

public class ExerciseEight {
    public static int[] sapxep(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            System.out.printf("Nhập vào phần tử thứ [%d]  : ", i);
            a[i] = scanner.nextInt();
        }

        int sum = 0;
        int count = 0;
        System.out.println("Nhập vào phần tử cần tìm");
        int k = scanner.nextInt();
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0 && a[i] > 0) {
                sum += a[i];
            }
        }
        System.out.println("Sum lẻ lớn hơn 0 là : " + sum);


        int index = 0;
        boolean isFlag = false;
        for (int j = 0; j < a.length; j++) {
            if (a[j] == k) {
                index = j;
                isFlag = true;
                break;
            }
        }

        if (isFlag) {
            System.out.printf("Phần tử %d xuất hiện tại vị trí %d", k, index);
            System.out.println();
        } else {
            System.out.printf("Phần tử %d ko tồn tạo trong mảng ", k);
            System.out.println();
        }


//        xắp sếp
        System.out.println("mảng sau khi sắp xếp là : " + Arrays.toString(sapxep(a)));

//        Chèn theo thứ tự tăng dần
        int[] b = new int[1];
        int[] result = new int[a.length + b.length];
        int value = scanner.nextInt();
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            int c = a.length + i;
            result[c] = b[i];
        }

        boolean timduocG = false;
        for (int g = 0; g < result.length; g++) {
            if (result[g] > value) {
                timduocG = true;
                for (int i = result.length - 1; i > g; i--) {
                    result[i] = result[i - 1];
                }
                result[g] = value;
                break;
            }
        }
        if (!timduocG) {
            result[result.length - 1] = value;
        }

        System.out.println("Mảng sau khi chèn là : " + Arrays.toString(result));
    }
}
