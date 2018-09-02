import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {


    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./input.txt");
        Scanner sc = new Scanner(file);

        String out = "";

        Grid grid = null;
        Robot robot;
        Point point;
        Movement movement;

        while (sc.hasNextLine()) {
            String[] values = sc.nextLine().split("\\s");

            if (values.length == 2) {
                int x = Integer.parseInt(values[0]);
                int y = Integer.parseInt(values[1]);
                if(50>=x && 50>=y) {
                    grid = new Grid(x, y);
                }
            }
            if (values.length == 3) {
                if (null == grid) {
                    System.out.println("Planed yet not created");
                } else {
                    int x = Integer.parseInt(values[0]);
                    int y = Integer.parseInt(values[1]);
                    if(50>=x && 50>=y) {
                        String orientation = values[2];
                        point = new Point(x, y);
                        if (!grid.getPoints().contains(point)) {
                            robot = new Robot(point, orientation);
                            values = sc.nextLine().split("\\s");
                            if (values.length == 1) {
                                String s = values[0];
                                if (100>s.length()) {
                                    movement = new MovementImp(robot, grid);
                                    movement.move(s);
                                    out = ((MovementImp) movement).getRobot().getPoint().getX() + " "
                                            + ((MovementImp) movement).getRobot().getPoint().getY() + " "
                                            + ((MovementImp) movement).getRobot().getOrientation() + " "
                                            + ((MovementImp) movement).getRobot().getLost();
                                    System.out.println(out);
                                }
                            }
                        } else {
                            System.out.println("Wrong coordinate of the robot");
                        }
                    }
                }
            }


        }

    }
}
