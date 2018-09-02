import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Tests {

    @Test
    public void testGrid(){

        Grid grid = new Grid();

        grid.setX(5);
        grid.setY(3);

        Assert.assertEquals(5,grid.getX());
        Assert.assertEquals(3,grid.getY());
    }

    @Test
    public void testRobot(){
        Point point = new Point(5,2);
        Robot robot = new Robot(point,"N");

        Assert.assertEquals(5,robot.getPoint().getX());
        Assert.assertEquals(2,robot.getPoint().getY());
        Assert.assertEquals("N",robot.getOrientation());
    }

    @Test
    public void setMoveForward(){
        Point point = new Point(5,2);
        Robot robot = new Robot(point,"N");

        Grid grid = new Grid(5, 3);

        Movement movement = new MovementImp(robot,grid);
        movement.moveForward();

        Robot robot1 = ((MovementImp) movement).getRobot();

        Assert.assertEquals(5,robot1.getPoint().getX());
        Assert.assertEquals(3,robot1.getPoint().getY());
    }

    @Test
    public void setMoveLeft(){
        Point point = new Point(5,3);
        Robot robot = new Robot(point,"N");
        Movement movement = new MovementImp(robot);
        movement.moveLeft();
        Assert.assertEquals("W",((MovementImp) movement).getRobot().getOrientation());
        movement.moveLeft();
        Assert.assertEquals("S",((MovementImp) movement).getRobot().getOrientation());
        movement.moveLeft();
        Assert.assertEquals("E",((MovementImp) movement).getRobot().getOrientation());
        movement.moveLeft();
        Assert.assertEquals("N",((MovementImp) movement).getRobot().getOrientation());
    }

    @Test
    public void setMoveRight(){
        Point point = new Point(5,3);
        Robot robot = new Robot(point,"N");
        Movement movement = new MovementImp(robot);
        movement.moveRight();
        Assert.assertEquals("E",((MovementImp) movement).getRobot().getOrientation());
        movement.moveRight();
        Assert.assertEquals("S",((MovementImp) movement).getRobot().getOrientation());
        movement.moveRight();
        Assert.assertEquals("W",((MovementImp) movement).getRobot().getOrientation());
        movement.moveRight();
        Assert.assertEquals("N",((MovementImp) movement).getRobot().getOrientation());
    }



    @Test
    public void testMove(){
        Point point = new Point(1,1);
        Robot robot = new Robot(point,"E");

        Grid grid = new Grid(5, 3);

        String movementString = "RFRFRFRF";
        Movement movement = new MovementImp(robot,grid);
        movement.move(movementString);

        Robot robot1 = ((MovementImp) movement).getRobot();

        Assert.assertEquals(1,robot1.getPoint().getX());
        Assert.assertEquals(1,robot1.getPoint().getY());
        Assert.assertEquals("E",robot1.getOrientation());
    }

    @Test
    public void testMoveOutSide() {
        Point point = new Point(3,4);
        Robot robot = new Robot(point, "N");
        robot.setOrientation("N");

        Grid grid = new Grid(5, 3);

        String movementString = "FRRFLLFFRRFLL";
        Movement movement = new MovementImp(robot,grid);
        boolean out = ((MovementImp) movement).checkIfOutSideOfGrid(3,4);

        Assert.assertEquals(true,out);
    }

    @Test
    public void testMoveTest2(){
        Point point = new Point(3,2);
        Robot robot = new Robot(point,"N");

        Grid grid = new Grid(5,3);

        String movementString = "FRRFLLFFRRFLL";
        Movement movement = new MovementImp(robot,grid);
        movement.move(movementString);

        Robot robot1 = ((MovementImp) movement).getRobot();

        Assert.assertEquals(3,robot1.getPoint().getX());
        Assert.assertEquals(3,robot1.getPoint().getY());
        Assert.assertEquals("N",robot1.getOrientation());
    }

    @Test
    public void testGridPoints(){
        Grid grid = new Grid(5,3);
        Point point1 = new Point(1,1);
        Point point3 = new Point(1,2);
        Point point4 = new Point(1,3);


        Point point2 = new Point(1,1);
        grid.getPoints().add(point1);
        grid.getPoints().add(point3);
        grid.getPoints().add(point4);

        ArrayList arrayList = grid.getPoints();

        System.out.println(grid.getPoints().contains(point2));

        System.out.println(arrayList.indexOf(point2));
        System.out.println(grid.getPoints().indexOf(point2));

    }

    @Test
    public void testMoveTest3(){
        Point point1 = new Point(3,2);
        Robot robot1 = new Robot(point1,"N");
        Grid grid = new Grid(5,3);

        String movementString = "FRRFLLFFRRFLL";
        Movement movement = new MovementImp(robot1,grid);
        movement.move(movementString);

        System.out.println("------------------------------------------------------");

        Point point2 = new Point(0,3);
        Robot robot2 = new Robot(point2,"W");

        String movementString2 = "LLFFFLFLFL";
        Movement movement2 = new MovementImp(robot2,grid);
        movement2.move(movementString2);

        Robot robot3 = ((MovementImp) movement2).getRobot();

        Assert.assertEquals(2,robot3.getPoint().getX());
        Assert.assertEquals(3,robot3.getPoint().getY());
        Assert.assertEquals("S",robot3.getOrientation());
    }

    @Test
    public void setMoveLeft1(){

        String[] directions = {"N","E","S","W"};
        int test = Arrays.binarySearch(directions, "N");
        System.out.println(test);
        int test2 = Arrays.asList(directions).indexOf("N");
        System.out.println(test2);
        int test3 = directions.length;
        System.out.println(test3);

        /*Arrays.stream(a) 					// IntStream
                .boxed()						// Stream<Integer>
                .collect(Collectors.toList())   // List<Integer>
                .indexOf(target);*/

    }


}
