package exercise;

// BEGIN
public class Segment {
    private static final int amountOfPoints = 2 ;
    private Point beginPoint;
    private Point endPoint;

    Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }
    public Point getMidPoint() {
        return new Point((getBeginPoint().getX() + getEndPoint().getX()) / amountOfPoints,
                (getBeginPoint().getY() + getEndPoint().getY()) / amountOfPoints);
    }
}
// END
