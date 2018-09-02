import java.util.Arrays;

public class MovementImp implements Movement {
    private Robot robot;
    private Grid grid;

    public MovementImp(Robot robot) {
        this.robot = robot;
    }

    public MovementImp() {
    }

    public MovementImp(Robot robot, Grid grid) {
        this.robot = robot;
        this.grid = grid;
    }

    String[] directions = {"N", "E", "S", "W"};


    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void moveNorth(String n) {

    }

    @Override
    public boolean moveForward() {
        boolean rt = false;
        robot.getOrientation();
        int y = robot.getPoint().getY();
        int x = robot.getPoint().getX();
        int newpositionY = y;
        int newpositionX = x;
        switch (robot.getOrientation()) {
            case "N":
                newpositionY = y + 1;
                break;
            case "S":
                newpositionY = y - 1;
                break;
            case "E":
                newpositionX = x + 1;
                break;
            case "W":
                newpositionX = x - 1;
                break;
        }
        Point point = new Point(newpositionX, newpositionY);

        if (!grid.getPoints().contains(point)) {
            if (checkIfOutSideOfGrid(newpositionX, newpositionY)) {
                grid.getPoints().add(point);
                robot.setLost("LOST");
                return true;
            }
            robot.getPoint().setX(newpositionX);
            robot.getPoint().setY(newpositionY);
        }
        return rt;
    }


    @Override
    public void moveLeft() {
        int in = Arrays.asList(directions).indexOf(robot.getOrientation());
        if (0 == in) {
            robot.setOrientation(directions[directions.length - 1]);
        } else {
            robot.setOrientation(directions[in - 1]);
        }
    }

    @Override
    public void moveRight() {
        int in = Arrays.asList(directions).indexOf(robot.getOrientation());
        int max = directions.length - 1;
        if (max == in) {
            robot.setOrientation(directions[0]);
        } else {
            robot.setOrientation(directions[in + 1]);
        }
    }

    @Override
    public void move(String movementString) {
        boolean rt = false;
        for (char a : movementString.toCharArray()) {
            switch (a) {
                case 'R':
                    moveRight();
                    break;
                case 'L':
                    moveLeft();
                    break;
                case 'F':
                    rt = moveForward();
                    break;
            }
            if (rt) {
                break;
            }
        }
    }

    public boolean checkIfOutSideOfGrid(int x, int y) {
        boolean rt = false;
        if (x > grid.getX() || x < 0 || y > grid.getY() || y < 0) {
            rt = true;
        }
        return rt;
    }
}
