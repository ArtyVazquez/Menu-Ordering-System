import org.example.ExtractInput;
import org.junit.Test;
import org.junit.Assert;

public class TestInput {

    @Test
    public void testOrderInput() {
        ExtractInput ip = new ExtractInput("Breakfast 1,2,3");
        Assert.assertTrue(ip.inputMatch());
    }

    @Test
    public void testOrderInput2() {
        ExtractInput ip = new ExtractInput("menu 1,2,3");
        Assert.assertFalse(ip.inputMatch());
    }

    @Test
    public void testOrderInput3() {
        ExtractInput ip = new ExtractInput("Breakfast 1,2,3,3,3");
        Assert.assertTrue(ip.inputMatch());
    }

    @Test
    public void testOrderInput4() {
        ExtractInput ip = new ExtractInput("Breakfast 1,2,4");
        Assert.assertFalse(ip.inputMatch());
    }

    @Test
    public void testOrderInput5() {
        ExtractInput ip = new ExtractInput("Breakfast 1,2,3,");
        Assert.assertFalse(ip.inputMatch());
    }


    @Test
    public void testOrderInput6() {
        ExtractInput ip = new ExtractInput("Lunch 1,2,3");
        Assert.assertTrue(ip.inputMatch());
    }

    @Test
    public void testOrderInput7() {
        ExtractInput ip = new ExtractInput("Lunch 1,3");
        Assert.assertTrue(ip.inputMatch());
    }

    @Test
    public void testOrderInput8() {
        ExtractInput ip = new ExtractInput("Dinner 1,3");
        Assert.assertTrue(ip.inputMatch());
    }

    @Test
    public void testOrderInput9() {
        ExtractInput ip = new ExtractInput("Dinner 1,3,4");
        Assert.assertTrue(ip.inputMatch());
    }

    @Test
    public void testOrderInput10() {
        ExtractInput ip = new ExtractInput("1,2,3,4");
        Assert.assertFalse(ip.inputMatch());
    }
}
