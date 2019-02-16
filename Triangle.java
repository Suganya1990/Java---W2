package Shape;

public class Triangle implements Shape{
    private String name = "Triangle";
   private  double side1;
   private  double side2;
   private double side3;
   private  double perimeter;
    Triangle(double side1,double side2, double side3) throws TriangleError
    {
           double a = side1+side2;
           double b = side2+side3;
           double c = side3+side1;
            if (a>side3 && b > side1 && c > side2) {
                if (((side1 + side2) > side3) & ((side2 + side3) > side1) & ((side1 + side3) > side2)) {
                    this.side1 = side1;
                    this.side2 = side2;
                    this.side3 = side3;
                    this.Perimeter();
                }
            }
            else
                throw new TriangleError("Invalid side(s)");
    }
    public String getName(){return this.name;}
    public void Perimeter(){
        perimeter = side1+side2+side3;
    }
    public double getPerimeter(){return this.perimeter;}
    public String toString(){
       return "Triangle {s1="+side1+", s2="+side2+", s3="+side3+"} perimeter = "+perimeter;
    }
}
