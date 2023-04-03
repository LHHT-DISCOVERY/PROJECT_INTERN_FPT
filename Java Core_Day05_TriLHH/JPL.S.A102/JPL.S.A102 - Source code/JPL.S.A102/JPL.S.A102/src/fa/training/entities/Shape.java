package fa.training.entities;

public interface Shape {
    abstract int calculatePerimeter();

    abstract int calculateArea();

    abstract int getWidth();

    abstract int getLength();

    abstract void setLengthWidth(int length, int width);

}
