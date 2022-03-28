//This class demonstrates the My2DRectangle class.

public class Test {

    public static void main(String[] args) {

    //Create a rectangle. 
    double[] point;
    My2DRectangle r1 = new My2DRectangle(2, 2, 5.5, 4.9);
    point = new double[2];
    point[0] = 3;
    point[1] = 3;

    //Show rectangle property values of width and height.
    System.out.println("rectangle r1 is centered at (" + r1.getx() + ", " + r1.gety() + ") with width " + r1.getWidth() + " and height " + r1.getHeight());
    //Show the area of the rectangle.
    System.out.println("Area is " + r1.getArea());
    //Show the perimeter of the rectangle.
    System.out.println("Perimeter is " + r1.getPerimeter());
    //Show whether the rectangle contains the point (3, 3) inside it.
    System.out.println("r1 contains (3, 3) is " + r1.contains(point));
    //Show whether the rectangle contains the rectangle with a center point of (4, 5) and a width = 10.5 and a height = 3.2.
    System.out.println("r1.contains(new My2DRectangle(4, 5, 10.5, 3.2)) is " + r1.contains(new My2DRectangle(4, 5, 10.5, 3.2)));
    //Show whether there is any overlap between the rectangle and the rectangle with a center point of (3, 5) and a width = 2.3 and a height = 5.4.
    System.out.println("r1.overlaps(new My2DRectangle(3, 5, 2.3, 5.4)) is " + r1.overlaps(new My2DRectangle(3, 5, 2.3, 5.4)));
    }
}