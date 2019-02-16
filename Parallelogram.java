package Shape;

public class Parallelogram extends Rectangle {
    private static String name = "Parallelogram";
    private double perimeter;
    Parallelogram(double width, double length) throws SquareError, RectangleError
    {
        super(length, width);
        perimeter = super.getPerimeter();
    }

    public double getPerimeter(){
        return perimeter;

    }
    public String getName(){ return this.name;}
     public String toString(){
        return "Parallelogram {w= " + super.getLength()+ ", h=" + super.getWidth() + "} perimeter = " + super.getPerimeter();
    }

}
