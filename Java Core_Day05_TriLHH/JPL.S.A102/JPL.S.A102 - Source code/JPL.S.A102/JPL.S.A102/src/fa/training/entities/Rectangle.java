package fa.training.entities;

public class Rectangle implements Shape {
    private int length;
    private int width;

    public Rectangle() {
    }

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public int calculatePerimeter() {
        return (length + width) * 2;
    }

    @Override
    public int calculateArea() {
        return length * width;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void setLengthWidth(int length, int width) {
        this.width = width;
        this.length = length;
    }
}
