import org.junit.Assert;
import org.junit.Test;



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

        Robot robot = new Robot();

        robot.setX(5);
        robot.setY(3);
        robot.setOrientation("N");


        Assert.assertEquals(5,robot.getX());
        Assert.assertEquals(3,robot.getY());
        Assert.assertEquals("N",robot.getOrientation());
    }
}
