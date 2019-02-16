
package Shape;
import java.io.*;
import java.util.Arrays;



public class Main {
    private static double SumOfTrianglesPerimeter;
    private static double SumOfParallelogramPerimeter;
    private static int count;
    private static  Shape[] arr = new Shape[50];
    public static Shape[] removeTheElement(Shape[] temp,
                                         int index)
    {
        //check input array is empty
        if (temp == null
                || index < 0
                || index >= temp.length) {

            return temp;
        }

        // Create another array of size one less
        Shape[] anotherArray = new Shape[temp.length - 1];

        // Copy the elements from starting till index
        // from original array to the other array
        System.arraycopy(temp, 0, anotherArray, 0, index);

        //copy from index+1 to end of the array;
        System.arraycopy(temp, index + 1,
                anotherArray, index,
                temp.length - index - 1);
        return anotherArray;
    }

    public static void Task1(String[] tokens)
    {
        try {
            if (tokens[0].equals("Circle")) {
                if (tokens.length == 2) {
                    double r = Double.parseDouble(tokens[1]);
                    arr[count] = new Circle(r);
                    count++;
                }

            } else if (tokens[0].equals("Square")) {
                if (tokens.length == 2) {
                    double length = Double.parseDouble(tokens[1]);
                    arr[count] = new Square(length);
                    count++;
                }

            } else if (tokens[0].equals("Rectangle")) {
                if (tokens.length == 3) {
                    double length = Double.parseDouble(tokens[1]);
                    double width = Double.parseDouble(tokens[2]);
                    arr[count] = new Rectangle(length, width);
                    count++;
                }

            } else if (tokens[0].equals("Parallelogram")) {
                if (tokens.length == 3) {
                    double length = Double.parseDouble(tokens[1]);
                    double width = Double.parseDouble(tokens[2]);
                    arr[count] = new Parallelogram(length, width);
                    count++;
                }

            } else if (tokens[0].equals("Triangle")) {
                if (tokens.length == 4) {
                    double side1 = Double.parseDouble(tokens[1]);
                    double side2 = Double.parseDouble(tokens[2]);
                    double side3 = Double.parseDouble(tokens[3]);
                    arr[count] = new Triangle(side1, side2, side3);
                    count++;
                }
            }
        } catch (CircleError | SquareError | RectangleError | TriangleError e) {
            System.out.println(e.getMessage());
        };
    }

    public static void Task2(){

        double min =0;

        double max = 0;
        //break at the first triangle and min = perimeter;
        for(int i =0; i < count; i++)
        {
            if(arr[i].getName() =="Triangle")
            {
                min = arr[i].getPerimeter();
                break;
            }
        }

        //check for min and max
        for(int i =0; i < count; i++)
        {
            if ( arr[i].getPerimeter()< min && arr[i].getName()=="Triangle")
            {
                min = arr[i].getPerimeter();
            }

            if(max<arr[i].getPerimeter() && arr[i].getName() == "Circle")
            {
                max = arr[i].getPerimeter();
            }
        }

        //remove array
        for(int i=0; i < count; i++)
        {
            if(arr[i].getPerimeter() == min && arr[i].getName() == "Triangle") {
                arr = removeTheElement(arr, i);
                count--;
                i--;
            }
            if(arr[i].getPerimeter() == max && arr[i].getName() == "Circle") {
                arr = removeTheElement(arr, i);
                count--;
                i--;
            }

        }
    }

    public static void Task3(){
        for(int i =0; i < count; i++)
        {
            if(arr[i].getName().equals("Triangle") )
            {
                SumOfTrianglesPerimeter += arr[i].getPerimeter();
            }

            if(arr[i].getName().equals("Parallelogram"))
            {
                SumOfParallelogramPerimeter +=arr[i].getPerimeter();
            }
        }
       System.out.println("------------Task 3----------------");
        System.out.println("Total perimeter of Parallelogram is: " + SumOfParallelogramPerimeter);
        System.out.println("Total perimeter of Triangle is: " + SumOfTrianglesPerimeter);
    }


    public static void main(String[] args) {


        try (BufferedReader br = new BufferedReader(new FileReader("/Users/admin/workshop2/Shapes.txt"))) {
            String s;
            while ((s = br.readLine()) != null) {
                String[] tokens = s.split(",");
                    Task1(tokens);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Task2();

        System.out.println(count + " shapes were created");
        for (int i = 0; i < count; i++) {
            System.out.println(arr[i].toString());
        }
        Task3();
    }
}


