package club.banyuan.area;

public class rectangle extends Shape {
    private int width, length;

    public String getShapeName() {
        return "矩形";
    }

    public rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public double area() {
        return width * length;
    }

    public double perimeter() {
        return (width + length) * 2;
    }
}

