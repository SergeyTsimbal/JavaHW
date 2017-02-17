import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculateTest {
    Calculate calc;
    @Before
    public void runT(){
        calc = new Calculate();
    }
    @Test
    public void plus() throws Exception {
        int res = calc.plus(1, 1);
        Assert.assertEquals(res, 2);

    }

    @Test
    public void minus() throws Exception {
        int res = calc.minus(2, 1);
        Assert.assertEquals(res, 1);

    }

    @Test
    public void multiplied() throws Exception {
        int res = calc.multiplied(2, 2);
        Assert.assertEquals(res, 4);

    }

    @Test
    public void divided() throws Exception {
        double res = calc.divided(10, 5);
        System.out.println(res);
        Assert.assertTrue(res == 2);
    }

}