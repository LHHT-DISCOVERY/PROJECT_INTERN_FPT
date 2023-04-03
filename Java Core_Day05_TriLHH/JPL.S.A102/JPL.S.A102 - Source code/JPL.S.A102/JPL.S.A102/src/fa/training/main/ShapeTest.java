package fa.training.main;

import fa.training.entities.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeTest {
    public static void main(String[] args) {
//        a
        System.out.println("Nhập số hình chữ nhật trong một mảng : ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Rectangle> rectanglesList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhâp chiều dài hình chữ nhật thứ %d : ", i + 1);
            int length = scanner.nextInt();
            System.out.printf("Nhâp chiều rộng hình chữ nhật thứ %d : ", i + 1);
            int width = scanner.nextInt();
            rectanglesList.add(new Rectangle(length, width));
        }
//        B
        for (Rectangle rectangle : rectanglesList
        ) {
            System.out.print("hình chữ nhật có chiều dài là  : " +
                    rectangle.getLength() + ", Chiều rộng là : " + rectangle.getWidth() +
                    " => có chu vi là : " + rectangle.calculatePerimeter());
            if (rectangle.getWidth() == rectangle.getLength()) {
                System.out.println(" và hình chữ nhật này là Hình Vuông");
            }
        }

//        C,D
        int maxArea = rectanglesList.get(0).calculateArea();
        int minPerimeter = rectanglesList.get(0).calculatePerimeter();
        for (int i = 1; i < rectanglesList.size(); i++) {
            if (rectanglesList.get(i).calculateArea() > maxArea) {
                maxArea = rectanglesList.get(i).calculateArea();
            }
            if (rectanglesList.get(i).calculatePerimeter() < minPerimeter) {
                minPerimeter = rectanglesList.get(i).calculatePerimeter();
            }
        }

        System.out.println("Hình chữ nhật có diện tích lớn nhất là : " + maxArea);
        System.out.println("Hình chữ nhật có chu vi nhỏ nhất là : " + minPerimeter);

    }
}
