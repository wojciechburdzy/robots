public class Robot {

    private Point point;
    private String orientation;
    private String lost="";

    public Robot() {
    }

    public Robot(Point point, String orientation) {
        this.point = point;
        this.orientation = orientation;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getLost() {
        return lost;
    }

    public void setLost(String lost) {
        this.lost = lost;
    }
}
