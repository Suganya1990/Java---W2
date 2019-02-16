package Shape;

public class Circle implements Shape {
   private static String name = "Circle";
   private double radius;
   private double perimeter;

    Circle(double radius) throws CircleError
    {
            if ( radius< 0 )
            throw new CircleError("Invalid radius ");
            else
            {
                this.radius = radius;
                Perimeter();
            }

    }

  public void Perimeter() {
       perimeter = radius * Math.PI;
   }
   public String getName(){return this.name;}
   public double getRaidus(){return radius;}
   public double getPerimeter(){return perimeter;}
   public void setRadius(double radius){this.radius = radius;}
   public String toString(){
        return "Circle {r" + radius + "} perimeter = "+ perimeter;
   }

}
