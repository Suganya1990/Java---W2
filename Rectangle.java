package Shape;

public class Rectangle extends Square {
    private static String name = "Square";
    private double width;
    private double perimeter;
    Rectangle(double length, double width) throws SquareError, RectangleError {
        super(length);
          if (length > 0 && width > 0) {
              this.width = width;
              this.Perimeter();
          }
          else new RectangleError("Invalid side(s)");
    }
    public String getName(){return this.name;}
    public void Perimeter(){this.perimeter = 2*(width+getLength());}
    public double getPerimeter(){return perimeter;}
    public double getWidth(){return this.width;}
    public double getLength(){return super.getLength();}
    public String toString(){
        return "Rectangle {w=" + width+" h=" + this.getLength() + "} perimeter =" +perimeter;
    }

}
