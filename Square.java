package Shape;

public class Square implements Shape{
    private static String name = "Square";
    private double length;
    private double perimeter;

    Square(double length) throws SquareError
    {
        if(length< 0)
            throw new SquareError("Invalid Side");
        else
        {
            this.length = length;
            Perimeter();
        }
    }
    public String getName(){return this.name;}
    public void Perimeter(){
        this.perimeter = 2*length;
    }
    public double getLength(){return this.length;}
    public double getPerimeter(){return this.perimeter;}
    public double setLength(double length){return this.length = length;}
    public String toString(){
        return "Square {s=" + length + "} perimeter = "+ perimeter;
    }
}
