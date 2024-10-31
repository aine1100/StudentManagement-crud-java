package app.oop.shape;

public class Circle implements Shape{
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    private int radius;

    @Override
    public double area() {
        return radius*radius*Shape.PI;
    }

    @Override
    public void draw() {
        System.out.println("Draw");

    }

    @Override
    public void print() {
        System.out.println("Am a circle");

    }
}
