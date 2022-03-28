/*
5/2/2021
This class will define a rectangle template and its properties and methods.
*/
public class My2DRectangle {

    //Rectangle center point.
    private double x;
    private double y;
    //Rectangle dimensions.
    private double width;
    private double height;
    //Corner Points
    private double[] pointTL = new double[2];
    private double[] pointTR = new double[2];
    private double[] pointBR = new double[2];
    private double[] pointBL = new double[2];

    //Default constructor.
    public My2DRectangle() {

        this.setx(0);
        this.sety(0);
        this.setWidth(1);
        this.setHeight(1);
        //Determine the Cartesian grid corner points for the rectangle.
        setpointTL(x, y, width, height);
        setpointTR(x, y, width, height);
        setpointBR(x, y, width, height);
        setpointBL(x, y, width, height);
    }

    //Constructor when center point (x, y), width, and height are given.
    public My2DRectangle(double x, double y, double width, double height) {

        this.setx(x);
        this.sety(y);
        this.setWidth(width);
        this.setHeight(height);

        //Determine the Cartesian grid corner points for the rectangle.
        this.setpointTL(x, y, width, height);
        this.setpointTR(x, y, width, height);
        this.setpointBR(x, y, width, height);
        this.setpointBL(x, y, width, height);
    }

    public double getx() {
        return this.x;
    }

    public void setx(double num) {

        this.x = num;
    }
    public double gety() {

        return this.y;
    }
    public void sety(double num) {

        this.y = num;
    }
    public double getWidth() {

        return this.width;
    }

    public void setWidth(double num) {

        //Unlike Cartesian grid points, width and height are only a positive dimension.
        this.width = num;
    }

    public double getHeight() {

        return this.height;
    }

    public void setHeight(double num) {

        //Unlike Cartesian grid points, width and height are only a positive dimension.
        if(num > 0){
            
            this.height = num;
        }
    }

    //Corner Points getters and setters.
    //Top Left rectangle corner point.
    public double[] getpointTL() {

        return this.pointTL;
    }

    public void setpointTL(double x, double y, double width, double height) {

        double cornerX;
        double cornerY;

        //Calculate the (x, y) Cartesian coordinates based on the center point location and width/height
        //of the rectangle.
        cornerX = x - (width / 2);
        cornerY = y + (height / 2);
        this.pointTL[0] = cornerX;
        this.pointTL[1] = cornerY;
    }

    //Top Right rectangle corner point.
    public double[] getpointTR() {
        return this.pointTR;
    }

    public void setpointTR(double x, double y, double width, double height) {
        double cornerX;
        double cornerY;

        //Calculate the (x, y) Cartesian coordinates based on the center point location and width/height
        //of the rectangle.
        cornerX = x + (width / 2);
        cornerY = y + (height / 2);
        this.pointTR[0] = cornerX;
        this.pointTR[1] = cornerY;
    }

    //Bottom Right rectangle corner point.
    public double[] getpointBR() {

        return this.pointBR;
    }

    public void setpointBR(double x, double y, double width, double height) {

        double cornerX;
        double cornerY;

        //Calculate the (x, y) Cartesian coordinates based on the center point location and width/height
        //of the rectangle.
        cornerX = x + (width / 2);
        cornerY = y - (height / 2);
        this.pointBR[0] = cornerX;
        this.pointBR[1] = cornerY;
    }

    //Bottom Left rectangle corner point.
    public double[] getpointBL() {

        return this.pointBL;
    }

    public void setpointBL(double x, double y, double width, double height) {
        double cornerX;
        double cornerY;

        //Calculate the (x, y) Cartesian coordinates based on the center point location and width/height
        //of the rectangle.
        cornerX = x - (width / 2);
        cornerY = y - (height / 2);

        this.pointBL[0] = cornerX;
        this.pointBL[1] = cornerY;
    }          

    public double getArea() {

        return this.width * this.height;
    }

    public double getPerimeter() {
        return 2 * width + 2 * height;
    }

    //Determines whether the rectangle passed in is completely inside this rectangle.
    //Inside is defined as not being along the same x or y axis of this rectangle, but at least an
    //infinitesimally small point inside a border.
    public boolean contains(My2DRectangleTimGutzke r) {

        //Check if each guest rectangle corner point is inside the two x and y limitations of each of this rectangle's corner points.
        //Return false if any corner point fails the test.
        if(!this.contains(r.pointTL)) {

        return false;
        }

        if(!this.contains(r.pointTR)) {

        return false;
        }

        if(!this.contains(r.pointBR)) {

        return false;
        }

        if(!this.contains(r.pointBL)) {

        return false;
        }

        //Tested point met all necessary Cartesian conditions for being classified as inside this rectangle.
        return true;
    }

    //Returns true if the point being tested is inside this rectangle class object.
    public boolean contains(double[] pointTested) {

        //The x and y coordinate of a point must be in a specific directional relationship with any rectangle corner point.
        //For example a point must be to the right (x) of a rectangle's top left corner point and below (y) that corner point
        //in order for that point to meet one of the 4 conditions of being contained in the perimeter of that rectangle.
        if(pointTested[0] < this.pointTL[0] || pointTested[1] > this.pointTL[1]) {

        return false;
        }

        //Point must be to the left of the x line and above the y line of the top right corner of the rectangle to be contained within it.
        if(pointTested[0] > this.pointTR[0] || pointTested[1] > this.pointTR[1]) {
        return false;

        }

        //Point must be to the left of the x line and above the y line of the bottom right corner of the rectangle to be contained within it.
        if(pointTested[0] > this.pointBR[0] || pointTested[1] < this.pointBR[1]) {

        return false;

        }
        
        //Point must be to the right of the x line and above the y line of the bottom left corner of the rectangle to be contained within it.
        if(pointTested[0] < this.pointBL[0] || pointTested[1] < this.pointBL[1]) {
        return false;
        }

        return true;
    }

    //Determines whether a rectangle passed in is partially within this rectangle.
    //Note that being completely inside this rectangle is not defined as overlapping.
    public boolean overlaps(My2DRectangleTimGutzke r) {

        boolean TL;
        boolean TR;
        boolean BR;
        boolean BL;
        //Check if each guest rectangle corner point is inside the two x and y limitations of each of this rectangle's corner points.
        if(!this.contains(r.pointTL)) {

        TL = false;
        }

        else {
        TL = true;
        }

        if(!this.contains(r.pointTR)) {

        TR = false;
        }
        else{
        TR = true;
        }

        if(!this.contains(r.pointBR)) {

        BR = false;
        }

        else {

        BR = true;
        }

        if(!this.contains(r.pointBL)) {

        BL = false;
        }

        else {

        BL = true;
        }

        //If the whole rectangle is contained in this rectangle, then they do not overlap.
        //Else if at least one corner point but not all corner points are in the rectangle, then the rectangles overlap.
        if(TL && TR && BR && BL) {

        return false;
        }
        else if(TL || TR || BR || BL) {
        return true;
        }

        //If the last else if did not return true, then no corner point tested is inside this rectangle.
        return false;
    }
}