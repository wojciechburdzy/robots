import java.util.ArrayList;

public class Grid {
    private int x;
    private int y;

    private ArrayList<Point> points;

    public Grid() {
    }

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
        if(null==points){
            points = new ArrayList<>();
        }
    }

    @Override
    public boolean equals (Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Point point = (Point) object;
            if (this.x == point.getX() && this.y == point.getY()) {
                result = true;
            }
        }
        return result;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
}
